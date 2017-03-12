package chapter6.duotai;

public class TestABC {

	public static void main(String[] args) {

		A a = new A();
		B b = new B();
		C c = new C();
				
		c = (C) a;
		c.m1();
		
	}

}