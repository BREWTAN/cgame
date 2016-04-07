package starstart.cgame.flows.land.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Pattern;


public class StringUtil {
	private static SimpleDateFormat dateTime14Fmt = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat full14fmt = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm:ss");
	public static String amountToString(Double d) {
		DecimalFormat df = new DecimalFormat("#,##0.##");
		return df.format(d);
	}
	public static boolean isNum(String strSrc) throws Exception {
		for (int i = 0; i < strSrc.length(); i++) {
			if (!isCharNum(strSrc.charAt(i)))
				return false;
		}
		return true;
	}
	public static boolean isCharNum(char ch) {
		return (ch > '/') && (ch < ':');
	}
	public static synchronized  String getLocalDateTime14() {
		return dateTime14Fmt.format(new Date());
	}
	/**
	 * 按指定格式得到当前时间
	 * 
	 * @param format
	 * @return
	 */
	public static String getCurrDate(String format) {
		SimpleDateFormat formater = new SimpleDateFormat(format);
		return formater.format(new Date());
	}

	/**
	 * 按yyyyMMdd得到当前日期
	 * 
	 * @return
	 */
	public static String getCurrDate() {
		String currentDate = null;
		/* 使用webserver机器时间 */
		SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
		currentDate = formater.format(new Date());
		return currentDate;
	}

	/**
	 * 毫秒转固定时间格式
	 * @return
	 */
	public static synchronized  String getCurrTime(long in) {
		return full14fmt.format(new Date(in));
	}
	
