package chapter6.mypoint;


/**
 * Class∂‘œÛ 
 */
public class TestClass {

	public static void main(String[] args)  {
		
		MyPoint mp1 = new MyPoint(5,3);
		MyPoint mp2 = new MyPoint(5,3);
		
		MyCircle mc1 = new MyCircle(5,3,2);
		
		Class c1 = MyPoint.class;
		Class c2 = mp1.getClass();
		Class c3 = int.class;
		//Class c4 = Class.forName("chapter6.mypoint.MyPoint");
		Class c4 = mp2.getClass();
		Class c5 = MyCircle.class;
		Class c6 = mc1.getClass();
		Class c7 = Integer.class;
		
		System.out.println(c1 == c2);//true
		System.out.println(c2 == c3);//false
		System.out.println(c2 == c4);//true
		System.out.println(c4 == c5);//false
		System.out.println(c5 == c6);//true		
		System.out.println(c3 == c7);//false
	}

}