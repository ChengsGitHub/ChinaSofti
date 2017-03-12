package chapter11;

public class YanzhenMa2 {

	public static void main(String[] args) {
		
		for (int i = 0; i < 20; i++) {
			
			for (int k = 1; k <= 4; k++) {
				
				int c = (int) (((36 - 1 + 1)) * Math.random() + 1);
				
				if (c <= 10) {
					System.out.print((char) (c + 47));//产生数字
				} else {
					System.out.print((char) (c + 54));//产生大写字母
				}
				
			}
			
			System.out.println();

		}
	}
}