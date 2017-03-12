package chapter6;

/**
 * 构造器调用会一直延伸到Object
 * @author Administrator
 *
 */
public class A {

	public A() {
		
		System.out.println("A");
	}

	public static void main(String[] args) {
		new C();
	}

}

class B extends A {

	public B() {
		
		System.out.println("B");
	}
}

class C extends B {

	public C() {
		
		System.out.println("C");
	}

}