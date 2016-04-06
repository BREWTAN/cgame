package onight.tfw.rest.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

public class TradeDateUtil {

	public static void main(String[] args) {
		System.out.println(getPrevDateStr("2015-05-01","2015-05-01;2015-05-02;2015-05-03"));
	}
	
	public static boolean getPrevDateIsFestival(String tradeDateStr,String allDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date tradeDate = null;
		try {
			tradeDate = sdf.parse(tradeDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date prevTradeDate = DateUtils.addDays(tradeDate,-1);
		String prevTradeDateStr = sdf.format(prevTradeDate);
		//上一个天是节假日，继续向上查找上一个结算日
		if(allDate.indexOf(prevTradeDateStr)!=-1){
			return true;
		}else{
			return false;
		}
	}
	
	public static String getPrevDateStr(String tradeDateStr,String allDate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date tradeDate = null;
		try {
			tradeDate = sdf.parse(tradeDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date prevTradeDate = DateUtils.addDays(tradeDate,-1);
		String prevTradeDateStr = sdf.format(prevTradeDate);
		//上一个天是节假日，继续向上查找上一个结算日
		if(allDate.indexOf(prevTradeDateStr)!=-1){
			return getPrevDateStr(prevTradeDateStr,allDate);
		}
		//上一个结算日
		else{
			return prevTradeDateStr;
		}
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
