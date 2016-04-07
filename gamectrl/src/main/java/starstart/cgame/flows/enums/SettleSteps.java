package starstart.cgame.flows.enums;

public enum SettleSteps {

	CTRL("STTL_SCHEDULER_CTRL","任务控制"),
	
	Start_Upd_R("STTL_00_UPD_R","开始"),
	Prod_Query_Upd_R("STTL_1007_UPD_R","产品信息查询更新"),
	End_Upd_R("STTL_88_UPD_R","流程结束"),
	//OFAG：RYB如意宝开放式理财类产品 流程
	Start_RYB("STTL_00_RYB","开始"),

	Deposit_Get_RYB("STTL_0101_RYB","获取产品方申购文件"),
	Deposit_Check_RYB("STTL_0102_RYB","申购流水勾对"),
	Deposit_Err_RYB("STTL_0103_RYB","申购差错处理"),
	

	Withdraw_Get_RYB("STTL_0201_RYB","获取产品赎回文件"),
	Withdraw_Check_RYB("STTL_0202_RYB","赎回流水勾对"),
	Withdraw_Err_RYB("STTL_0203_RYB","申购差错处理"),
	
	Profits_Get_RYB("STTL_0301_RYB","获取产品收益文件并回填数据库"),
	BufferMsg_Proc("STTL_1008_RYB","缓冲订单处理"),
	End_RYB("STTL_88_RYB","流程结束"),
	
	
	//OFAG：GF广发开放式理财类产品 流程
	Start_GF("STTL_00_GF","开始"),

	Deposit_Get_GF("STTL_0101_GF","获取产品方申购文件"),
	Deposit_Check_GF("STTL_0102_GF","申购流水勾对"),
	Deposit_Err_GF("STTL_0103_GF","申购差错处理"),
	

	Withdraw_Get_GF("STTL_0201_GF","获取产品赎回文件"),
	Withdraw_Check_GF("STTL_0202_GF","赎回流水勾对"),
	Withdraw_Err_GF("STTL_0203_GF","申购差错处理"),
	
	Profits_Get_GF("STTL_0301_GF","获取产品收益文件并回填数据库"),
	Prod_Query_Upd_GF("STTL_1007_GF","产品信息查询更新"),
	End_GF("STTL_88_GF","流程结束"),
	
	//OFAG：开放式理财类产品 结算流程公共
	Start_Banlance("STTL_00_BAN_OFAG","开始"),
	Profits_GenMerchantFile("STTL_0302_OFAG","生成商户收益文件"),
	Deposit_GenMerchantFile("STTL_0104_OFAG","生成商户申购文件"),
	Withdraw_GenMerchantFile("STTL_0204_OFAG","生成商户赎回文件"),
	Settle_For_Land_Detail("STTL_1001_OFAG","生成落地结算明细数据"),
	Settle_For_Land_Banlance("STTL_1002_OFAG","生成落地结算数据"),
	Settle_For_Merchant_Detail("STTL_1003_OFAG","生成商户结算明细数据"),
	Settle_For_Merchant_Banlance("STTL_1004_OFAG","生成商户结算数据"),
	Sy_Daily_Insert("STTL_1005_OFAG","损益数据更新"),
	Banlance_Notice_OFAG("STTL_805_OFAG","结算通知"),//暂不执行此任务
	End_Ban_OFAG("STTL_88_BAN_OFAG","流程结束"),
	

	// FNLN：融资贷款类产品流程
	Start_P2P("STTL_00_P2P","开始"),
	Deposit_Get_P2P("STTL_0101_P2P","获取产品方申购文件"),
	Deposit_Check_P2P("STTL_0102_P2P","申购流水勾对"),
	Deposit_Err_P2P("STTL_0103_P2P","申购差错处理"),

	//暂不执行转让任务
	Resell_Get_P2P("STTL_0401_P2P","获取产品方受让文件"),
	Resell_Check_P2P("STTL_0402_P2P","受让流水勾对"),
	Resell_Err_P2P("STTL_0403_P2P","受让差错处理"),
	Profits_Get_P2P("STTL_0301_P2P","获取产品收益文件并回填数据库"),
	End_P2P ("STTL_88_P2P","流程结束"),
	
	//FNLN：融资贷款类产品  结算流程公共
	Start_Banlance_FNLN("STTL_00_BAN_FNLN","开始"),
	Profits_GenMerchantFile_FNLN("STTL_0302_FNLN","生成商户收益文件"),
	Deposit_GenMerchantFile_FNLN("STTL_0104_FNLN","生成商户申购文件"),
	Withdraw_GenMerchantFile_FNLN("STTL_0204_FNLN","生成商户赎回文件"),
	Resell_GenMerchantFile_FNLN("STTL_0404_FNLN","生成商户受让文件"),
	Settle_For_Land_Detail_FNLN("STTL_1001_FNLN","生成落地结算明细数据"),
	Settle_For_Land_Banlance_FNLN("STTL_1002_FNLN","生成落地结算数据"),
	Settle_For_Merchant_Detail_FNLN("STTL_1003_FNLN","生成商户结算明细数据"),
	Settle_For_Merchant_Banlance_FNLN("STTL_1004_FNLN","生成商户结算数据"),
	Sy_Daily_Insert_FNLN("STTL_1005_FNLN","损益数据更新"),
	Product_Notice_FNLN("STTL_209_FNLN","产品变更通知"),
	Banlance_Notice_FNLN("STTL_805_FNLN","结算通知"),//暂不执行此任务
	End_Ban_FNLN("STTL_88_BAN_FNLN","流程结束"),
	
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