	/**
	 * 按HHmmss得到当前时间
	 * 
	 * @return
	 */
	public static String getCurrTime() {
		String currentDate = null;
		/* 使用webserver机器时间 */
		SimpleDateFormat formater = new SimpleDateFormat("HHmmss");
		currentDate = formater.format(new Date());
		return currentDate;
	}
	/**
	 * 解析字符串的文本，生成 Date  
	 *  dateStr :需要转换的字符串
	 * formatStr:需要格式的目标字符串  举例 yyyy-MM-dd
	 */
	public static Date StringToDate(String dateStr,String formatStr){
		SimpleDateFormat sdf =new SimpleDateFormat(formatStr);
		Date date=null;
		try {
			date = sdf.parse(dateStr);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 解析字符串的文本，生成 Date  
	 *  date :需要转换的日期
	 * formatStr:需要格式的目标字符串  举例 yyyy-MM-dd
	 */
	public static String DateToString(Date date,String formatStr){
		String dateStr="";
		try {
			SimpleDateFormat sdf=new SimpleDateFormat(formatStr);  
			dateStr=sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dateStr;
	}
	/**
	 * 格式化字符串格式的日期  
	 * @param formatString 20130303
	 * @param delim -
	 * @return 2013-03-03
	 */
	public static String getDateFormat(String formatString,String delim){
		return (formatString == null || formatString.trim().equals(""))?(""):
			(formatString.length()>=8?(formatString.substring(0,4)+
					delim+formatString.substring(4,6)+delim+
					formatString.substring(6,8)):formatString);
	}
	
	/**
	 * 格式化字符串格式的日期  
	 * @param formatString 121212
	 * @param delim :
	 * @return 12:12:12
	 */
	public static String getTimeFormat(String formatString,String delim){
		return (formatString == null || formatString.trim().equals(""))?(""):
			(formatString.length()>=6?(formatString.substring(0,2)+
					delim+formatString.substring(2,4)+delim+
					formatString.substring(4,6)):formatString);
	}
	public static boolean isEmpty(Object strObj) {
		return (strObj == null) || (strObj.toString().trim().length() < 1);
	}	
	/**
	 * 扩大或缩小XX倍--使用于整数，小数除会有精度问题
	 * @param num 基数
	 * @param again 倍数 大于0 = 基数*again 小于0 = 基数/again
	 * @return
	 */
	public static String numberRide(String num,String again){
		if(isEmpty(num)||"0".equals(again)){
			//基数是空或者倍数为0
			return "";
		}
		BigDecimal numb = new BigDecimal(num);
		BigDecimal againb = new BigDecimal(again);
		int i = againb.compareTo(new BigDecimal("0"));//<-1 =0 >1
		if(i>0){
			return (numb.multiply(againb).setScale(0)).toString();//扩大100
		}else{
			return (numb.divide(againb.abs())).toString();//缩小100倍
		}
	}
	
	
	/**
	 * 扩大或缩小XX倍--使用于整数，小数除会有精度问题
	 * @param num 基数
	 * @param again 倍数 大于0 = 基数*again 小于0 = 基数/again
	 * @return
	 */
	public static BigDecimal numberRideBigDecimal(String num,String again){
		BigDecimal decimal = new BigDecimal("0");
		if(isEmpty(num)||"0".equals(again)){
			//基数是空或者倍数为0
			return decimal;
		}
		BigDecimal numb = new BigDecimal(num);
		BigDecimal againb = new BigDecimal(again);
		int i = againb.compareTo(new BigDecimal("0"));//<-1 =0 >1
		if(i>0){
			return numb.multiply(againb).setScale(0);//扩大100
		}else{
			return numb.divide(againb.abs());//缩小100倍
		}
	}
	
	/**
	 * 获取昨天日期T-1
	 * @return
	 */
	public static String getYesterDay(){
		Calendar cl=Calendar.getInstance();
		cl.setTime(new Date());
		cl.add(Calendar.DATE, -1);
		SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
		String dateStr=sd.format(cl.getTime());//获取T-1天的日期
		return dateStr;
	}
	/**
	 * 获取明天日期T+1
	 * @return
	 */
	public static String getTomorrowDay(){
		Calendar cl=Calendar.getInstance();
		cl.setTime(new Date());
		cl.add(Calendar.DATE, +1);
		SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
		String dateStr=sd.format(cl.getTime());//获取T+1天的日期
		return dateStr;
	}
	/**
	 * 获取指定日期 明天T+1
	 * @return
	 */
	public static String getNextDay(String dateStr){
		Date date=StringToDate(dateStr, "yyyy-MM-dd");
		Calendar cl=Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.DATE, +1);
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String lastDateStr=sd.format(cl.getTime());//获取T-1天的日期
		return lastDateStr;
	}
	/**
	 * 获取指定日期 前一天    dateStr:yyyyMMdd
	 * @return
	 */
	public static String getLastDay(String dateStr){
		Date date=StringToDate(dateStr,"yyyy-MM-dd");
		Calendar cl=Calendar.getInstance();
		cl.setTime(date);
		cl.add(Calendar.DATE, -1);
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String lastDateStr=sd.format(cl.getTime());//获取T-1天的日期
		return lastDateStr;
	}
	
	/**
	 * 正则匹配指定值
	 * @param params
	 * @param pattern
	 * @return
	 */
	public static boolean compileMatch(String params,String pattern){
		return Pattern.compile(pattern).matcher(params).matches();
	}
	public static String getUUID(){
		String s = UUID.randomUUID().toString(); 
        return s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24); 
	}
    public static String getRandom(int num){
    	String nums="";
    	Random random=new Random();
    	for(int i=0;i<num;i++){
    		nums=nums+random.nextInt(10);
    	}
    	return nums;
    }
    /* 
     * 返回长度为【strLength】的随机数，在前面补0 
     */  
    public static String getFixLenthString(int strLength) {  
          
        Random rm = new Random();  
          
        // 获得随机数  
        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);  
      
        // 将获得的获得随机数转化为字符串  
        String fixLenthString = String.valueOf(pross);  
      
        // 返回固定的长度的随机数  
        return fixLenthString.substring(1, strLength + 1);  
    }
    public static String getOneDay(String date,int i){
    	String dateStr="";
    	Calendar cl=Calendar.getInstance();
    	SimpleDateFormat sd=new SimpleDateFormat("yyyyMMdd");
    	Date dates;
		try {
			dates = sd.parse(date);
			cl.setTime(dates);
			cl.add(Calendar.DATE, i);
			dateStr=sd.format(cl.getTime());//获取某天的日期  
		} catch (ParseException e) {
			dateStr="";
			e.printStackTrace();
		}
		return dateStr;
    }
    /**
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param type
	 *            当前日期格式  如yyyyMMdd
	 * @param returnType
	 *            返回日期格式   如yyyy-MM-dd
	 * @author k
	 * @return
	 */
    public static String formatDateToString(String dateStr, String type,
			String returnType) {
		if (StringUtil.isEmpty(dateStr)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(type);
		Date date = null;
		String strDate = null;
		try {
			date = sdf.parse(dateStr);
			SimpleDateFormat sdfa = new SimpleDateFormat(returnType);
			strDate = sdfa.format(date);
		} catch (ParseException e) {
			return "--";
		}
		return strDate;
	}
    /**
     * 小数位数超过8位的 转为BigDecimal 进行处理
     */
    public static BigDecimal StringToBigDecimal(String str) {
    	
    	BigDecimal decimal=new BigDecimal(0);
    	if (StringUtil.isEmpty(str)) {
    		return decimal;
		}else{
			
			decimal=new BigDecimal((new BigDecimal(str)).toPlainString());
			if(decimal.toString().toLowerCase().equals("0e-8")){
				decimal=new BigDecimal(0);
			}
		}
		return decimal;
    	
    	
    }
	public static void main(String[] args) {
		//System.out.println(formatDateToString("20150427","yyyyMMdd","yyyy-MM-dd"));
		//System.out.println(StringToDate(formatDateToString("20150427","yyyyMMdd","yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
		/*System.out.println(numberRide("12345","-100"));
		System.out.println(getUUID().length());;
		System.out.println(getRandom(3));
		Date date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		System.out.println(timeStamp);
		System.out.println(getOneDay("20150101",1));*/
		
		/*String a="0.00000000";
		String b="1.00000000";
		String c="14.00000000";
		String d="0.00050000";
		System.out.println(c.split("\\.")[0]);*/
		/*System.out.println(StringToBigDecimal(a));
		System.out.println(StringToBigDecimal(b));
		System.out.println(StringToBigDecimal(c));
		System.out.println(StringToBigDecimal(d));
		System.out.println("0E-8".toLowerCase());*/
		
		//System.out.println(getLastDay("20150606"));;
		
		
		BigDecimal a=new BigDecimal("14.63390800");
		a.setScale(2, BigDecimal.ROUND_HALF_DOWN);
		a.stripTrailingZeros().toPlainString();
		a.intValue();
		a.multiply(new BigDecimal("100")).setScale(0);
		
		String aa="2015";
		StringUtil.formatDateToString(aa, "yyyyMMdd", "yyyy-MM-dd");
		
	}
}