package starstart.cgame.flows.land.util;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SoapClient {
	private HttpRequestor http = null;
	/*
	 * 方法名称：getMD5 
	 * 功    能：字符串MD5加密 
	 * 参    数：待转换字符串 
	 * 返 回 值：加密之后字符串
	 */
	public String getMD5(String sourceStr) throws UnsupportedEncodingException {
		String resultStr = "";
		try {
			byte[] temp = sourceStr.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(temp);
			// resultStr = new String(md5.digest());
			byte[] b = md5.digest();
			for (int i = 0; i < b.length; i++) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
						'9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[i] >>> 4) & 0X0F];
				ob[1] = digit[b[i] & 0X0F];
				resultStr += new String(ob);
			}
			return resultStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	

	/*
	 * 方法名称：mdSmsSend_u 
	 * 功    能：发送短信 ,传多个手机号就是群发，一个手机号就是单条提交
	 * 参    数：mobile,content,ext,stime,rrid(手机号，URL_UT8编码内容，扩展码，定时时间，唯一标识)
	 * 返 回 值：唯一标识，如果不填写rrid将返回系统生成的
	 */
	public String mdSmsSend_u(String mobile, String content, String ext, String stime,
			String rrid,String sn,String pwd,String serviceURL) {
		
		try {
			
			String result = "";
			String soapAction = "http://tempuri.org/mdSmsSend_u";
			String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
			xml += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
			xml += "<soap:Body>";
			xml += "<mdSmsSend_u xmlns=\"http://tempuri.org/\">";
			xml += "<sn>" + sn + "</sn>";
			xml += "<pwd>" + pwd + "</pwd>";
			xml += "<mobile>" + mobile + "</mobile>";
			xml += "<content>" + content + "</content>";
			xml += "<ext>" + ext + "</ext>";
			xml += "<stime>" + stime + "</stime>";
			xml += "<rrid>" + rrid + "</rrid>";
			xml += "</mdSmsSend_u>";
			xml += "</soap:Body>";
			xml += "</soap:Envelope>";
			URL url;
			url = new URL(serviceURL);

			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			bout.write(xml.getBytes("GBK"));//如果您的系统是utf-8,这里请改成bout.write(xml.getBytes("GBK"));
			byte[] b = bout.toByteArray();
			httpconn.setRequestProperty("Content-Length", String
					.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type",
					"text/xml; charset=gb2312");
			httpconn.setRequestProperty("SOAPAction", soapAction);
			httpconn.setRequestMethod("POST");
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);

			OutputStream out = httpconn.getOutputStream();
			out.write(b);
			out.close();

			InputStreamReader isr = new InputStreamReader(httpconn
					.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				Pattern pattern = Pattern.compile("<mdSmsSend_uResult>(.*)</mdSmsSend_uResult>");
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {
					result = matcher.group(1);
				}
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public String sendMail(String sendTo,String sendSubject,String sendText, String url) {
		http = new HttpRequestor();
		http.reload();
		http.changeMaxTotal(100);
		try {
			String msg = "{\"sendTo\":\""+sendTo+"\",\"sendSubject\":\""+sendSubject+"\",\"sendText\":\""+sendText+"\"}";
			
			String resp = http.postJson(msg,url);
			return resp;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	
	public static void main(String[] args) {
		SoapClient client = new SoapClient();
		String content;
		try {
			client.sendMail("ops.msb@umbpay.com", "text", "test","http://172.30.12.44:0801/restface/excomm/sendmail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
