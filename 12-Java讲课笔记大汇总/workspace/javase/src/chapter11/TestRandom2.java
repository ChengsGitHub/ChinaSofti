package chapter11;

public class TestRandom2 {

	public static void main(String[] args) {
		
		for (int i = 1;i <= 20;i ++) {		
			
			int r = (int) ((10 - 1 + 1) * Math.random() + 1);
			
			if (r <= 9)
				System.out.println("ะก");
			else
				System.out.println("ด๓");
		}
		
	}

}