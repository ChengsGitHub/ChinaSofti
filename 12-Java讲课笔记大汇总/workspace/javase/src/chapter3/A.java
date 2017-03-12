package chapter3;

public class A {
	public int i = 5;
	public int j = 7;
	public B b = new B();
	
	public A(int c,int d){
		j = c;
		b.k = 90;
	}
	
	public void setValue(){		
		i = b.k;
		b.k = 3000;
	}
	
	public static void main(String args[]){
		A a = new A(1000,1001);
		B b = new B();
		b.k = 40;
		a.setValue();
		System.out.println(a.i);
		System.out.println(a.j);
		System.out.println(b.k);
		System.out.println(a.b.k);
	}
}

class B{
	
	public int k = 10;	
	
	public B(){
		k = 25;
	}
}
