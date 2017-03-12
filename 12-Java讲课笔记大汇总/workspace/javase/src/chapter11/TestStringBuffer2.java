package chapter11;

/**
 * StringBuffer是可变字符串（线程安全的） 
 */
public class TestStringBuffer2 {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("abc");
		
		sb.append("xyz");//拼接
		
		sb.insert(2, "ABC");//插入
		
		sb.reverse();//反转
		
		System.out.println(sb);		
		
	}

}