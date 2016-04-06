package org.nights.rgens.plugin.mybatis3;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class SqlDaoSupportPlugin extends PluginAdapter {

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}
	
	@Override
	public boolean clientGenerated(Interface interfaze,
			TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		// TODO add SqlDaoSupport
		String daoName = "StaticTableDaoSupport";
//		String daoName = "SqlDaoSupport";
		String pojo = introspectedTable.getBaseRecordType();
		String example = introspectedTable.getExampleType();
		FullyQualifiedJavaType exampletype = new FullyQualifiedJavaType(example);
		interfaze.addSuperInterface(new FullyQualifiedJavaType(daoName+"<"
				+ pojo + "," + example + ","
				+ introspectedTable.getPrimaryKeyType() + ">"));
		interfaze.addImportedType(new FullyQualifiedJavaType(
				"onight.tfw.ojpa.ordb."+daoName));
//		Method method = new Method();
		
		return true;
	}
	
	@Override
	public boolean providerGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		return true;
	}
}
