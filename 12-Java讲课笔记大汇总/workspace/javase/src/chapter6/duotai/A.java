package chapter6.duotai;

public class A {

	public int i = 10;
	
	public int j = 20;
	
	public void m1() {
		System.out.println("A_m1");
	}
	
	public void m2() {
		System.out.println("A_m2");
	}
	
	public void m4() {
		m1();
	}
		
}