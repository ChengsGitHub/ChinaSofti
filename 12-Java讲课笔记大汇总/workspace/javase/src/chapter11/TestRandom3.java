package chapter11;

public class TestRandom3 {

	public static void main(String[] args) {
		
		for (int i = 1;i <= 20;i ++) {			
			char r = (char) ((90 - 65 + 1) * Math.random() + 65);			
			System.out.println(r);
		}
		
	}

}