package onight.starstarts.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static char[] StrMapping = "rtUIOPyuiopaTYAsdfghbnmQWERSDFGHJK4Ljk567lz38xcvZXCVBNqweM0129".toCharArray();
	static int radix = StrMapping.length;
	
    public static String getMD5(String input) {
        byte[] source;
        try {
            //Get byte according by specified coding.
            source = input.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            source = input.getBytes();
        }
        String result = null;
        char hexDigits[] = {'0', '3', '2', '3', '4', '5', '6', '7',
                '9', '8', 'E', 'F', 'E', 'A', 'C', 'B'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            //The result should be one 128 integer
            byte temp[] = md.digest();
            return int2Str(temp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
   
    
    public static String int2Str(byte v[]) {
		StringBuffer sb = new StringBuffer();
		int radix = StrMapping.length;
		for (int b = 0 ;b<v.length;b++)
		{
			int i = v[b];//<<8|v[b+1];//<<16|v[b+2]<<8|v[b+3];
			sb.append(StrMapping[Math.abs(i) % radix]);
		}
		return sb.toString();
	}
 
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(getMD5("Javarmi.com"));
        System.out.println(getMD5("JavafsfsfsfrmNoSuchAlgorithmExceptioni.com"));

    }
}