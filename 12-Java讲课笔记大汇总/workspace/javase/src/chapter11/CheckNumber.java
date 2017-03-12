package chapter11;

/**
 * 产生20个随机的4位大写字母和数字的混合验证码 A4JK 56UI
 * 
 */
public class CheckNumber {

	public static void main(String[] args) {
		
		int j = 0;
		
		while(true){
			
				int k = (int)(('Z' - '0' + 1) * Math.random() + '0');
				
				if(k >= 'A' && k <= 'Z'){
					System.out.print((char)k);
					j++;
					if(j % 4 == 0)
						System.out.println();
				
				}
				
				if(k >= '0' && k <= '9'){
					System.out.print((char)k);
					j++;
					if(j % 4 == 0)
						System.out.println();
				}
				
				if(j == 80) return;
				
		}

	}
}
