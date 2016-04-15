package org.nights.rgens.plugin.mybatis3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.util.JavaBeansUtil;
import org.nights.rgen.core.FtlClassInfo;
import org.nights.rgen.core.FtlClassInfo.Columinfo;

import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class DaoExamplePlugin extends PluginAdapter {

	public DaoExamplePlugin() {
		super();
	}

	static String targetSource = "src/gens/java";



	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		StringBuffer sb = new StringBuffer();
		List<IntrospectedColumn> ics = introspectedTable.getAllColumns();
		for (IntrospectedColumn ic : ics) {
			String fieldName = StringUtils.capitalize(MyBatis3GeneratorUtil
					.TableField2JavaField(ic.getActualColumnName()));
			String getterName = "get" + fieldName;
			String andEqualTo = "and" + fieldName + "EqualTo";
			sb.append("\t\t\t\t")
					.append("if(record." + getterName + "()!=null){")
					.append("\n");
			sb.append("\t\t\t\t")
					.append("criteria." + andEqualTo + "(record." + getterName
							+ "());").append("\n");
			sb.append("\t\t\t\t").append("}").append("\n");
		}

		List<IntrospectedColumn> keyColumns = introspectedTable
				.getPrimaryKeyColumns();
		List<String> keyList = new ArrayList<String>();
		for (IntrospectedColumn keyColumn : keyColumns) {
			String fieldName = StringUtils.capitalize(MyBatis3GeneratorUtil
					.TableField2JavaField(keyColumn.getActualColumnName()));
			keyList.add(fieldName);
		}
		List<FtlClassInfo> clazzinfos = new ArrayList<FtlClassInfo>();
		TableConfiguration tableConfig = introspectedTable
				.getTableConfiguration();
		String daoTargetSource = introspectedTable.getContext()
				.getJavaClientGeneratorConfiguration().getTargetPackage();

		targetSource = getContext().getJavaModelGeneratorConfiguration()
				.getTargetProject();
		
		genDao(tableConfig, daoTargetSource, clazzinfos,
				MyBatis3GeneratorUtil.tmpSource, sb.toString(), keyList,introspectedTable.getNonBLOBColumns(),keyColumns.get(0).getActualColumnName());
		((List<FtlClassInfo>)getContext().getProperties().get("classinfos")).addAll(clazzinfos);
//		System.out.println("classinfs="+getContext().getProperties().get("classinfos"));

		
		return true;
	}

	private static void genDao(TableConfiguration tableConfig,
			String daoTargetSource, List<FtlClassInfo> clazzinfos,
			String tmpSource, String exampleBody, List<String> keyList,List<IntrospectedColumn> columns,String keyCol) {
		FtlClassInfo classinfo = new FtlClassInfo();
		classinfo.setDomainClass(tableConfig.getDomainObjectName());
		classinfo.setDomainObject(StringUtils.uncapitalize(tableConfig
				.getDomainObjectName()));
		classinfo.setPackageName(StringUtils.substringBeforeLast(
				daoTargetSource, "."));
		classinfo.setTablename(tableConfig.getTableName().toUpperCase());
		StringBuffer sb=new StringBuffer(); 
		classinfo.setKeycol(keyCol);
		for ( IntrospectedColumn col:columns){
			if(sb.length()>0)sb.append(",").append(col.getActualColumnName());
			else sb.append(col.getActualColumnName());
			classinfo.getColumnAndProps().add(new String[]{col.getActualColumnName(),col.getDefaultValue(),
					"get"+StringUtils.capitalize(col.getJavaProperty()),
					col.getJavaProperty(),
					col.getFullyQualifiedJavaType().getShortName()
			});
			classinfo.getColumnInfos().add(new Columinfo(jdbctype2PBType(col.getJdbcType()),col.getActualColumnName().toLowerCase()
					,jdbctype2SOType(col.getJdbcType()),col.getActualColumnName().toUpperCase()
					));
		}
		classinfo.setColumns(sb.toString());
		clazzinfos.add(classinfo);
		
		System.out.println("gen dao:columns:"+sb.toString());
		File daoDir = MyBatis3GeneratorUtil.getDirectory(targetSource,
				StringUtils.substringBeforeLast(daoTargetSource, "."), "dao");
		// genFtl(classinfo, tmpSource, "Mybatis3DynamicTableDao.ftl",daoDir,
		// "Dao",exampleBody);
		genFtl(classinfo, tmpSource, "Mybatis3StaticTableDao.ftl", daoDir,
				"Dao", exampleBody);

		if (Def.GEN_CTRL) {
			File ctrlDir = MyBatis3GeneratorUtil.getDirectory(targetSource,
					Def.ACTION_PACK, "action");

			ctrlFtl(classinfo, tmpSource, "Ctrl.ftl", ctrlDir, "Ctrl", keyList);
		}
	}
	
	public static String jdbctype2PBType(int type){
		if(type==JdbcType.INTEGER.TYPE_CODE){
			return "int32";
		}
		else if(type==JdbcType.DECIMAL.TYPE_CODE||type==JdbcType.DOUBLE.TYPE_CODE||type==JdbcType.FLOAT.TYPE_CODE){
			return "double";
		}
		else if(type==JdbcType.BIGINT.TYPE_CODE||type==JdbcType.BIGINT.TYPE_CODE||type==JdbcType.SMALLINT.TYPE_CODE){
			return "int64";
		}
		else if(type==JdbcType.TIMESTAMP.TYPE_CODE){
			return "int64";
		}
		return "string";
	}

	
	public static String jdbctype2SOType(int type){
		if(type==JdbcType.INTEGER.TYPE_CODE){
			return "Option[Int]";
		}
		else if(type==JdbcType.DECIMAL.TYPE_CODE||type==JdbcType.DOUBLE.TYPE_CODE||type==JdbcType.FLOAT.TYPE_CODE){
			return "Option[Double]";
		}
		else if(type==JdbcType.BIGINT.TYPE_CODE||type==JdbcType.BIGINT.TYPE_CODE||type==JdbcType.SMALLINT.TYPE_CODE){
			return "Option[Int]";
		}
		else if(type==JdbcType.BOOLEAN.TYPE_CODE){
			return "Option[Boolean]";
		}
		else if(type==JdbcType.CHAR.TYPE_CODE){
			return "Option[Char]";
		}
		else if(type==JdbcType.DECIMAL.TYPE_CODE){
			return "BigDecimal";
		}
		else if(type==JdbcType.DATE.TYPE_CODE){
			return "Date";
		}
		else if(type==JdbcType.TIMESTAMP.TYPE_CODE){
			return "Timestamp";
		}
		return "String";
	}
	
	
	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		topLevelClass.addField(new Field("selectCols", FullyQualifiedJavaType.getStringInstance()));
		return super.modelExampleClassGenerated(topLevelClass, introspectedTable);
	}

	public static void genFtl(FtlClassInfo clazzinfo, String tempSource,
			String tmplname, File daoDir, String end, String exampleBody) {
		try {
			freemarker.template.Configuration cfg = new freemarker.template.Configuration();
			cfg.setDirectoryForTemplateLoading(new File(tempSource));
			DefaultObjectWrapper ow = new DefaultObjectWrapper();
			cfg.setObjectWrapper(ow);
			Template temp = cfg.getTemplate(tmplname);
			/* Create a data-model */
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("domainClazz", clazzinfo.getDomainClass());
			root.put("domainObject", clazzinfo.getDomainObject());
			root.put("clazzinfo", clazzinfo);

			root.put(
					"packageName",
					clazzinfo.getPackageName().replaceAll(
							"\\" + File.separator, "."));
			root.put("exampleBody", exampleBody);
			File dst = new File(daoDir, clazzinfo.getDomainClass() + end
					+ ".java");
			System.out.println("genFtl::" + dst.getAbsolutePath());
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

	public static void ctrlFtl(FtlClassInfo clazzinfo, String tempSource,
			String tmplname, File daoDir, String end, List<String> keyList) {
		try {
			freemarker.template.Configuration cfg = new freemarker.template.Configuration();
			cfg.setDirectoryForTemplateLoading(new File(tempSource));
			DefaultObjectWrapper ow = new DefaultObjectWrapper();
			cfg.setObjectWrapper(ow);
			Template temp = cfg.getTemplate(tmplname);
			/* Create a data-model */
			Map<String, Object> root = new HashMap<String, Object>();
			root.put("domainClazz", clazzinfo.getDomainClass());
			root.put("keyList", keyList);
			root.put("clazzinfo", clazzinfo);
			root.put(
					"packageName",
					clazzinfo.getPackageName().replaceAll(
							"\\" + File.separator, "."));
			File dst = new File(daoDir, clazzinfo.getDomainClass() + end
					+ ".java");
			dst.getParentFile().mkdirs();
			FileOutputStream fout = new FileOutputStream(dst);
			Writer out = new OutputStreamWriter(fout);
			System.out.println("root=="+root);
			temp.process(root, out);
			out.flush();
			fout.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	

	@Override
	public boolean validate(List<String> arg0) {
		System.out.println("validate:" + arg0);
		return true;
	}

	public static void main(String[] args) {
		System.out.println(JavaBeansUtil.getCamelCaseString("result_count",
				true));
	}
}
