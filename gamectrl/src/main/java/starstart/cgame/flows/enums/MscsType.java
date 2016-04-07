package starstart.cgame.flows.enums;

import lombok.Getter;

public enum MscsType {

	ShenGou("MSCS.101","申购"),
	ShuHui("MSCS.103","赎回"),
	ZhuanRang("MSCS.109","转让"),
	ShouRang("MSCS.107","受让"),
	PrfDis("MSCS.PRF","收益 分红");
	
	@Getter
	String code;
	@Getter
	String desc;
	
	private MscsType(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
