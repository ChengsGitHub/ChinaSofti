package chapter6.mypoint;

public class TestMyPoint {
	
	public static void main(String[] args) {
		
		MyPoint mp1 = new MyPoint(5,3);		
		System.out.println(mp1);
		
		MyCircle mc1 = new MyCircle(5,3,10);
		System.out.println(mc1);
		System.out.println(mc1.getArea());
		
		MySphere ms1 = new MySphere(5,3,10,20);
		System.out.println(ms1);
		System.out.println(ms1.getArea());
		System.out.println(ms1.getVolume());
	}

}