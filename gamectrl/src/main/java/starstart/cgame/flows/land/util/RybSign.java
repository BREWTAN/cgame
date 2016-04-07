package starstart.cgame.flows.land.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.StringReader;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.util.Enumeration;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import sun.misc.BASE64Encoder;
import Union.JnkyServer;
import Union.UnionException;

public class RybSign {
	public String sign(String plain, String pwd, String pfxPath,
			String bankCertPath) {
		JnkyServer jnkyServer = new JnkyServer(bankCertPath, pfxPath, pwd);
		return jnkyServer.EnvelopData(plain);
	}
	public static String getBASE64(byte[] s)
	  {
	    if (s == null) {
	      return null;
	    }
	    String base64Str = new BASE64Encoder().encode(s);
	    
	    BufferedReader readBase64 = new BufferedReader(new StringReader(
	      base64Str));
	    
	    StringBuffer returndata = new StringBuffer();
	    String temp = new String();
	    try
	    {
	      while ((temp = readBase64.readLine()) != null) {
	        returndata.append(temp);
	      }
	    }
	    catch (Exception e)
	    {
	      return null;
	    }
	    return new String(returndata);
	  }
	  
	public static int readPfx2Cert(byte[] pfxFile, String pfxPassword)
	  {
	    Security.addProvider(new BouncyCastleProvider());
	    
	    String alias = "";
	    try
	    {
	      ByteArrayInputStream inStream = new ByteArrayInputStream(pfxFile);
	      
	      KeyStore RSAkeyStore = KeyStore.getInstance("PKCS12", "BC");
	      
	      RSAkeyStore.load(inStream, pfxPassword.toCharArray());
	      
	      Enumeration EnumTemp = RSAkeyStore.aliases();
	      for (int certnum = 0; EnumTemp.hasMoreElements(); certnum++) {
	        alias = EnumTemp.nextElement().toString();
	      }
	      Certificate bankCert = RSAkeyStore
	        .getCertificate(alias);
	      
	      String Cert = getBASE64(bankCert.getEncoded());
	      
	      PrivateKey PriRsaKey = (PrivateKey)RSAkeyStore.getKey(alias, 
	        pfxPassword.toCharArray());
	      System.out.println("Cert:"+Cert+"::PriRsaKey="+PriRsaKey);
	     
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	      return -5;
	    }
	    int certnum;
	    return 0;
	  }
	 private static ByteArrayOutputStream readFile(String filename)
	  {
	    try
	    {
	      FileInputStream fileInStream = new FileInputStream(filename);
	      ByteArrayOutputStream fileByteStream = new ByteArrayOutputStream();
	      int i = 0;
	      while ((i = fileInStream.read()) != -1) {
	        fileByteStream.write(i);
	      }
	      fileInStream.close();
	      return fileByteStream;
	    }
	    catch (Exception e)
	    {
	      System.out.println(e);
	    }
	    return null;
	  }
	public String sign2(String plain, String pwd, String pfxPath,
			String bankCertPath) {
		byte[] bankcerts=readFile(bankCertPath).toByteArray();
		byte[] merchantPemPfx=readFile(pfxPath).toByteArray();
		JnkyServer jnkyServer;
		try {
			jnkyServer = new JnkyServer(bankcerts, merchantPemPfx, pwd);
			System.out.println(jnkyServer.readPfx2Cert(merchantPemPfx, pwd));
			readPfx2Cert(merchantPemPfx, pwd);
			return jnkyServer.EnvelopData(plain);
		} catch (UnionException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String verify(String signatrue, String pwd, String pfxPath,
			String bankCertPath) {
		String plain = "";
		JnkyServer jnkyServer = new JnkyServer(bankCertPath, pfxPath, pwd);
		try {
			plain = jnkyServer.DecryptData(signatrue);
			if (plain == null) {
				throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return plain;
	}
}
