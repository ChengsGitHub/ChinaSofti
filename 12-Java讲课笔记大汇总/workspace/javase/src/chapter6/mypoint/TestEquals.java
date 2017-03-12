package chapter6.mypoint;

/**
 * ≤‚ ‘equasl∑Ω∑®
 * @author Administrator
 *
 */
public class TestEquals {
	
	public static void main(String... args) {
		
		MyPoint mp1 = new MyPoint(5,3);		
		MyPoint mp2 = new MyPoint(5,3);
				
		System.out.println(mp1.equals(mp2));
		
		MyCircle mc1 = new MyCircle(5,3,10);
		MyCircle mc2 = new MyCircle(5,3,10);
		
		System.out.println(mc1.equals(mc2));
		
		MySphere ms1 = new MySphere(5,3,10,20);
		MySphere ms2 = new MySphere(5,3,10,20);
		
		System.out.println(ms1.equals(ms2));										
	}

}