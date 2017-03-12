package chapter6;

public class TestString {

	public static void main(String[] args) {
		
		String s1 = "abc";
		String s2 = "abc";
				
		String s3 = new String("abc");
		String s4 = new String("abc");
		
		System.out.println(s1 == s2);
		System.out.println(s3 == s4);
		
		System.out.println(s3.equals(s4));

	}

}
