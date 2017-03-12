package chapter10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期类型和字符串类型的转换
 * @author Administrator
 *
 */
public class TestSimpleDateFormat {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//Date转String
		Date d = new Date();
		String s = sdf.format(d);
		System.out.println(s);

		//String转Date
		s = "2007-6-9 14:36:27";
		d = sdf.parse(s);
		System.out.println(d);
	}

}