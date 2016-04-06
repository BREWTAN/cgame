package org.nights.rgens.plugin.mybatis3;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.InnerClass;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class MySqlJavaPlugin extends PluginAdapter {

	@Override
	public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// for(Field field :topLevelClass.getFields()){
		// field.addAnnotation("@Nullable");
		// }
		// topLevelClass.addImportedType("org.apache.avro.reflect.Nullable");
		topLevelClass
				.addImportedType("org.codehaus.jackson.map.annotate.JsonSerialize");
//		topLevelClass
//				.addImportedType("onight.tfw.ojpa.api.CustomDateSerializer");
		topLevelClass.addImportedType("onight.tfw.ojpa.api.annotations.Tab");

		topLevelClass.addAnnotation("@Tab(name=\""
				+ introspectedTable
						.getAliasedFullyQualifiedTableNameAtRuntime() + "\")");
		topLevelClass.addImportedType("lombok.AllArgsConstructor");
		topLevelClass.addImportedType("lombok.NoArgsConstructor");
		topLevelClass.addAnnotation("@AllArgsConstructor");
		
		topLevelClass.addAnnotation("@NoArgsConstructor");
		return true;
	}

	
	@Override
	public boolean modelGetterMethodGenerated(Method method,
			TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
			IntrospectedTable introspectedTable, ModelClassType modelClassType) {
		if (introspectedColumn.getFullyQualifiedJavaType()
				.getFullyQualifiedName().equalsIgnoreCase("java.util.Date")) {
//			method.addAnnotation("@JsonSerialize(using = CustomDateSerializer.class)");
		}

		super.modelGetterMethodGenerated(method, topLevelClass,
				introspectedColumn, introspectedTable, modelClassType);
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// for(Field field :topLevelClass.getFields()){
		// field.addAnnotation("@Nullable");
		// }

		topLevelClass.addImportedType("lombok.AllArgsConstructor");
		topLevelClass.addImportedType("lombok.NoArgsConstructor");
		topLevelClass.addAnnotation("@AllArgsConstructor");
		topLevelClass.addAnnotation("@NoArgsConstructor");

		// topLevelClass.addImportedType("org.apache.avro.reflect.Nullable");
		return true;
	}

	@Override
	public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		Field field = new Field();
		field.setName("offset");
		field.setType(FullyQualifiedJavaType.getIntInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		topLevelClass.addField(field);

		topLevelClass.addImportedType("lombok.Data");
		topLevelClass.addImportedType("lombok.NoArgsConstructor");
		topLevelClass.addAnnotation("@Data");
		for (InnerClass ic : topLevelClass.getInnerClasses()) {
			ic.setVisibility(JavaVisibility.PUBLIC);
			if (!ic.getType().getFullyQualifiedName().equals("Criteria")) {
				ic.addAnnotation("@Data");
			}
			if (ic.getType().getFullyQualifiedName().equals("Criterion")) {
				ic.addAnnotation("@NoArgsConstructor");
			}
			for (Method method : ic.getMethods()) {
				method.setVisibility(JavaVisibility.PUBLIC);
			}
		}

		field = new Field();
		field.setName("limit");
		field.setType(FullyQualifiedJavaType.getIntInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		topLevelClass.addField(field);

		Method method = new Method();
		method.setName("setOffset");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType
				.getIntInstance(), "offset"));
		method.setReturnType(null);
		method.addBodyLine(" this.offset = offset;");
		topLevelClass.addMethod(method);

		method = new Method();
		method.setName("getOffset");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.addBodyLine("  return offset;");
		topLevelClass.addMethod(method);

		method = new Method();
		method.setName("setLimit");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType
				.getIntInstance(), "limit"));
		method.setReturnType(null);
		method.addBodyLine(" this.limit = limit;");
		topLevelClass.addMethod(method);

		method = new Method();
		method.setName("getLimit");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getIntInstance());
		method.addBodyLine("  return limit;");
		topLevelClass.addMethod(method);

		field = new Field();
		field.setName("sumCol");
		field.setType(FullyQualifiedJavaType.getStringInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		topLevelClass.addField(field);

		method = new Method();
		method.setName("setSumCol");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType
				.getStringInstance(), "sumCol"));
		method.setReturnType(null);
		method.addBodyLine(" this.sumCol = sumCol;");
		topLevelClass.addMethod(method);

		method = new Method();
		method.setName("getSumCol");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.addBodyLine("  return sumCol;");
		topLevelClass.addMethod(method);

		field = new Field();
		field.setName("groupSelClause");
		field.setType(FullyQualifiedJavaType.getStringInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		topLevelClass.addField(field);

		method = new Method();
		method.setName("setGroupSelClause");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType
				.getStringInstance(), "groupSelClause"));
		method.setReturnType(null);
		method.addBodyLine(" this.groupSelClause = groupSelClause;");

		topLevelClass.addMethod(method);

		method = new Method();
		method.setName("getGroupSelClause");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.addBodyLine("  return groupSelClause;");
		topLevelClass.addMethod(method);

		field = new Field();
		field.setName("groupByClause");
		field.setType(FullyQualifiedJavaType.getStringInstance());
		field.setVisibility(JavaVisibility.PROTECTED);
		topLevelClass.addField(field);

		method = new Method();
		method.setName("setGroupByClause");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.addParameter(new Parameter(FullyQualifiedJavaType
				.getStringInstance(), "groupByClause"));
		method.setReturnType(null);
		method.addBodyLine(" this.groupByClause = groupByClause;");
		topLevelClass.addMethod(method);

		method = new Method();
		method.setName("getGroupByClause");
		method.setVisibility(JavaVisibility.PUBLIC);
		method.setReturnType(FullyQualifiedJavaType.getStringInstance());
		method.addBodyLine("  return groupByClause;");
		topLevelClass.addMethod(method);

		List<Method> methods = topLevelClass.getMethods();
		for (Method mod : methods) {
			if (mod.getName().equals("clear")) {
				mod.addBodyLine("this.offset= 0;");
				mod.addBodyLine("this.limit= Integer.MAX_VALUE;");
				mod.addBodyLine("this.sumCol=null;");
				mod.addBodyLine("this.groupSelClause=null;");
				mod.addBodyLine("this.groupByClause=null;");
			}
			String examplename = introspectedTable.getExampleType().substring(
					introspectedTable.getExampleType().lastIndexOf(".") + 1);
			if (mod.getName().equals(examplename)) {
				mod.addBodyLine("offset = 0;");
				mod.addBodyLine("limit = Integer.MAX_VALUE;");
			}
		}
		return true;
	}

	@Override
	public boolean providerGenerated(TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		// TODO providerGenerated
		String tableName = introspectedTable.getTableConfiguration()
				.getTableName();
//		 ----------------truncate provider---------------
//		 Method method = new Method();
//		 method.setName("truncate");
//		 method.setVisibility(JavaVisibility.PUBLIC);
//		 method.setReturnType(null);
//		 method.addBodyLine("return \"truncate "+tableName+"\";");
//		 topLevelClass.addMethod(method);
//		 ----------------truncate provider---------------
		return true;
	}

	@Override
	public boolean providerSelectByExampleWithBLOBsMethodGenerated(
			Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		List<String> line = new ArrayList<String>();
		
		
		line.add("if(example!=null&&example.getSelectCols()!=null&&example.getSelectCols().trim().length()>0){\n"+
	        	"\t\tBEGIN();"+"\n"+
	        	 "\t\tif (example != null && example.isDistinct()) {"+"\n"+
	             "\t\t\tSELECT_DISTINCT(example.getSelectCols());"+"\n"+
	             "\t\t} else {"+"\n"+
	             "\t\t\t\tSELECT(example.getSelectCols());"+"\n"+
	             "\t\t}"+"\n"+
	             "\t\t\t\tapplyWhere(example, false);"+"\n"+
	        "\t\t}");
		 
		line.add("if(example != null){");
//		line.add("return \"SELECT * FROM (SELECT A.*, ROWNUM RN FROM (\"+SQL()+\") A		WHERE ROWNUM < \"+(example.getLimit()+example.getOffset())+\") WHERE RN >= \"+(example.getOffset()) ;");
		 line.add("return SQL().concat(\" limit \"+example.getOffset()+\",\"+example.getLimit());");
		line.add("}");
		int linesNumber = method.getBodyLines().size();
		method.addBodyLines(linesNumber - 1, line);
		return true;
	}

	@Override
	public boolean providerSelectByExampleWithoutBLOBsMethodGenerated(
			Method method, TopLevelClass topLevelClass,
			IntrospectedTable introspectedTable) {
		List<String> line = new ArrayList<String>();
		
		
		line.add("if(example!=null&&example.getSelectCols()!=null&&example.getSelectCols().trim().length()>0){\n"+
	        	"\t\tBEGIN();"+"\n"+
	        	 "\t\tif (example != null && example.isDistinct()) {"+"\n"+
	             "\t\t\tSELECT_DISTINCT(example.getSelectCols());"+"\n"+
	             "\t\t} else {"+"\n"+
	             "\t\t\t\tSELECT(example.getSelectCols());"+"\n"+
	             "\t\t}"+"\n"+
	             "\t\t\t\tapplyWhere(example, false);"+"\n"+
	        "\t\t}");
		
		line.add("if(example != null){");
		line.add("return SQL().concat(\" limit \"+example.getOffset()+\",\"+example.getLimit());");
		
//		line.add("return \"SELECT * FROM (SELECT A.*, ROWNUM RN FROM (\"+SQL()+\") A		WHERE ROWNUM < \"+(example.getLimit()+example.getOffset())+\") WHERE RN >= \"+(example.getOffset()) ;");

//		line.add("return \"SELECT * FROM (SELECT A.*, rownumber() over() as RN FROM (\"+SQL()+\") A ) WHERE RN < \"+(example.getLimit()+example.getOffset())+\" AND RN >= \"+(example.getOffset()) ;");
		
		line.add("}");
		int linesNumber = method.getBodyLines().size();
		method.addBodyLines(linesNumber - 1, line);
		return true;
	}

	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

}
