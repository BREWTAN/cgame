package starstart.cgame.flows.land.util;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
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
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import starstart.cgame.flows.nsttl.exception.SettleException;
public class HttpClient431Util {
    private static final RequestConfig config;
    
    public static final String DEFAULT_SEND_CHARSET = "UTF-8";    
    public static final String DEFAULT_RES_CHARSET = "UTF-8"; 
    static {
        config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(60000).build();
    } 
    public static String doGet( Map<String, String> params,String url){
        return doGet(params,url,DEFAULT_SEND_CHARSET,DEFAULT_RES_CHARSET);
    }
    public static String doPost(Map<String, String> params,String url){
        return doPost(params,url,DEFAULT_SEND_CHARSET,DEFAULT_RES_CHARSET);
    }
    public static String doDualSSLPost(Map<String, String> params,String url,String keyStorePath,String keyStorePass){
    	return doDualSSLPost(params, url, DEFAULT_SEND_CHARSET, DEFAULT_RES_CHARSET, keyStorePath, keyStorePass);
    }
    public static byte[] doPostContent(String dataContent,String contentType,String contentCharset,String resCharset,String url){
       	CloseableHttpClient httpClient = getSingleSSLConnectionHttps();
       	CloseableHttpResponse response = null;
        if(StringUtil.isEmpty(url)){
            return null;
        }
        try {
            HttpPost httpPost = new HttpPost(url);
            
            httpPost.addHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
            httpPost.addHeader("Content-Type", contentType);
            HttpEntity reqentity = new StringEntity(dataContent,ContentType.create(contentType, contentCharset) );
            httpPost.setEntity(reqentity);
            
            response = httpClient.execute(httpPost);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpPost.abort();
            }
            HttpEntity entity = response.getEntity();
            byte[] result = null;
            if (entity != null){
                result = EntityUtils.toByteArray(entity);//toString(entity, resCharset==null?DEFAULT_RES_CHARSET:resCharset);
            }
            EntityUtils.consume(entity);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
        	if(response!=null)
            try {
				response.close();
			} catch (IOException e) {
			}
        }
        return null;
    }
    /**
     * HTTP Get 获取内容
     * @param params 请求的参数
     * @param url  请求的url地址 ?之前的地址
     * @param reqCharset    编码格式
     * @param resCharset    编码格式
     * @return    页面内容
     */
    public static String doGet(Map<String,String> params,String url,String reqCharset,String resCharset){
    	CloseableHttpClient httpClient = getSingleSSLConnection();
       	CloseableHttpResponse response = null;
        if(StringUtil.isEmpty(url)){
            return null;
        }
        try {
            if(params != null && !params.isEmpty()){
                List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
                for(Map.Entry<String,String> entry : params.entrySet()){
                    String value = entry.getValue();
                    if(value != null){
                        pairs.add(new BasicNameValuePair(entry.getKey(),value));
                    }
                }
                url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, reqCharset==null?DEFAULT_SEND_CHARSET:reqCharset));
            }
            HttpGet httpGet = new HttpGet(url);
            httpGet.addHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
            
            
            response = httpClient.execute(httpGet);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode != 200) {
                httpGet.abort();               
            }
            HttpEntity entity = response.getEntity();
            String result = null;
            if (entity != null){
                result = EntityUtils.toString(entity, resCharset==null ? DEFAULT_RES_CHARSET:resCharset);
            }
            EntityUtils.consume(entity);
            response.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
        	if(response!=null)
                try {
    				response.close();
    			} catch (IOException e) {
    			}
            }
        return null;
    }
    
   /**
    * HTTP Post 获取内容
    * @param params 请求的参数
    * @param url  请求的url地址 ?之前的地址
    * @param reqCharset    编码格式
	* @param resCharset    编码格式
    * @return    页面内容
    */
   public static String doPost(Map<String,String> params,String url,String reqCharset,String resCharset){
   	CloseableHttpClient httpClient = getSingleSSLConnection();
   	CloseableHttpResponse response = null;
       if(StringUtil.isEmpty(url)){
           return null;
       }
       try {
           List<NameValuePair> pairs = null;
           if(params != null && !params.isEmpty()){
               pairs = new ArrayList<NameValuePair>(params.size());
               for(Map.Entry<String,String> entry : params.entrySet()){
                   String value = entry.getValue();
                   if(value != null){
                       pairs.add(new BasicNameValuePair(entry.getKey(),value));
                   }
               }
           }
           HttpPost httpPost = new HttpPost(url);
           httpPost.addHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
           if(pairs != null && pairs.size() > 0){
               httpPost.setEntity(new UrlEncodedFormEntity(pairs,reqCharset==null?DEFAULT_SEND_CHARSET:reqCharset));
           }
           response = httpClient.execute(httpPost);
           int statusCode = response.getStatusLine().getStatusCode();
           if (statusCode != 200) {
               httpPost.abort();
           }
           HttpEntity entity = response.getEntity();
           String result = null;
           if (entity != null){
               result = EntityUtils.toString(entity, resCharset==null?DEFAULT_RES_CHARSET:resCharset);
           }
           EntityUtils.consume(entity);
           response.close();
           return result;
       }
       catch (Exception e) {
          e.printStackTrace();
       }finally{
        	if(response!=null)
            try {
				response.close();
			} catch (IOException e) {
			}
        }
       return null;
   }
   
  /**
   * HTTP Post 获取内容
   * @param params 请求的参数
   * @param url  请求的url地址 ?之前的地址
   * @param reqCharset    编码格式
	* @param resCharset    编码格式
   * @return    页面内容
   */
  public static String doPost(Map<String,String> params,String url,String reqCharset,String resCharset,String contentType){
  	CloseableHttpClient httpClient = getSingleSSLConnection();
   	CloseableHttpResponse response = null;
      if(StringUtil.isEmpty(url)){
          return null;
      }
      try {
          List<NameValuePair> pairs = null;
          if(params != null && !params.isEmpty()){
              pairs = new ArrayList<NameValuePair>(params.size());
              for(Map.Entry<String,String> entry : params.entrySet()){
                  String value = entry.getValue();
                  if(value != null){
                      pairs.add(new BasicNameValuePair(entry.getKey(),value));
                  }
              }
          }
          HttpPost httpPost = new HttpPost(url);
          httpPost.addHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
          httpPost.addHeader("Content-Type",contentType);
          if(pairs != null && pairs.size() > 0){
              httpPost.setEntity(new UrlEncodedFormEntity(pairs,reqCharset==null?DEFAULT_SEND_CHARSET:reqCharset));
          }
          response = httpClient.execute(httpPost);
          int statusCode = response.getStatusLine().getStatusCode();
          if (statusCode != 200) {
              httpPost.abort();
          }
          HttpEntity entity = response.getEntity();
          String result = null;
          if (entity != null){
              result = EntityUtils.toString(entity, resCharset==null?DEFAULT_RES_CHARSET:resCharset);
          }
          EntityUtils.consume(entity);
          response.close();
          return result;
      } catch (Exception e) {
          e.printStackTrace();
      } finally{
        	if(response!=null)
            try {
				response.close();
			} catch (IOException e) {
			}
      }
      return null;
  }
   
	  /**
	   * HTTP Post 获取内容
	   * @param params 请求的参数
	   * @param url  请求的url地址 ?之前的地址
	   * @param reqCharset    编码格式
	   * @param resCharset    编码格式
	   * @return    页面内容
	   */
	  public static String doDualSSLPost(Map<String,String> params,String url,String reqCharset,String resCharset,String keyStorePath,String keyStorePass){
		  CloseableHttpClient httpClient = getDualSSLConnection(keyStorePath,keyStorePass);
	       	CloseableHttpResponse response = null;
	      if(StringUtil.isEmpty(url)){
	          return null;
	      }
	      try {
	          List<NameValuePair> pairs = null;
	          if(params != null && !params.isEmpty()){
	              pairs = new ArrayList<NameValuePair>(params.size());
	              for(Map.Entry<String,String> entry : params.entrySet()){
	                  String value = entry.getValue();
	                  if(value != null){
	                      pairs.add(new BasicNameValuePair(entry.getKey(),value));
	                  }
	              }
	          }
	          HttpPost httpPost = new HttpPost(url);
	          httpPost.addHeader("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1)");
	          if(pairs != null && pairs.size() > 0){
	              httpPost.setEntity(new UrlEncodedFormEntity(pairs,reqCharset==null?DEFAULT_SEND_CHARSET:reqCharset));
	          }
	          response = httpClient.execute(httpPost);
	          int statusCode = response.getStatusLine().getStatusCode();
	          if (statusCode != 200) {
	              httpPost.abort();
	          }
	          HttpEntity entity = response.getEntity();
	          String result = null;
	          if (entity != null){
	              result = EntityUtils.toString(entity, resCharset==null?DEFAULT_RES_CHARSET:resCharset);
	          }
	          EntityUtils.consume(entity);
	          response.close();
	          return result;
	      } catch (Exception e) {
	          e.printStackTrace();
	      } finally{
	        	if(response!=null)
	                try {
	    				response.close();
	    			} catch (IOException e) {
	    			}
	      }
	      return null;
	  }
  
	 
	 
	 
	 
	 
	 
	 /**
	  * 创建双向ssl的连接
	  * @param keyStorePath
	  * @param keyStorePass
	  * @return
	  * @throws AppException
	  */
	 private static CloseableHttpClient getDualSSLConnection(String keyStorePath,String keyStorePass){
	 	CloseableHttpClient httpClient = null;
	 	try {
				File file = new File(keyStorePath);
				URL sslJksUrl = file.toURI().toURL();
				KeyStore keyStore  = KeyStore.getInstance("jks");
				InputStream is = null;
				try {
					is = sslJksUrl.openStream(); 
					keyStore.load(is, keyStorePass != null ? keyStorePass.toCharArray(): null);
				} finally {
					if (is != null) is.close();
				}
				SSLContext sslContext = new SSLContextBuilder().loadKeyMaterial(keyStore, keyStorePass.toCharArray())
				.loadTrustMaterial(null,new TrustStrategy() {
					@Override
					public boolean isTrusted(X509Certificate[] paramArrayOfX509Certificate,
							String paramString) throws CertificateException {
						return true;
					}
				})
				.build();
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
				httpClient =  HttpClients.custom().setSSLSocketFactory(sslsf).setDefaultRequestConfig(config).build();
				return httpClient;
			} catch (Exception e) {
				e.printStackTrace();
			}
	 	return null;
	 }
	 /**
	  * 创建单向ssl的连接
	  * @return
	  * @throws AppException
	  */
	private static CloseableHttpClient getSingleSSLConnection(){
	 	CloseableHttpClient httpClient = null;
	 	try {
				SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null,new TrustStrategy() {
					@Override
					public boolean isTrusted(X509Certificate[] paramArrayOfX509Certificate,
							String paramString) throws CertificateException {
						return true;
					}
				}).build();
				SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
				httpClient =  HttpClients.custom().setSSLSocketFactory(sslsf).setDefaultRequestConfig(config).build();
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
	private static CloseableHttpClient getSingleSSLConnectionHttps() {
	
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
}
