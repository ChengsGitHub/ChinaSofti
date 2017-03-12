package chapter6;

/**
 * ÖØÔØ·½·¨
 * @author Administrator
 *
 */
public class TestOverload {
	
	protected int sum(int a,int b) {
		return a + b;
	}
		
	public int sum(int a,int b,int c) {
		return a + b + c;
	}
	
	private double sum(double x,double y) {
		return x + y;
	}

	public static void main(String[] args) {
		
		TestOverload t = new TestOverload();
		System.out.println( t.sum(5,3) );

	}

}