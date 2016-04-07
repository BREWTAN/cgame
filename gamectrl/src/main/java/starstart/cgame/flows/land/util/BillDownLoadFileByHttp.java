package starstart.cgame.flows.land.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.config.RequestConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.util.TokenBuffer;

import starstart.cgame.flows.msg.entity.BodyRequestBean;
import starstart.cgame.flows.msg.entity.RequestPackage;
import starstart.cgame.flows.msg.entity.ResponsePackage;
import starstart.cgame.flows.nsttl.exception.SettleException;
import starstart.cgame.flows.outils.security.certificate.DESCoder;
import starstart.cgame.flows.outils.security.certificate.DesException;
import starstart.cgame.flows.outils.security.certificate.MD5Util;
import starstart.cgame.flows.outils.security.certificate.ZlibUtils;
import starstart.cgame.flows.utils.TradeLocal;
import cn.msec.bao.outils.serialize.SerializerFactory;

/**
 * 
 * @ClassName: RybDownLoadFileByHttp
 * @Description: 从产品方（如意宝） 获取文件方法
 * @author kyn
 * @date 2015年4月14日 下午5:49:21
 *
 */
@Slf4j
public class BillDownLoadFileByHttp {

	private static final RequestConfig config;
	private final static String CHARSET = "utf-8";
	static {
		config = RequestConfig.custom().setConnectTimeout(60000)
				.setSocketTimeout(60000).build();
	}

	public boolean doPost(Map paramMap) {
		InputStream input = null;
		FileOutputStream fileOutput = null;

		try {
			String CHANNEL_URL = (String) paramMap.get("CHANNEL_URL");
			String PRI_KEY = (String) paramMap.get("PRI_KEY");
			String ENT_TYPE = (String) paramMap.get("ENT_TYPE");
			String SETTLE_DATE = (String) paramMap.get("SETTLE_DATE");
			String FILE_TYPE = (String) paramMap.get("FILE_TYPE");
			int succLength = (int) paramMap.get("succLength");
			RequestPackage pack = new RequestPackage();
			List<BodyRequestBean> dataList = new ArrayList<BodyRequestBean>();
			pack.setVersion("1.0.0");
			pack.setMsgsentid(IDHelper.getBMessageId(paramMap
					.get("PROD_MCH_ID").toString()));
			pack.setMsgtype("MSCS.801");
			pack.setSender("MSCS");
			pack.setReceiver(paramMap.get("MCH_ID").toString());
			BodyRequestBean dataContent = new BodyRequestBean();
			dataContent.setSttldate(SETTLE_DATE);
			dataContent.setProducttype(Constants.FNLN);
			dataContent.setProductmchno(StringUtil.isEmpty(paramMap
					.get("PROD_MCH_ID")) ? "" : paramMap.get("PROD_MCH_ID")
					.toString());
			dataContent.setProductchannelno(StringUtil.isEmpty(paramMap
					.get("PROD_MCH_ID")) ? "" : paramMap.get("PROD_MCH_ID")
					.toString());
			dataContent.setFiletype(FILE_TYPE);
			dataList.add(dataContent);
			pack.setReqbeans(dataList);
			log.debug("发送请求报文明文：" + pack.toString());
			byte[] jsonresult;
			String settdate = SETTLE_DATE.replace("-", "").substring(2);
			if ("2".equals(ENT_TYPE)) {
				// 签名
				String beanbody = new String((byte[]) SerializerFactory
						.getSerializer(SerializerFactory.SERIALIZER_JSON)
						.serialize(pack.getReqbeans()));
				String encbody = DESCoder.desEncrypt(beanbody, PRI_KEY
						+ "MSBAO" + pack.getMsgtype() + TradeLocal.getToday());
				String mac = MD5Util.GetMessageDigest((String) encbody, "MD5");
				pack.setChecksum(mac);// 验签
				pack.setBody(encbody);
				log.debug("发送请求报文：" + serialize(pack));
				jsonresult = HttpClient431Util.doPostContent(serialize(pack),
						"application/json", "utf-8", "utf-8", CHANNEL_URL);

			} else {
				// 发送请求并获取执行结果
				log.debug("发送请求报文：" + serialize(pack));
				jsonresult = HttpClient431Util.doPostContent(serialize(pack),
						"application/json", "utf-8", "utf-8", CHANNEL_URL);
			}
			log.debug("返回的报文jsonresult：" + jsonresult.length + "//"
					+ jsonresult);
			byte[] respbody = new byte[1024];
			System.arraycopy(jsonresult, 0, respbody, 0, 1024);
			log.debug("返回的报文内容：" + new String(respbody, "utf-8"));
			ResponsePackage resp = checkAndDecBody(respbody, ENT_TYPE, PRI_KEY);
			if (resp == null) {
				return false;
			}
			BodyRequestBean resp802 = resp.getBeans().get(0);
			if (!StringUtils.equals("0000", resp802.getStatus())) {
				return false;
			}
			// 流读入压缩文件
			/*
			 * byte[] digest = new byte[jsonresult.length - succLength];
			 * System.arraycopy(jsonresult, succLength, digest, 0,
			 * jsonresult.length - succLength);
			 */
			String zipFilePath = (String) paramMap.get("zipFilePath");
			String txtFilePath = (String) paramMap.get("txtFilePath");

			input = new ByteArrayInputStream(jsonresult, succLength,
					jsonresult.length);
			InputStream in = null;
			if ("2".equals(ENT_TYPE)) {
				in = DESCoder.desFromInStream(input, PRI_KEY
						+ "MSBAOMSCS.802" + settdate);
			}else{
				in = input;
			}
			File file = new File(zipFilePath); // 加密文件流保存本地文件
			file.getParentFile().mkdirs();
			if (!file.exists()) {
				file.createNewFile();
			}
			log.debug("文件保存到路径file to save------------：" + file);
			fileOutput = new FileOutputStream(file);
			IOUtils.copy(in, fileOutput);
			in.close();
			input.close();
			fileOutput.close();
			/*
			 * String resultbody = DESCoder.desDecrypt(new String(resultbyte),
			 * CHANNEL_PRI_KEY+ "MSCS.802" + TradeLocal.getToday());
			 * System.out.println("解密文件流："+resultbody);
			 */
			File file2 = new File(txtFilePath); // 解密文件
			if (!file2.exists()) {
				file2.createNewFile();
			}
			FileInputStream fileInput = new FileInputStream(file); // 读入加密文件流
			FileOutputStream fileOutput2 = new FileOutputStream(file2);
			byte[] dataInput;
			dataInput = ZlibUtils.decompress(fileInput);
			// String filedata = DESCoder.desFromBytes(dataInput, PRI_KEY
			// + "MSBAOMSCS.802" + settdate);
			// 使用3des密钥对加密文件流进行解密
			ByteArrayInputStream dis = new ByteArrayInputStream(dataInput);
			/*
			 * InputStream dataInput =
			 * Des3KeyCryptFile.decodeStream(CHANNEL_PRI_KEY+ "MSCS.802" +
			 * TradeLocal.getToday(), fileInput); // 使用3des密钥对加密文件流进行解密
			 * DataInputStream dis = new DataInputStream(dataInput);
			 */
			IOUtils.copy(dis, fileOutput2);
			fileInput.close();
			fileOutput2.close();
			return true;
			/*
			 * } else { File file2 = new File(txtFilePath); // 解密文件 if
			 * (!file2.exists()) { file2.createNewFile(); } FileInputStream
			 * fileInput = new FileInputStream(file); // 读入加密文件流
			 * FileOutputStream fileOutput2 = new FileOutputStream(file2);
			 * DataInputStream dis = new DataInputStream(fileInput);
			 * IOUtils.copy(dis, fileOutput2); fileInput.close();
			 * fileOutput2.close(); return true; }
			 */
		} catch (Exception e) {
			e.printStackTrace();
			throw new SettleException(e);
		} finally {
			if (input != null)
				try {
					input.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new SettleException(e);
				}
			if (fileOutput != null) {
				try {
					fileOutput.close();
				} catch (Exception e) {
					e.printStackTrace();
					throw new SettleException(e);
				}
			}
		}

	}

