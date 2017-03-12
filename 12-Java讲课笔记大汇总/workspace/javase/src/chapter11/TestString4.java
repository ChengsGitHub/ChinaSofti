package chapter11;

public class TestString4 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();//开始时间
		
		String s = "";
		
		for (int i = 1;i <= 10000;i ++) {
			s += i;
			s += '\n';
		}
		
		long end = System.currentTimeMillis();//结束时间
		
		System.out.println(s);
		
		System.out.println("耗费的时间：" + (end-start) );
	}

}
