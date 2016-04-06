package onight.tfw.rest.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServletUtils {
	public static String getPostData(HttpServletRequest req) {
		StringBuffer sb = new StringBuffer();
		try {
			InputStream inputStream = req.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			String buffer = null;
			while ((buffer = br.readLine()) != null) {
				sb.append(buffer);
			}
		} catch (IOException e) {
			log.error("getPostData error :",e);
		}
		return sb.toString();
	}

}