	/**
	 * 并根据根据渠道的秘钥解开body内容
	 * 
	 * @param channelinf
	 * @param pack
	 */
	public ResponsePackage checkAndDecBody(byte[] jsonresult, String ent_type,
			String prikey) {
		ResponsePackage resp = null;
		try {
			// 解析报文
			resp = SerializerFactory.getSerializer(
					SerializerFactory.SERIALIZER_JSON).deserialize(jsonresult,
					ResponsePackage.class);
		} catch (Exception e) {
			log.debug("解析报文错误：" + jsonresult + "，" + e);
			return null;
		}
		try {
			if ("2".equals(ent_type)) {
				String mac = "";
				if (resp.getBody() instanceof String) {
					mac = MD5Util.GetMessageDigest((String) resp.getBody(),
							"MD5");
				}
				if (!StringUtils.equals(mac, resp.getChecksum())) {
					log.debug("密文校验失败:" + resp.getBody());
					return null;
				}
				String rawbody = DESCoder.desDecrypt(
						(String) resp.getBody(),
						prikey + "MSBAO" + resp.getMsgtype()
								+ TradeLocal.getToday());
				resp.setRawbody(rawbody);
			} else if ("1".equals(ent_type)) {
				log.debug("证书签名");
			} else {
				String jsonraw = mapper.writeValueAsString(resp.getBody());
				log.debug("json.body.raw==" + jsonraw);
				resp.setRawbody(jsonraw);
			}
		} catch (Exception e) {
			log.debug("报文体解析出错" + e);
			return null;
		}
		List<BodyRequestBean> list = SerializerFactory.getSerializer(
				SerializerFactory.SERIALIZER_JSON).deserializeArray(
				resp.getRawbody().getBytes(), BodyRequestBean.class);
		resp.setBeans(list);
		return resp;
	}

