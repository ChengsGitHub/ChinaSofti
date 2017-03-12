package chapter6.mypoint;

/**
 * ≤‚ ‘equasl∑Ω∑®
 * @author Administrator
 *
 */
public class TestEquals2 {
	
	public static void main(String... args) {
		
		MyPoint mp1 = new MyPoint(5,3);		
				
		MyCircle mc1 = new MyCircle(5,3,10);
				
		System.out.println(mp1.equals(mc1));
											
	}

}