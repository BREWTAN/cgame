package starstart.cgame.flows.land.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipInputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
 * 
* @ClassName: Des3KeyCryptFile 
* @Description: 文件 Des3 加密、解密
* @author kyn
* @date 2015年4月14日 下午5:48:53 
*
 */
public class Des3KeyCryptFile {
	
	private static String pfxPath;
	private static String cerPath;
	private static String key;
	private static String pwd;
   
    
    //设置流解密模式
    public static InputStream decodeStream(String threeDesKey, InputStream fileInputStream)
			  throws Exception {
				InputStream decryptInputStream = decryptMode(threeDesKey, fileInputStream);
				ZipInputStream zipIn = new ZipInputStream(decryptInputStream);
				if (zipIn.getNextEntry() == null) {
					return null;
				}
				return zipIn;
			}
    
    //生成des3秘钥 设置数据流为解密模式
	public static CipherInputStream decryptMode(String des3Key, InputStream inputStream) 
		throws Exception {
		//生成密钥          
		SecretKey deskey = new SecretKeySpec(des3Key.getBytes(), "DESede"); //解密    
		Cipher c1 = Cipher.getInstance("DESede");
		c1.init(Cipher.DECRYPT_MODE, deskey);  
		return new CipherInputStream(inputStream, c1);
	}
	
	
	/**
	 * @param args
	 */

	/**
	 * 
	 * @Title: encryptFile 文件 file 进行加密并保存目标文件 destFile 中
	 * @Description: TODO
	 * @param @param des3Key
	 * @param @param file
	 * @param @param destFile
	 * @param @throws Exception
	 * @return void
	 */
	public static void encryptFile(String des3Key, String str, String destFile)
			throws Exception {

		Cipher cipher = Cipher.getInstance("DESede");
		SecretKey deskey = new SecretKeySpec(des3Key.getBytes(), "DESede"); // 解密
		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		InputStream is = new FileInputStream(str);
		OutputStream out = new FileOutputStream(destFile);

		CipherInputStream cis = new CipherInputStream(is, cipher);
		byte[] buffer = new byte[1024];
		int r;
		while ((r = cis.read(buffer)) > 0) {
			out.write(buffer, 0, r);
		}
		cis.close();
		is.close();
		out.close();

	}
	
	public static void setKeyPfxCerPath(String key,String pfxPath,String cerPath,String pwd){
		setKey(key);
		setPfxPath(pfxPath);
		setCerPath(cerPath);
		setPwd(pwd);
	}

	/**
	 * 将摘要信息转换为相应的编码
	 * @param code 编码类型
	 * @param message 摘要信息
	 * @return 相应的编码字符串
	 */
	public static String Encode(String code,byte[] message){
		MessageDigest md;
		String encode = null;
		try {
			md = MessageDigest.getInstance(code);
			encode = byteArrayToHexString(md.digest(message));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encode;
	}
	
	public static String byteArrayToHexString(byte[] b) {
	    StringBuffer sb = new StringBuffer(b.length * 2);
	    for (int i = 0; i < b.length; i++) {
	      int v = b[i] & 0xff;
	      if (v < 16) {
	        sb.append('0');
	      }
	      sb.append(Integer.toHexString(v));
	    }
	    return sb.toString().toUpperCase();
	  }
	public static String getPfxPath() {
		return pfxPath;
	}

	public static void setPfxPath(String pfxPath) {
		Des3KeyCryptFile.pfxPath = pfxPath;
	}

	public static String getCerPath() {
		return cerPath;
	}

	public static void setCerPath(String cerPath) {
		Des3KeyCryptFile.cerPath = cerPath;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Des3KeyCryptFile.key = key;
	}

	public static String getPwd() {
		return pwd;
	}

	public static void setPwd(String pwd) {
		Des3KeyCryptFile.pwd = pwd;
	}

	
}
