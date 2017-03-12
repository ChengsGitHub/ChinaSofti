package chapter7.innerclass;

public class A {
	
	private int i = 10;	
	private int j = 20;
	
	public void m1() {
		System.out.println("A_m1");		
		B b = new B();//这里可以直接new内部类对象		
	}
	
	public void m3(){		
		final int N = 100;//局部内部类只能直接访问方法的final常量
		
		//局部内部类
		class D {
			public void m1() {
				System.out.println("D_m1");
				System.out.println("j=" + j);
				System.out.println("N=" + N);
			}
		}
		
		D d = new D();		
	}
	
	//实例内部类
	public class B {
		
		private int i = 30;		
		private int k = 40;
		
		public void m2() {
			System.out.println("B_m2");
			System.out.println("i=" + A.this.i);
			System.out.println("j=" + j);
		}
		
	}
	
	//静态内部类
	public static class C {
		
	}

}
