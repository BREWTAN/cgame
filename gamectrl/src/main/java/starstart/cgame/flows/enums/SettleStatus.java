package starstart.cgame.flows.enums;

import lombok.Getter;

public enum SettleStatus {

	Start("0","开始"),
	Processing("1","处理中"),
	Finished("2","已完成"),
	Error("3","错误"),
	UNKNOW_STATUS("-99","未知");
	
	@Getter
	String code;
	@Getter
	String desc;
	
	private SettleStatus(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
