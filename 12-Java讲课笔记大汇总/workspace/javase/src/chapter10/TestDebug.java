package chapter10;

public class TestDebug {
	
	public static void main(String[] args) {
		
		int i = 10;
				
		int j = 20;
				
		int k = i + j;
		
		System.out.println(k);

		k = m1(k);
		
		System.out.println(k);
	}

	public static int m1(int n) {
		n = n + 10;
		return n;
	}
	
}