package chapter8;

/**
 * throws：在方法后面加异常抛出声明
 * @author Administrator
 *
 */
public class TestException5 {

	public static void main(String[] args) {
		
		try {
			m1();
		} catch (Exception e) {			
			e.printStackTrace();
		}	
		
		System.out.println("程序结束");
	}
	
	public static void m1() throws Exception {
		m2();
	}

	public static void m2() throws ClassNotFoundException {
		Class c1 = Class.forName("chapter666.mypoint.MyPoint");
		System.out.println(c1.getName());
	}

}