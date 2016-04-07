package starstart.cgame.flows.land.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.SSLContext;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import starstart.cgame.flows.enums.SettleSteps;
import starstart.cgame.flows.nsttl.entity.CalcMutex;
import starstart.cgame.flows.nsttl.exception.SettleException;
import starstart.cgame.flows.nsttl.flows.NSettle_BaseActor;
import starstart.cgame.flows.nsttl.ryb.NS_0101_Deposit_Get_RYB;
import starstart.cgame.flows.nsttl.ryb.NS_0104_Deposit_GenMerchantFile_RYB;


/**
 * 
* @ClassName: GfDownLoadFileByHttp 
* @Description: 从产品方（广发） 获取文件方法
* @author kyn
* @date 2015年4月14日 下午5:49:21 
*
 */
@Slf4j
public class GfDownLoadFileByHttp extends NSettle_BaseActor<CalcMutex>  {

	private static final RequestConfig config;
	static {
		config = RequestConfig.custom().setConnectTimeout(60000)
				.setSocketTimeout(60000).build();
	}

	

	public static boolean doPost(Map<String, Object> paramMap){
		
			CloseableHttpResponse response = null;
			
	try {	
			
			String dataContent = (String) paramMap.get("dataContent");
			Map channelMap=(Map) paramMap.get("channelMap");
			String url =(String) channelMap.get("CHANNEL_URL");
			String cerPath=(String) channelMap.get("CHANNEL_PUB_KEY");
			String pfxPath=(String) channelMap.get("CHANNEL_PRI_KEY");
			String pfxPwd=(String) channelMap.get("CHANNEL_KEY");
			String paramString =(String) paramMap.get("paramString");

			String rntType=(String) paramMap.get("ent_type");
			RybSign sign = new RybSign();
			log.info("广发平台对账文件下载paramMap:------------------"+paramMap);
			if(rntType.equals("1")){//1-证书加密
				dataContent = sign.sign(dataContent, pfxPwd, pfxPath, cerPath);
			}
			String urlString = url + "? " + paramString;
            URL realUrl = new URL(urlString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();


		
				String zipFilePath = (String) paramMap.get("zipFilePath");
				String txtFilePath = (String) paramMap.get("txtFilePath");
				BufferedReader input = new BufferedReader(new InputStreamReader(connection
						.getInputStream()));
				File file = new File(zipFilePath); // 加密文件流保存本地文件
				file.getParentFile().mkdirs();
				if (!file.exists()) {
					file.createNewFile();
				}
				FileOutputStream fileOutput = new FileOutputStream(file);
				IOUtils.copy(input, fileOutput);
				input.close();
				fileOutput.close();
				File file2 = new File(txtFilePath); 
				if (!file2.exists()) {
					file2.createNewFile();
				}
				FileInputStream fileInput = new FileInputStream(file); 
				FileOutputStream fileOutput2 = new FileOutputStream(file2);
				DataInputStream dis = new DataInputStream(fileInput);
				IOUtils.copy(dis, fileOutput2);
				fileInput.close();
				fileOutput2.close();
				return true;

		} catch (Exception e) {
			e.printStackTrace();
			throw new SettleException(e);
		} finally {
			if (response != null)
				try {
					response.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new SettleException(e);
				}
		}
	}

	private static CloseableHttpClient getDualSSLConnection(
			String keyStorePath, String keyStorePass) {
		CloseableHttpClient httpClient = null;
		try {
			File file = new File(keyStorePath);
			URL sslJksUrl = file.toURI().toURL();
			KeyStore keyStore = KeyStore.getInstance("jks");
			InputStream is = null;
			try {
				is = sslJksUrl.openStream();
				keyStore.load(is,
						keyStorePass != null ? keyStorePass.toCharArray()
								: null);
			} finally {
				if (is != null)
					is.close();
			}
			SSLContext sslContext = new SSLContextBuilder()
					.loadKeyMaterial(keyStore, keyStorePass.toCharArray())
					.loadTrustMaterial(null, new TrustStrategy() {
						@Override
						public boolean isTrusted(
								X509Certificate[] paramArrayOfX509Certificate,
								String paramString) throws CertificateException {
							return true;
						}
					}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
					sslContext,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			httpClient = HttpClients.custom().setSSLSocketFactory(sslsf)
					.setDefaultRequestConfig(config).build();
			return httpClient;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * 创建单向ssl的连接
	 * 
	 * @return
	 * @throws AppException
	 */
	private static CloseableHttpClient getSingleSSLConnection() {
	
		try {
			CloseableHttpClient httpClient = null;
			RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory> create();
			ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
			registryBuilder.register("http", plainSF);
			// 指定信任密钥存储对象和连接套接字工厂
			try {
				KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
				// 信任任何链接
				TrustStrategy anyTrustStrategy = new TrustStrategy() {
					@Override
					public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
						return true;
					}
				};
				SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy).build();
				LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
				registryBuilder.register("https", sslSF);
			} catch (KeyStoreException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (KeyManagementException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
			Registry<ConnectionSocketFactory> registry = registryBuilder.build();
			PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
			httpClient = HttpClientBuilder.create().setConnectionManager(cm).build();
			return httpClient;
		} catch (Exception e) {
			e.printStackTrace();
			throw new SettleException(e);
		}
	}
	
	public static Map<String, String> paraseXml(String xml)
			throws DocumentException {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Document document = DocumentHelper.parseText(xml);
			Iterator<Element> root = document.getRootElement()
					.elementIterator();
			while (root.hasNext()) {
				Element element = root.next();
				map.put(element.getName(), element.getText());
			}
		} catch (DocumentException e) {
			throw e;
		}
		return map;
	}

	
	public static void main(String[] args) {
		
		
		
		String httpUrl="https://地址/GetCheckFile.do? checkDate =20121212& checkType =A& instId =mmm& reqTime =20121213041313& signedMsg =sss";
		
		/*
		 * String strSendData =
		 * "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"
		 * ; // System.out.println(strSendData.length()); // //String
		 * plain=RybSign.verify(strSendData, "1111",
		 * "E:\\民生宝\\svn\\msbaobatchtask\\batchtask\\src\\99022.pfx",
		 * "E:\\民生宝\\svn\\msbaobatchtask\\batchtask\\src\\bank2048.cer"); String
		 * strings=
		 * "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Root><Version>1.0.0</Version><InstId>99022</InstId><MessageId>14120203502099022595</MessageId><CertId>DLDReq</CertId><FileType>LT22</FileType><ClearDate>2014-12-01</ClearDate></Root>"
		 * ; try { System.out.println(paraseXml(strings)); } catch
		 * (DocumentException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } String
		 * url=SystemUtil.getSystemValue("downFileHttpServerUrl"); String
		 * purchasePath
		 * =SystemUtil.getSystemValue("purchaseFileDownPath")+File.separator
		 * +StringUtil.getCurrDate(); String fileName=StringUtil.getCurrTime();
		 * File file=new File(purchasePath); if(!file.exists()){ file.mkdirs();
		 * } purchasePath=purchasePath+File.separator+fileName; //String
		 * paths=Config.class.getResource("").getPath();
		 * //System.out.println(paths); strSendData=RybSign.sign(strings,
		 * "1111", "cn\\msec\\bao\\settleman\\batch\\resources\\99022.pfx",
		 * "cn\\msec\\bao\\settleman\\batch\\resources\\bank2048.cer");
		 * System.out.println(strSendData.length()+" "+strSendData); boolean
		 * flag
		 * =doPost(strings,"http://111.205.207.118:55008/ltweb/ltconnect.do",
		 * purchasePath+".zip",purchasePath+".txt"); System.out.println(flag);
		 */
	}

	@Override
	public SettleSteps getSettleStep() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processMessage(CalcMutex pack) {
		// TODO Auto-generated method stub
		
	}
}
