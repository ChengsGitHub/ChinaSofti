package chapter6.b;

import chapter6.a.A;

public class C extends A {
	
	public void m1() {
	
		//this.i = 100;//不能访问
		//this.j = 100;//不能访问
		this.k = 100;//由于是子类，虽然不同包，但也可以访问
		this.n = 100;		
	}	

}
