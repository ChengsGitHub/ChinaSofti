package chapter7;

/**
 * final���η� 
 */
public class TestFinal {
	
	public final int I = 10;
	
	public static final double PI = 3.1415927;

	public void m1() {
		
		//I = 11;//���󣬳���ֻ�ܸ�һ��ֵ��
		
		final int J;
		J = 10;
		System.out.println(J);
	}

	public static void main(String[] args) {		
		System.out.println(TestFinal.PI);
	}

}

class TestFinalTwo extends TestFinal {
	
	public void m1() {

	}

}