package chapter7.innerclass;

public class TestNoNameClass {

	public static void main(String[] args) {
		
		//动态声明一个类的匿名子类并且创建这个子类的对象
		E e = new E(){			
			public void m2() {
				System.out.println("F_m2");		
			}			
		};		
		e.m1();
		e.m2();
		
		//动态声明一个接口的匿名实现类并且创建这个实现类的对象
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