package chapter10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �������ͺ��ַ������͵�ת��
 * @author Administrator
 *
 */
public class TestSimpleDateFormat {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//DateתString
		Date d = new Date();
		String s = sdf.format(d);
		System.out.println(s);

		//StringתDate
		s = "2007-6-9 14:36:27";
		d = sdf.parse(s);
		System.out.println(d);
	}

}