	/**
	 * JSON的验证器
	 */
	ObjectMapper mapper = new ObjectMapper();

	/**
	 * JSON序列化
	 * 
	 * @param data
	 * @return
	 */
	public String serialize(Object data) {
		try {
			TokenBuffer buffer = new TokenBuffer(mapper);
			mapper.writeValue(buffer, data);
			return mapper.readTree(buffer.asParser()).toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		RequestPackage pack = new RequestPackage();
		List<BodyRequestBean> dataList = new ArrayList<BodyRequestBean>();
		pack.setVersion("1.0");
		pack.setMsgsentid("20150806CFQMT90000011");
		pack.setMsgtype("MSCS.801");
		pack.setSender("CFQM");
		pack.setReceiver("MSCS");
		pack.setMsgsenttime("2015-08-06T11:47:36");
		pack.setCompressmode("NONE");
		BodyRequestBean dataContent = new BodyRequestBean();
		dataContent.setSttldate("2015-08-05");
		dataContent.setProducttype(Constants.FNLN);
		dataContent.setProductmchno("99035");
		dataContent.setProductchannelno("99035");
		dataContent.setFiletype("MSCS.PRF");
		dataList.add(dataContent);
		pack.setReqbeans(dataList);
		String beanbody = new String((byte[]) SerializerFactory.getSerializer(
				SerializerFactory.SERIALIZER_JSON)
				.serialize(pack.getReqbeans()));
		String encbody;
		try {
			encbody = DESCoder.desEncrypt(beanbody,
					"1111MSBAO" + pack.getMsgtype() + "150806");
			String mac = MD5Util.GetMessageDigest((String) encbody, "MD5");
			pack.setChecksum(mac);// 验签
			pack.setBody(encbody);
		} catch (DesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BillDownLoadFileByHttp http = new BillDownLoadFileByHttp();
		System.out.println("发送请求报文：" + http.serialize(pack));
		byte[] jsonresult = HttpClient431Util.doPostContent(
				http.serialize(pack), "application/json", "utf-8", "utf-8",
				"http://172.30.12.44:28080/osgi/itrade/tr801.do");
		System.out.println("返回应答报文：" + jsonresult.length);
		System.out.println();
		ByteArrayInputStream in = null;
		try {
			in = new ByteArrayInputStream(jsonresult);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
		// 首先提取前1024字节
		byte[] buff = new byte[1024];
		int rc = 0;
		if ((rc = in.read(buff, 0, 1024)) > 0) {
			swapStream.write(buff, 0, rc);
		}
		String str = null;
		try {
			str = new String(buff, "utf-8").trim();
			System.out.println("返回的报文内容" + str);
		} catch (UnsupportedEncodingException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ResponsePackage mscMsgResponse = SerializerFactory.getSerializer(
				SerializerFactory.SERIALIZER_JSON).deserialize(str.getBytes(),
				ResponsePackage.class);
		String debody = null;
		try {
			debody = DESCoder.desDecrypt((String) mscMsgResponse.getBody(),
					"1111MSBAOMSCS.802150806");
			System.out.println("返回的报文体" + debody);
		} catch (DesException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		mscMsgResponse.setBody(debody);
		List<BodyRequestBean> list = SerializerFactory.getSerializer(
				SerializerFactory.SERIALIZER_JSON).deserializeArray(
				debody.getBytes(), BodyRequestBean.class);
		BodyRequestBean bean = list.get(0);
		// 获取余下字节
		if (StringUtils.equals("0000", bean.getStatus())) {
			/*
			 * ByteArrayInputStream swapStreamFile = new ByteArrayInputStream();
			 * byte[] buffRemain = new byte[1024]; while ((rc =
			 * in.read(buffRemain, 0, 1024)) > 0) {
			 * swapStreamFile.write(buffRemain, 0, rc); }
			 */
			InputStream result;
			try {
				result = DESCoder
						.desFromInStream(in, "1111MSBAOMSCS.802150620");
				/*
				 * ZipFileUtils ziputil = new ZipFileUtils();
				 * ByteArrayOutputStream bos = new ByteArrayOutputStream();
				 * byte[] b = new byte[1024]; int t = 0 ;
				 * while((t=result.read(b))!=-1){ bos.write(b, 0, t); }
				 * System.out.println(new String(bos.toByteArray()));
				 */
				byte[] bytes = ZlibUtils.decompress(result);
				System.out.println(new String(bytes));
				// boolean bytes = ziputil.unzip(result, new
				// File("e:\\test\\222.txt"));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// 将字节流解压缩

			// 解密字节流
			// String result;

		}
	}

}
