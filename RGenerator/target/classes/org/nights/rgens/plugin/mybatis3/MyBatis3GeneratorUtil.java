package org.nights.rgens.plugin.mybatis3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.ColumnOverride;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.nights.rgen.core.FtlClassInfo;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class MyBatis3GeneratorUtil {

	public static final String tmpSource = "src/main/java";

	public static String packShortName = "";

	public static void main(String[] args) throws Exception {


		for (String name : new String[] { "tfg" }) {
			packShortName = name;
			Def.GEN_CTRL = false;
			String xmlName = "generator-" + name + "-config-osgi.xml";
			testGenerateMyBatis(xmlName, tmpSource);
		}

	}

	public static List<String> getTableList(JDBCConnectionConfiguration cfg, String schema) {
		List<String> ret = new ArrayList<String>();
		try {
			Class.forName(cfg.getDriverClass());
			Connection conn = DriverManager.getConnection(cfg.getConnectionURL(), cfg.getUserId(), cfg.getPassword());
			DatabaseMetaData md = conn.getMetaData();
			ResultSet rs = md.getTables(null, schema, "%", null);
			// System.out.println(rs);

			while (rs.next()) {
				// System.out.println(rs.getString(3));
				ret.add(rs.getString(3));
			}
			rs.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public static void testGenerateMyBatis(String xmlName, String tmpSource) throws Exception {
		List<String> warnings = new ArrayList<String>();

		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(MyBatis3GeneratorUtil.class.getResourceAsStream(xmlName));
		try {
			List<Context> configs = config.getContexts();
			for (Context context : configs) {

				List<List<String>> tbslist = new ArrayList<List<String>>();

				List<String> tbPkgs = new ArrayList<String>();
				for (TableConfiguration otb : context.getTableConfigurations()) {
					String tbschema = otb.getSchema();

					List<String> tbs = getTableList(context.getJdbcConnectionConfiguration(), tbschema);
					String tbptn = otb.getTableName();
					String tbpkg = otb.getDomainObjectName();
					tbPkgs.add(tbpkg);
					List<String> subtbs = new ArrayList<String>();
					tbslist.add(subtbs);
					for (String tb : tbs) {
						if (tb.matches(tbptn)) {
							subtbs.add(tbschema + "." + tb);
						}
					}
				}
				System.out.println("tbs::" + tbslist);
				String javamodelPkg = context.getJavaModelGeneratorConfiguration().getTargetPackage();
				String javaclientPkg = context.getJavaClientGeneratorConfiguration().getTargetPackage();
				List<FtlClassInfo> configClasses = new ArrayList<FtlClassInfo>();

				List<ColumnOverride> columnOverrides = null;
				for (int i = 0; i < tbslist.size(); i++) {
					if (context.getTableConfigurations().size() > 0) {
						columnOverrides = context.getTableConfigurations().get(0).getColumnOverrides();
					}
					context.getTableConfigurations().clear();
					context.getProperties().put("classinfos", configClasses);
					context.getJavaModelGeneratorConfiguration().setTargetPackage(javamodelPkg + "." + tbPkgs.get(i) + ".entity");
					// context.getSqlMapGeneratorConfiguration().setTargetPackage(sqlmapPkg+"."+tbPkgs.get(i)+".mbatis");
					context.getJavaClientGeneratorConfiguration().setTargetPackage(javaclientPkg + "." + tbPkgs.get(i) + ".mapper");

					for (String tbschema : tbslist.get(i)) {
						TableConfiguration ntbc = new TableConfiguration(context);
						if (!"null".equals(tbschema.split("\\.")[0])) {
							ntbc.setSchema(tbschema.split("\\.")[0]);
						}
						ntbc.setTableName(tbschema.split("\\.")[1]);
						if (columnOverrides != null) {
							for (ColumnOverride o : columnOverrides) {
								ntbc.addColumnOverride(o);
							}
						}
						ntbc.setDomainObjectName(ChangeName.toDomainName(ntbc.getTableName()));
						context.addTableConfiguration(ntbc);
					}
					genContext(config, context, configClasses);
				}
				// System.out.println(context.getJavaClientGeneratorConfiguration().getTargetProject());
				genDaoSpringConfig(configClasses, tmpSource, "Mybatis3DaoConfig.ftl", new File(context.getJavaClientGeneratorConfiguration().getTargetProject()
						+ "/../resources"));

				String pbdir = context.getJavaClientGeneratorConfiguration().getProperty("pbdir");

				if (StringUtils.isNotBlank(pbdir)) {
					System.out.println("pbdir==" + pbdir);
					genProtobuf(configClasses, tmpSource, "Protobuf.ftl", new File(pbdir));
				}

				String sodir = context.getJavaClientGeneratorConfiguration().getProperty("sodir") + File.separator
						+ javamodelPkg.replaceAll("\\.", File.separator) + File.separator + "so";
				if (StringUtils.isNotBlank(sodir)) {
					System.out.println("sbdir==" + sodir); 
					genScalaBeans(configClasses, tmpSource, "scala.ftl", new File(sodir, packShortName.toUpperCase() + ".scala"));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void genContext(Configuration config, Context context, List<FtlClassInfo> configClasses) throws Exception {
		List<String> warnings = new ArrayList<String>();
		DefaultShellCallback shellCallback = new DefaultShellCallback(true);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, shellCallback, warnings);
		myBatisGenerator.generate(null);

		String targetSource = "src/gens/java";
		List<FtlClassInfo> clazzinfos = new ArrayList<FtlClassInfo>();
		targetSource = context.getJavaModelGeneratorConfiguration().getTargetProject();
		genDao(context, clazzinfos, tmpSource);
	}

	private static void genDao(Context config, List<FtlClassInfo> clazzinfos, String tmpSource) {
		String daoTargetSource = config.getJavaClientGeneratorConfiguration().getTargetPackage();
		List<TableConfiguration> list = config.getTableConfigurations();
		for (TableConfiguration table : list) {
			FtlClassInfo classinfo = new FtlClassInfo();
			classinfo.setDomainClass(table.getDomainObjectName());
			classinfo.setDomainObject(StringUtils.uncapitalize(table.getDomainObjectName()));
			classinfo.setPackageName(StringUtils.substringBeforeLast(daoTargetSource, "."));
			classinfo.setTablename(table.getTableName().toUpperCase());
			clazzinfos.add(classinfo);
		}
	}

	public static File getDirectory(String targetSource, String targetPackage, String domain) {
		File project = new File(targetSource);
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(targetPackage, "."); //$NON-NLS-1$
		while (st.hasMoreTokens()) {
			sb.append(st.nextToken());
			sb.append(File.separatorChar);
		}
		st = new StringTokenizer(domain, "."); //$NON-NLS-1$
		while (st.hasMoreTokens()) {
			sb.append(st.nextToken());
			sb.append(File.separatorChar);
		}
		File directory = new File(project, sb.toString());
		if (!directory.isDirectory()) {
			boolean rc = directory.mkdirs();
			if (!rc) {
				throw new RuntimeException("can't create " + directory.getAbsolutePath());
			}
		}
		return directory;
	}

	public static void genDaoSpringConfig(List<FtlClassInfo> clazzinfos, String tempSource, String tmplname, File resdir) {
		try {
			freemarker.template.Configuration cfg = new freemarker.template.Configuration();
			cfg.setDirectoryForTemplateLoading(new File(tempSource));
			DefaultObjectWrapper ow = new DefaultObjectWrapper();
			cfg.setObjectWrapper(ow);
			Template temp = cfg.getTemplate(tmplname);
			/* Create a data-model */
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("clazzinfos", clazzinfos);
			resdir.mkdirs();
			File dst = new File(resdir, "SpringContext-daoConfig-" + packShortName + ".xml");
			System.out.println(dst.getAbsolutePath());
			dst.getParentFile().mkdirs();
			FileOutputStream fout = new FileOutputStream(dst);
			Writer out = new OutputStreamWriter(fout);
			temp.process(root, out);
			out.flush();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void genProtobuf(List<FtlClassInfo> clazzinfos, String tempSource, String tmplname, File pbdir) {
		try {
			freemarker.template.Configuration cfg = new freemarker.template.Configuration();
			cfg.setDirectoryForTemplateLoading(new File(tempSource));
			DefaultObjectWrapper ow = new DefaultObjectWrapper();
			cfg.setObjectWrapper(ow);
			Template temp = cfg.getTemplate(tmplname);
			/* Create a data-model */
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("clazzinfos", clazzinfos);
			root.put("packageName", clazzinfos.get(0).getPackageName().replaceAll("\\" + File.separator, "."));
			pbdir.getParentFile().mkdirs();
			FileOutputStream fout = new FileOutputStream(pbdir);
			Writer out = new OutputStreamWriter(fout);
			System.out.println("root==" + root);
			temp.process(root, out);
			out.flush();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void genScalaBeans(List<FtlClassInfo> clazzinfos, String tempSource, String tmplname, File sodir) {
		try {
			freemarker.template.Configuration cfg = new freemarker.template.Configuration();
			cfg.setDirectoryForTemplateLoading(new File(tempSource));
			DefaultObjectWrapper ow = new DefaultObjectWrapper();
			cfg.setObjectWrapper(ow);
			Template temp = cfg.getTemplate(tmplname);
			/* Create a data-model */
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("clazzinfos", clazzinfos);
			root.put("packShortName", packShortName.toUpperCase());
			root.put("packageName", clazzinfos.get(0).getPackageName().replaceAll("\\" + File.separator, "."));
			sodir.getParentFile().mkdirs();
			FileOutputStream fout = new FileOutputStream(sodir);
			Writer out = new OutputStreamWriter(fout);
			System.out.println("root==" + root);
			temp.process(root, out);
			out.flush();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public static void genSqlMapXml(List<FtlClassInfo> clazzinfos, String
	// tempSource,
	// String tmplname, File daoDir) {
	// try {
	// freemarker.template.Configuration cfg = new
	// freemarker.template.Configuration();
	// cfg.setDirectoryForTemplateLoading(new File(tempSource));
	// DefaultObjectWrapper ow = new DefaultObjectWrapper();
	// cfg.setObjectWrapper(ow);
	// Template temp = cfg.getTemplate(tmplname);
	// /* Create a data-model */
	// Map<String, Object> root = new HashMap<String, Object>();
	// root.put("clazzinfos", clazzinfos);
	// File dst = new File(daoDir, "sql-map-config.xml");
	// System.out.println(dst.getAbsolutePath());
	// dst.getParentFile().mkdirs();
	// FileOutputStream fout = new FileOutputStream(dst);
	// Writer out = new OutputStreamWriter(fout);
	// temp.process(root, out);
	// out.flush();
	// fout.close();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	public static String TableField2JavaField(String tableField) {
		StringBuilder sb = new StringBuilder();
		tableField = StringUtils.lowerCase(tableField);
		String[] ss = StringUtils.split(tableField, "_");
		sb.append(ss[0]);
		if (ss.length > 1) {
			for (int i = 1; i < ss.length; i++) {
				sb.append(StringUtils.capitalize(ss[i]));
			}
		}
		return sb.toString();
	}

}
