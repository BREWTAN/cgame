package org.nights.rgens.plugin.mybatis3;

public class ChangeName {

	static String toCamelCase(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (String part : parts) {
			if (part != null && part.trim().length() > 0)
				camelCaseString = camelCaseString + toProperCase(part);
			else
				camelCaseString = camelCaseString + part + "";
		}
		return camelCaseString;
	}

	static String toDomainName(String s) {
		String[] parts = s.split("_");
		String camelCaseString = "";
		for (int i = 0; i < parts.length; i++) {
			String part = parts[i];
			if (i == 0) {
				camelCaseString = part.toUpperCase();
			} else if (part != null && part.trim().length() > 0)
				camelCaseString = camelCaseString + toProperCase(part);
			else
				camelCaseString = camelCaseString + part + "";
		}
		return camelCaseString;
	}

	static String toProperCase(String s) {
		String temp = s.trim();
		String spaces = "";
		if (temp.length() != s.length()) {
			int startCharIndex = s.charAt(temp.indexOf(0));
			spaces = s.substring(0, startCharIndex);
		}
		temp = temp.substring(0, 1).toUpperCase() + spaces + temp.substring(1).toLowerCase() + "";
		return temp;

	}

	public static void main(String[] args) {
		String tables[] = { "T_ADMIN_OPERATOR", "T_ADMIN_OPERATOR_ROLE", "T_ADMIN_PAGE", "T_ADMIN_PERMISSION",
				"T_ADMIN_ROLE", "T_ADMIN_ROLE_PERMISSION", "T_FRONT_CUST_INF", "T_FRONT_DIGACCT_INF",
				"T_FRONT_USER_INF", "T_FRONT_USER_PROD_INF", "T_LAND_CHANNEL_INF", "T_LAND_DX_ID_DESC",
				"T_LAND_FEE_INFO", "T_LAND_PROD_INF", "T_MCH_ACCT_INF", "T_MCH_FEE_DESC", "T_MCH_INF",
				"T_MCH_PROD_INF", "T_SETT_BALANCE", "T_SETT_ERR", "T_SETT_MCH_DIT", "T_SETT_PROD_INF",
				"T_SETT_PTXY_INF", "T_SETT_TASK_INF", "T_SETT_YHSY_INF", "T_SETT_YHZC_INF", "T_SYS_INF", "T_TRANS_100",
				"T_TRANS_102", "T_TRANS_201", "T_TRANS_202" };
		for (String tb : tables) {

			String tt = "<table tableName=\"" + tb + "\" domainObjectName=\"" + toCamelCase(tb.substring(2)) + "\"/>";
			System.out.println(tt);
		}

	}

}
