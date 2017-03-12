package chapter7.innerclass;

public class TestNoNameClass {

	public static void main(String[] args) {
		
		//��̬����һ������������ಢ�Ҵ����������Ķ���
		E e = new E(){			
			public void m2() {
				System.out.println("F_m2");		
			}			
		};		
		e.m1();
		e.m2();
		
		//��̬����һ���ӿڵ�����ʵ���ಢ�Ҵ������ʵ����Ķ���
		G g = new G(){
			@Override
			public void m1() {
				System.out.println("G_m1");				
			}			
		};
		g.m1();
	}
}

abstract class E {
	
	public void m1() {
		System.out.println("E_m1");
	}
	
	public abstract void m2();
}

interface G {
	void m1();
}