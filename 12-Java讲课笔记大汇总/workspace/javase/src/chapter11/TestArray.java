package chapter11;

public class TestArray {

	public static void main(String[] args) {
		
		int[] a = new int[3];
		a[0] = 100;
		a[1] = 101;
		a[2] = 102;
		
		a = new int[4];
		
		a[3] = 103;
		
		for (int item : a) {
			System.out.println(item);
		}
	}

}