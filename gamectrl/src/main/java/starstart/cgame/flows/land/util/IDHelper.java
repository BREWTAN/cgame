package starstart.cgame.flows.land.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class IDHelper {

	static final AtomicLong counter = new AtomicLong(0);
	static final AtomicLong tseqno = new AtomicLong(0);
	static final AtomicLong rseqno = new AtomicLong(0);
	static final AtomicLong bseqno = new AtomicLong(0);

	static void genDigit(StringBuffer sb, long v, int len) {
		while (v > 0) {
			sb.append(v % 10);
			v /= 10;
			len--;
		}
		while (len > 0) {
			len--;
			sb.append('0');
		}
	}

	// 协议流水号 MessageId varchar(20) R
	// 协议流水号（yyMMddHHmmss+商户号+3位随机数）

	static ThreadLocal<SimpleDateFormat> dfl = new ThreadLocal<SimpleDateFormat>();
	static final AtomicLong seqCounter = new AtomicLong(0);

	public static String toRYBMessageId(String outMerchantId) {
		SimpleDateFormat df = dfl.get();
		if (df == null) {
			df = new SimpleDateFormat("yyMMddHHmmss");
			dfl.set(df);
		}
		StringBuffer sb = new StringBuffer();
		sb.append(df.format(new Date())).append(outMerchantId);
		genDigit(sb, (counter.incrementAndGet() ), 3);
		return sb.toString();
	}

	// 充值订单号 MerchantSeqNo varchar(20) R
	// 商户号+yyMMdd+9位随机数（字母、数字或字母数字组合均可），订单号始终不能重复
	// 提现商户订单号 MerchantSeqNo varchar(20) R
	// 商户号+yyMMdd+9位随机数（字母、数字或字母数字组合均可）订单号始终不能重复

	static ThreadLocal<SimpleDateFormat> dflseq = new ThreadLocal<SimpleDateFormat>();
	public static String toRYBSeqId(String outMerchantId,String orderid) {
		if(orderid==null||orderid.length()!=15){
			throw new RuntimeException("如意宝的商户订单号必须是15位");
		}
		StringBuffer sb = new StringBuffer(outMerchantId);
		sb.append(orderid);
		return sb.toString();
	}
	
	//生成通信层的标识号(yyMMdd+商户号+T+10位随机数)
	public static String getTMessageId(String outMerchantId) {
		SimpleDateFormat df = dfl.get();
		if (df == null) {
			df = new SimpleDateFormat("yyyyMMdd");
			dfl.set(df);
		}
		StringBuffer sb = new StringBuffer();
		sb.append(df.format(new Date())).append(outMerchantId).append("T");
		genDigit(sb, (tseqno.incrementAndGet() ), 10);
		return sb.toString();
	}
	//生成回应标识号(yyMMdd+商户号+R+10位随机数)
		public static String getRMessageId(String outMerchantId) {
			SimpleDateFormat df = dfl.get();
			if (df == null) {
				df = new SimpleDateFormat("yyyyMMdd");
				dfl.set(df);
			}
			StringBuffer sb = new StringBuffer();
			sb.append(df.format(new Date())).append(outMerchantId).append("R");
			genDigit(sb, (rseqno.incrementAndGet() ), 10);
			return sb.toString();
		}
		//生成业务标识号(yyMMdd+商户号+B+10位随机数)
		public static String getBMessageId(String outMerchantId) {
			SimpleDateFormat df = dfl.get();
			if (df == null) {
				df = new SimpleDateFormat("yyyyMMdd");
				dfl.set(df);
			}
			StringBuffer sb = new StringBuffer();
			sb.append(df.format(new Date())).append(outMerchantId).append("B");
			genDigit(sb, (bseqno.incrementAndGet() ), 8);
			return sb.toString();
		}
		//生成ID号(yyMMdd+商户号+产品ID+5位随机数)
		public static String getId(String outMerchantId) {
			SimpleDateFormat df = dfl.get();
			if (df == null) {
				df = new SimpleDateFormat("yyyyMMdd");
				dfl.set(df);
			}
			StringBuffer sb = new StringBuffer();
			sb.append(df.format(new Date())).append(outMerchantId);
			genDigit(sb, (bseqno.incrementAndGet() ), 5);
			return sb.toString();
		}
	public static void main(String[] args) {
		System.out.println(toRYBMessageId("MSEC"));
		System.out.println(toRYBMessageId("MSEC"));
		System.out.println(toRYBMessageId("MSEC"));
		System.out.println(toRYBSeqId("1234","150327123412345"));

	}
}
