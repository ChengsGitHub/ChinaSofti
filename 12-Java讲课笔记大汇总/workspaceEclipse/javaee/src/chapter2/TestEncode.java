package chapter2;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * url±àÂë×ª»»
 * @author Administrator
 *
 */
public class TestEncode {
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		String s = "ÄãºÃ";
		String s2 = URLEncoder.encode(s,"utf-8");
		System.out.println(s2);
		
		String s3 = "%E4%BD%A0%E5%A5%BD";
		String s4 = URLDecoder.decode(s3, "utf-8");
		System.out.println(s4);
	}

}
