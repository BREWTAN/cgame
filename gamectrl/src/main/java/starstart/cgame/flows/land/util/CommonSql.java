package starstart.cgame.flows.land.util;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import org.apache.felix.ipojo.annotations.Provides;

import cn.msec.ojpa.api.IJPAClient;
import cn.msec.orouter.api.IQClient;
import cn.msec.osgi.annotation.iPojoBean;
import cn.msec.osgi.ofw.ActorProxy;


@iPojoBean
@Provides(specifications = { IQClient.class, IJPAClient.class })
@Slf4j
@Data
public class CommonSql extends ActorProxy{
	//获取对账文件时
		public static String getProMchIdSql(String prodType,String PROD_MCH_ID){
			String sql="select DISTINCT  CHANNEL.MCH_ID ,CHANNEL.PROD_MCH_ID ,CHANNEL.ENT_TYPE,CHANNEL.CHANNEL_URL,"
					+"CHANNEL.CHANNEL_PUB_KEY,CHANNEL.CHANNEL_PRI_KEY,CHANNEL.CHANNEL_KEY ,CHANNEL.PRI_KEY from  T_LAND_DX_ID_DESC DXID,T_LAND_CHANNEL_INF CHANNEL, "
					+"T_LAND_PROD_INFO PROD WHERE  PROD.PRODUCT_TYPE='"+prodType+"' AND CHANNEL.PROD_MCH_ID='"+PROD_MCH_ID+"' AND PROD.PROD_ID=DXID.PROD_ID AND CHANNEL.ID=DXID.CHANNEL_ID "
					+"AND CHANNEL.STATUS='00' ";
			return sql;
		}

	//获取对账文件时
	/*public static String getProMchIdSql(String prodType){
		String sql="select DISTINCT  CHANNEL.MCH_ID ,CHANNEL.PROD_MCH_ID ,CHANNEL.PROD_CHANNEL_ID,CHANNEL.ENT_TYPE,CHANNEL.CHANNEL_URL,"
				+"CHANNEL.CHANNEL_PUB_KEY,CHANNEL.CHANNEL_PRI_KEY,CHANNEL.CHANNEL_KEY from  T_LAND_DX_ID_DESC DXID,T_LAND_CHANNEL_INF CHANNEL, "
				+"T_LAND_PROD_INFO PROD WHERE  PROD.PRODUCT_TYPE='"+prodType+"' AND PROD_ID='RYBA00000001' AND PROD.PROD_ID=DXID.PROD_ID AND CHANNEL.ID=DXID.CHANNEL_ID "
				+"AND CHANNEL.STATUS='00' ";
		return sql;
	}*/
	//根据产品类型生成给商户的申购对账文件
	public static String getMSCS101FileSql(String mchntId,String settleDate,String prodType){
		String sql = "SELECT MSCS.STTL_DATE,MSCS.INV_AMT,MSCS.ORDER_ID " + " FROM T_LAND_MSCS101 MSCS " + " WHERE MSCS.SND_MCH_ID = '" + mchntId
				+ "' AND MSCS.STTL_DATE='" + settleDate + "' AND " + " MSCS.RESULT_CODE='0000' AND MSCS.PRODUCT_ID IN "
				+ " (SELECT PROD.PROD_ID FROM T_LAND_PROD_INFO PROD WHERE PROD.PRODUCT_TYPE = '"+prodType+"')";
		return sql;
	}
	
