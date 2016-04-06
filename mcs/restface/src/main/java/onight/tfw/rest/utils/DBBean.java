package onight.tfw.rest.utils;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import onight.tfw.ojpa.api.annotations.Tab;

import org.apache.commons.lang3.StringUtils;

public enum DBBean {
	sysuser("T_SYS_USER",true),
	sysbranch("T_SYS_BRANCH",true),
	sysmenu("T_SYS_MENU",true),
	sysrole("T_SYS_ROLE",true),
	sysuserrole("T_SYS_USER_ROLE",true),
	sysbusiness("T_SYS_BUSINESS",true),
	sysrolemenu("T_SYS_ROLE_MENU",true),
	sysrolemutex("T_SYS_ROLE_MUTEX",true),
	sysinf("T_SYS_INF",true),
	settprodinf("T_SETT_PROD_INF",true),
	landchannelinf("T_LAND_CHANNEL_INF",true),
	mchinf("T_MCH_INF",true),
	trans100("T_TRANS_100",true),
	trans101("T_TRANS_101",true),
	trans102("T_TRANS_102",true)
	;


	@Getter
	private String table;
	@Getter
	private boolean staticTable;
	
	private DBBean(String table,boolean staticTable) {
		this.table = table;
		this.staticTable = staticTable;
	}
	private static Map<String,DBBean> classMap = new HashMap<>();
	
	static{
		for(DBBean info :DBBean.values()){
			classMap.put(info.name(), info);
		}
	}
	
	public static String getTableName2Class(Class<?> clazz){
		//从注解里读取表名
		Tab classTabAnno = clazz.getAnnotation(Tab.class);
		if (classTabAnno != null) {
			return classTabAnno.name();
		} else {
			return classMap.get(clazz.getSimpleName().toLowerCase()).getTable();
		}
	}
	
	public static String getDomain2Class(Class<?> clazz){
		return clazz.getSimpleName().toLowerCase();
	}
	
	public static String getTable2Name(String name){
		name = name.toLowerCase();
		if(StringUtils.contains(name, separator)){
			String[] str = StringUtils.split(name, separator);
			String tableName = classMap.get(str[0]).getTable();
			for(int i = 1 ;i<str.length;i++){
				tableName+=str[i];
				if(i<(str.length-1)){
					tableName+="_";
				}
			}
			return tableName;
		}
		return classMap.get(name).getTable();
	}
	
	public static boolean isStaticTable(String name){
		name = name.toLowerCase();
		return classMap.get(name)==null?false:classMap.get(name).isStaticTable();
	}
	
	private final static String separator = "_";
}
