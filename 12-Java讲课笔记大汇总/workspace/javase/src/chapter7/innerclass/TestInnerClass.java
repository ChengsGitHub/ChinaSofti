package chapter7.innerclass;

public class TestInnerClass {

	public static void main(String[] args) {
		
		A a = new A();
		A.B b = a.new B();//这里必须通过外部类对象new
		b.m2();
		
		A.C c = new A.C();
	}

}