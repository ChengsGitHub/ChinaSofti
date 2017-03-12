package chapter11;

public class YanZhengMa {
	
	public static void main(String[] args) {
		
		//20行输出
		for (int i = 1;i <= 20;i ++) {		
			
			//四个验证码
			for (int j = 0; j < 4; j++) {
				
				char r = (char) ((90 - 48 + 1) * Math.random() + 48);
				
				while (r > 57 && r < 65) {
					 r = (char) ((90 - 48 + 1) * Math.random() + 48);					
				}
				
				System.out.print(r);
				
			}
			
			System.out.println();
			
		}
		
	}

}
