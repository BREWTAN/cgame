package starstart.cgame.flows.enums;

public enum SettleSteps {

	INIT("GS_INIT","游戏初始化"),//游戏期号初始化，入库ISSUE表完成
	SALE_PREPARE("GS_SALE_PREPARE","游戏预售中"),//与官方数据同步，期号数据准备成功，等待开售，一般提前5分钟来获取
	SALE_ON("GS_SALE_ON","游戏销售中"),//游戏正常销售中
	SALE_PAUSE("GS_SALE_PAUSE","游戏暂停销售"),//游戏暂停销售
	SALE_DONE("GS_SALE_DONE","游戏销售结束"),//游戏正常结束
	
	WAGER_LOCK("GS_WAGER_LOCK","投注数据封存"),//备份并封存本期销售数据
	
	WIN_NUM_GET("GS_WIN_NUM_GET","获取开奖号码"),//从官方获取开奖号码中，
	WIN_OFFICIAL_BOARD_GET("GS_WIN_OFFICIAL_BOARD_GET","获取开奖公告"),//从官方获取开奖公告中
	WIN_LOCAL_BOARD_GET("GS_WIN_LOCAL_BOARD_GET","获取开奖公告"),//生成本地的投注总数，总金额等一级
	
	WIN_CALCULATE("GS_WIN_CALCULATE","计算开奖结果"),//计算开奖结果，
	MONEY_DISPATCH("MONEY_DISPATCH","派奖"),//派奖
	PROFIT_DISPATCH("PROFIT_DISPATCH","返点"),
	
	ALL_DONE("ALL_DONE","游戏结束"),
	
	UNKNOW_STATUS("","");
	
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


	private SettleSteps(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}
}
