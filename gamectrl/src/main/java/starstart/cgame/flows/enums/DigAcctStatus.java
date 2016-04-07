package starstart.cgame.flows.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DigAcctStatus {

	ST_0000("0000", "正常：已开户"), //
	ST_0001_INQ("0001", "正在请求"), //
	ST_0002_OPEN_ERR("0002", "开户异常"), //
	ST_0003_OPEN_TIMEOUT("0003", "超时异常"), ;// 异常：

	String code;
	String desc;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
