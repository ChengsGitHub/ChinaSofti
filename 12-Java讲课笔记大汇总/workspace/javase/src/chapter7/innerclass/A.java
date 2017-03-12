package chapter7.innerclass;

public class A {
	
	private int i = 10;	
	private int j = 20;
	
	public void m1() {
		System.out.println("A_m1");		
		B b = new B();//�������ֱ��new�ڲ������		
	}
	
	public void m3(){		
		final int N = 100;//�ֲ��ڲ���ֻ��ֱ�ӷ��ʷ�����final����
		
		//�ֲ��ڲ���
		class D {
			public void m1() {
				System.out.println("D_m1");
				System.out.println("j=" + j);
				System.out.println("N=" + N);
			}
		}
		
		D d = new D();		
	}
	
	//ʵ���ڲ���
	public class B {
		
		private int i = 30;		
		private int k = 40;
		
		public void m2() {
			System.out.println("B_m2");
			System.out.println("i=" + A.this.i);
			System.out.println("j=" + j);
		}
		
	}
	
	//��̬�ڲ���
	public static class C {
		
	}

}
