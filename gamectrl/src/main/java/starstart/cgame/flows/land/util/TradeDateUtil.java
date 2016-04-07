package starstart.cgame.flows.land.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;


public class TradeDateUtil {

	public static void main(String[] args) {
		System.out.println(getDateStr("20150429","20150501;20150502;20150503"));
	}
	/**
	 * 
	 * @param tradeDateStr  当前的交易日期
	 * @param allDate 所有配置的节假日信息
	 * @return 返回下一个交易日期
	 */
	public static String getDateStr(String tradeDateStr,String allDate){
			//String allDate="20150501;20150502;20150503";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date tradeDate = null;
			try {
				tradeDate = sdf.parse(tradeDateStr);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date nextTradeDate = DateUtils.addDays(tradeDate,1);
			//交易日的下一个日期
			String nextTradeDateStr = sdf.format(nextTradeDate);
			//当前交易日是节假日
			if(allDate.indexOf(tradeDateStr)!=-1){
				return getDateStr(nextTradeDateStr,allDate);
			}
			//当前交易日不是节假日
			else{
				//交易日的下一个日期是节假日
				if(allDate.indexOf(nextTradeDateStr)!=-1){
					//获取下一个紧邻着的非节假日
					return getNextDateStr(nextTradeDateStr,allDate);
				}
				//交易日的下一个日期不是节假日
				else{
					return nextTradeDateStr;
				}
			}
	}
	public static String getNextDateStr(String tradeDateStr,String allDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date tradeDate = null;
		try {
			tradeDate = sdf.parse(tradeDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date nextTradeDate = DateUtils.addDays(tradeDate,1);
		//交易日的下一个日期
		String nextTradeDateStr = sdf.format(nextTradeDate);
		//当前交易日是节假日
		if(allDate.indexOf(tradeDateStr)!=-1){
			return getNextDateStr(nextTradeDateStr,allDate);
		}
		//当前交易日不是节假日
		else{
			return tradeDateStr;
		}
	}
}
