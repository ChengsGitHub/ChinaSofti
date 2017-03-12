package chapter8;

import java.io.FileNotFoundException;

public class TestException7 {

	public static void main(String[] args) {
		
		A a = new B();
		a.m2();

	}

}

class A {
	
	public void m1() throws Exception {
		System.out.println("A_m1");
	}
	
	public void m2() {
		try {
			m1();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
}

class B extends A {
	public void m1() throws FileNotFoundException,ClassNotFoundException {
		System.out.println("B_m1");
	}
}