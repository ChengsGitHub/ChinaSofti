package chapter7.innerclass;

public class TestInnerClass {

	public static void main(String[] args) {
		
		A a = new A();
		A.B b = a.new B();//�������ͨ���ⲿ�����new
		b.m2();
		
		A.C c = new A.C();
	}

}