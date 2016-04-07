package starstart.cgame.flows.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import starstart.cgame.flows.land.util.RybSign;
import starstart.cgame.flows.land.util.XMLSignature;
import lombok.Data;

public class TradeLocal {

	static class TradeSet {
		SimpleDateFormat sf_yyMMdd = new SimpleDateFormat("yyMMdd");
		SimpleDateFormat sf_yyMMddHHmm = new SimpleDateFormat(
				"yyMMddHHmm");
		SimpleDateFormat sf_yyMMddHHmmss_SSS = new SimpleDateFormat(
				"yyMMddHHmmss.SSS");
		SimpleDateFormat sf_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
		RybSign sign = new RybSign();
		XMLSignature XMLsign = new XMLSignature();
		ZBXLogSet zbxlogs;
		String taskID;
		long entrytime = System.currentTimeMillis();
	}

	@Data
	static class ZBXLogSet {
		String P[] = new String[] { "1", "", "", "", "" };
		String Cost[] = new String[] { "", "", "", "", "" };
		String Money = "";

	}

	public static Date getDF_yyyy_MM_dd(String datestr)
			throws ParseException {
		return local.get().sf_yyyy_MM_dd.parse(datestr);
	}
	public static RybSign getSign() {
		return local.get().sign;
	}
	
	public static XMLSignature getXMLSign() {
		return local.get().XMLsign;
	}

	static class ExtThreadLocal extends ThreadLocal<TradeSet> {
		@Override
		protected TradeSet initialValue() {
			return new TradeSet();
		}
	}

	static ExtThreadLocal local;
	static {
		local = new TradeLocal.ExtThreadLocal();
	}

	public static SimpleDateFormat getSDF_yyyMMdd() {
		return local.get().sf_yyMMdd;
	}

	public static String getToday() {
		return local.get().sf_yyMMdd.format(new Date());
	}
	
	public static String getNow() {
		return local.get().sf_yyMMddHHmmss_SSS.format(new Date());
	}

	public static long getEntryTimeMS() {
		return local.get().entrytime;
	}

	public static String zbxLogs(String module, String status) {
		ZBXLogSet zlog = local.get().zbxlogs;
		return "[ZBX]::" + module + "|S:" + status + "|M:" + zlog.Money
				+ "|P0:" + zlog.P[0]
				+ //
				"|P1:" + zlog.P[1] + "|P2:" + zlog.P[2]
				+ //
				"|C:" + (System.currentTimeMillis() - local.get().entrytime)
				+ "|C0:" + zlog.Cost[0] + //
				"|C1:" + zlog.Cost[1] + //
				"|C2:" + zlog.Cost[2] + //
				"|MchID:" + local.get().taskID + "|";
	}

	public static void logCostTime(int id, long cost) {
		local.get().zbxlogs.Cost[id] = String.valueOf(cost);
	}

	public static void setTaskID(String taskid){
		local.get().taskID=taskid;
	}
	public static void logCounter(int id, long count) {
		local.get().zbxlogs.P[id] = String.valueOf(count);
	}

	static ZBXLogSet zbxzerologs = new ZBXLogSet();

	public static void clean() {
		local.get().entrytime = System.currentTimeMillis();
		local.get().zbxlogs = zbxzerologs;
		local.get().taskID = null;
	}
	
	public static Date getDateFromyyMMddHHmm(String datestr)
			throws ParseException {
		return local.get().sf_yyMMddHHmm.parse(datestr);
	}

}
