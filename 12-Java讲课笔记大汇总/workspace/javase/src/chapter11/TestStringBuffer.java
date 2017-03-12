package chapter11;

/**
 * StringBuffer是可变字符串 
 */
public class TestStringBuffer {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();//开始时间
		
		StringBuffer sb = new StringBuffer();//空字符串对象
		
		//10000次拼接字符串
		for (int i = 1;i <= 10000;i ++) {
			sb.append(i);
			sb.append('\n');
		}

		long end = System.currentTimeMillis();//结束时间
		
		System.out.println(sb);
		
		System.out.println("耗费的时间：" + (end-start) );
	}

}