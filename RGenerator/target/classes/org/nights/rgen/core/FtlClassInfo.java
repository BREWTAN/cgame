package org.nights.rgen.core;

import java.util.ArrayList;
import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class FtlClassInfo {
	public String domainObject;
	public String domainClass;
	public String packageName;
	public String tablename;
	public String columns;
	public ArrayList<String[]> columnAndProps = new ArrayList<>();
	public String keycol;

	@Data
	@AllArgsConstructor
	public static class Columinfo {
		public String pbtype;
		public String pbfield;

		public String sotype;
		public String sofield;
	}

	public ArrayList<Columinfo> columnInfos = new ArrayList<>();

	public String getDomainObject() {
		return domainObject;
	}

	public void setDomainObject(String domainObject) {
		this.domainObject = domainObject;
	}

	public String getDomainClass() {
		return domainClass;
	}

	public void setDomainClass(String domainClass) {
		this.domainClass = domainClass;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

}
