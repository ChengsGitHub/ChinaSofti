package chapter11;

/**
 * StringBuilder也是可变字符串（线程不安全的） 
 */
public class TestStringBuilder {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("abc");
		
		sb.append("xyz");//拼接
		
		sb.insert(2, "ABC");//插入
		
		sb.reverse();//反转
		
		System.out.println(sb);		
		
	}

}