	//根据产品类型生成给商户的赎回对账文件
	public static String getMSCS103FileSql(String mchntId,String settleDate,String prodType){
		String sql = "SELECT MSCS.STTL_DATE,MSCS.INV_AMT,MSCS.ORDER_ID " + " FROM T_LAND_MSCS103 MSCS " + " WHERE MSCS.SND_MCH_ID = '" + mchntId
				+ "' AND MSCS.STTL_DATE='" + settleDate + "' AND " + " MSCS.RESULT_CODE='0000' AND MSCS.PRODUCT_ID IN "
				+ " (SELECT PROD.PROD_ID FROM T_LAND_PROD_INFO PROD WHERE PROD.PRODUCT_TYPE = '"+prodType+"')";
		return sql;
	}
	//商户结算明细信息
	public static String getMchBanDetailSql(String settleDate,String mchTp){
		String sql="SELECT ORDER_ID,SND_MCH_ID,RCV_CHN_ID,PRODUCT_ID,OUT_PRODUCT_ID,OUT_PRODUCT_SUBID,PROD_ORDER_ID,TRANS_TYPE,INV_AMT,MCH_SERVICE_FEE,RECV_TIME,"
				+ " RSP_RECV_TIME,MSCS101.STTL_DATE,RESULT_CODE FROM T_LAND_MSCS101 MSCS101,T_LAND_PROD_INFO PROD WHERE PROD.PRODUCT_TYPE='"+mchTp+"'"
				+ "AND PROD.PROD_ID=MSCS101.PRODUCT_ID AND  MSCS101.RESULT_CODE='0000'  AND MSCS101.STTL_DATE ='"+settleDate+"' "
				+"UNION "
				+ "SELECT ORDER_ID,SND_MCH_ID,RCV_CHN_ID,PRODUCT_ID,OUT_PRODUCT_ID,OUT_PRODUCT_SUBID,PROD_ORDER_ID,TRANS_TYPE,INV_AMT,MCH_SERVICE_FEE,RECV_TIME,"
				+" RSP_RECV_TIME,MSCS103.STTL_DATE,RESULT_CODE FROM T_LAND_MSCS103 MSCS103,T_LAND_PROD_INFO PROD WHERE PROD.PRODUCT_TYPE='"+mchTp+"'"
				+ "AND PROD.PROD_ID=MSCS103.PRODUCT_ID AND  MSCS103.RESULT_CODE='0000'  AND MSCS103.STTL_DATE ='"+settleDate+"' ";
		return sql;
	}
	//商户结算信息
	public static String getMchBanlanceSql(String settleDate,String prodTp){
		String sql="SELECT  count(1) count ,TRANS_TYPE,MCHNT_ID,PROD_ID,SUM(TRANS_AMT) TOTAL_AMT,SETT_DATE FROM T_SETT_MCHNT_DETAILS"
				+ " WHERE SETT_DATE='"+settleDate+"' and PRODUCT_TYPE='"+prodTp+"' AND REC_STATUS='03' GROUP BY MCHNT_ID,TRANS_TYPE,PROD_ID";
		return sql;
	}
	//产品渠道结算明细信息
	public static String getProdBanDetailSql(String settleDate,String mchTp){
		String sql="SELECT ORDER_ID,RCV_MCH_ID,RCV_CHN_ID,PRODUCT_ID,OUT_PRODUCT_ID,OUT_PRODUCT_SUBID,PROD_ORDER_ID,TRANS_TYPE,INV_AMT,MCH_SERVICE_FEE,RECV_TIME,"
				+ " RSP_RECV_TIME,MSCS101.STTL_DATE,RESULT_CODE FROM T_LAND_MSCS101 MSCS101,T_LAND_PROD_INFO PROD WHERE PROD.PRODUCT_TYPE='"+mchTp+"'"
				+ "AND PROD.PROD_ID=MSCS101.PRODUCT_ID AND  MSCS101.RESULT_CODE='0000'  AND MSCS101.STTL_DATE ='"+settleDate+"' "
				+"UNION "
				+ "SELECT ORDER_ID,RCV_MCH_ID,RCV_CHN_ID,PRODUCT_ID,OUT_PRODUCT_ID,OUT_PRODUCT_SUBID,PROD_ORDER_ID,TRANS_TYPE,INV_AMT,MCH_SERVICE_FEE,RECV_TIME,"
				+" RSP_RECV_TIME,MSCS103.STTL_DATE,RESULT_CODE FROM T_LAND_MSCS103 MSCS103,T_LAND_PROD_INFO PROD WHERE PROD.PRODUCT_TYPE='"+mchTp+"'"
				+ "AND PROD.PROD_ID=MSCS103.PRODUCT_ID AND  MSCS103.RESULT_CODE='0000'  AND MSCS103.STTL_DATE ='"+settleDate+"' ";
		return sql;
	}
	
	
}