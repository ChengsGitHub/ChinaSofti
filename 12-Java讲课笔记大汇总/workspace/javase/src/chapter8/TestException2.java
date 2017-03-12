package chapter8;

public class TestException2 {

	public static void main(String[] args) {
		
		String[] names = {"tom","jack","rose"};
				
		try {	
						
			//int j = 10 / 0;//发生除零错误
						
			for (int i = 0;i <= names.length;i ++) {
				System.out.println(names[i]);
			}	
			
			System.out.println("循环结束");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("发生了下标越界异常：" + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("发生了数学异常：" + e.getMessage());
		}

		System.out.println("程序结束");		
	}

}