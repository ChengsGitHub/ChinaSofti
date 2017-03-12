package chapter11;

public class TestMath1 {

	public static void main(String[] args) {
		
		System.out.println(Math.floor(3.14));//3.0
		System.out.println(Math.floor(3.54));//3.0
		System.out.println(Math.floor(-3.14));//-4.0

		System.out.println("---------------------");
		
		System.out.println(Math.round(3.14));//3
		System.out.println(Math.round(3.54));//4
		System.out.println(Math.round(-3.54));//-4
		
		System.out.println("---------------------");
		
		System.out.println(Math.ceil(3.0000001));//4.0
		System.out.println(Math.ceil(3.00));//3.0
		
		System.out.println("---------------------");
		
		System.out.println(Math.sqrt(16));//4.0
		System.out.println(Math.pow(2, 3));//8.0
		System.out.println(Math.PI);
	}

}