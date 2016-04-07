package starstart.cgame.flows.land.util;

public class Constants {
	
	public final static String STATUS_00="0000";//查询流水状态
	public final static String STATUS105_01="0001";//查询装让流水状态

	public final static String STATUS_FAILED="0001";//流水状态失败

	public final static String TASK_STATE0="01";//开始
	public final static String TASK_STATE1="02";//执行中
	public final static String TASK_STATE2="03";//异常
	public final static String TASK_STATE3="04";//成功
	public final static String TASK_TYPE0= "01";//取文件任务
	public final static String TASK_TYPE1="02";//生成流水文件,流水勾兑"
	public final static String TASK_TYPE2="03";//生成差错数据"
	public final static String TASK_TYPE3="04";//生成结算数据
	public final static String TASK_TYPE4="05";//生成商户文件
	public final static String BLEND_STATE0="01";//产品有,我方无
	public final static String BLEND_STATE1="02";//我方有,产品无
	public final static String BLEND_STATE2="03";//产品有,我方有,交易信息不一致,以产品方为主
	public final static String ERR_STATE1="01";//需要补单差错
	public final static String ERR_STATE2="02";//只展示的差错
	public final static String TRANS102="MSCS.102";//手续费类型
	public final static String TRANS101="MSCS.101";//申购交易类型
	public final static String TRANS103="MSCS.103";//赎回交易类型
	public final static String TRANS103F="MSCS.103F";//作废产品 赎回交易类型
	public final static String TRANS107="MSCS.107";//受让
	public final static String TRANS105="MSCS.105";//转让
	public final static String TRANSPRF="MSCS.PRF";//收益
	public final static String TRANSFEE="MSCS.FEE";//产品手续费
	public final static String FEE_TYPE0="0";//按笔收费
	public final static String FEE_TYPE1="1";//阶梯段收费
	public final static String SETTSTATUS0="0";//未结算状态
	public final static String SETTSTATUS1="1";//结算完成
	public final static String SETTTYPE0="0";//交易类
	public final static String SETTTYPE1="1";//手续费类
	public final static String PRODSETTTYPE0="0";
	public final static String PRO_UPD_STATUS="0";//流水表申购表中 的异常状态
	public final static String AFTER_UPD_STATUS="1";//流水表申购表中 的异常状态需要修改为的状态
	public final static String BAN_STATUS="0000";//结算状态：待结算
	public final static String BAN_DETAIL_05="05";//结算状态：待结算
	
	public final static String DIVIDE_STATUS1="01";//分账信息 待处理
	public final static String DIVIDE_STATUS0="00";//分账信息  正常
	
	
	public final static String ACCT_TYPE_00="0";//开户
	public final static String ACCT_TYPE_01="1";//申购
	public final static String ACCT_TYPE_02="2";//赎回
	public final static String ACCT_TYPE_03="3";//转让
	public final static String ACCT_TYPE_04="4";//受让
	public final static String ACCT_TYPE_05="5";//收益
	public final static String ACCT_TYPE_06="6";//手续费
	public final static String ACCT_TYPE_07="7";//手续费
	
	//从产品方获取文件类型FileType
	
	public final static String SgCode="MSCS.101";//申购
	public final static String ShCode="MSCS.103";//赎回
	public final static String ZrCode="MSCS.109";//转让
	public final static String SrCode="MSCS.107";//受让
	public final static String SyCode="MSCS.PRF";//收益
	//商户类型

	/*public final static String CFAG="CFAG";//(b)	封闭型理财产品
	public final static String OFAG="OFAG";//(a)	开放型理财产品
	public final static String FUND="FUND";//(c)	基金产品 （如意宝）
	public final static String FNLN="FNLN";//(d)	融资贷款产品（P2P）
*/	
	public final static String OFAG="OFAG";
	public final static String FNLN="FNLN";
	
	public final static String PROD_KEY="RYBA00000001|";
	public final static String PROD_KEY_GF="RYBA00000001|";

	
	public final static String CHECK_TP_SG ="A";
	public final static String CHECK_TP_SH ="R";
	
	/*public final static String FUNDCode="STTL_00_FUND";//RYB
	public final static String FNLNCode="STTL_00_FNLN";//P2P
*/	
	
	
	


}
