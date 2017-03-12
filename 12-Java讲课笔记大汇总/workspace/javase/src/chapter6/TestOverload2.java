package chapter6;

/**
 * 可变长参数：可以接收任意个数的参数 可以认为是一种特殊的重载方法
 * 
 * @author Administrator
 * 
 */
public class TestOverload2 {

	/**
	 * 传入任意个整数 返回相加的结果	 
	 */
	public int sum(int... a) {

		int sumResult = 0;

		for (int i = 0; i < a.length; i++) {
			sumResult += a[i];
		}

		return sumResult;
	}

	public static void main(String[] args) {

		TestOverload2 t = new TestOverload2();
		int result = t.sum(5, 4, 3, 2, 1, 7, 8, 9, 10);
		System.out.println("总和：" + result);
		
	}

}