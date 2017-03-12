package chapter6;

public class TestThis {
	
	public void m1() {
		System.out.println(this);
	}

	public static void main(String[] args) {
		
		TestThis t1 = new TestThis();
		TestThis t2 = new TestThis();
		System.out.println(t1);
		t1.m1();
		
		System.out.println("-------------------");
		
		System.out.println(t2);
		t2.m1();

	}

}
