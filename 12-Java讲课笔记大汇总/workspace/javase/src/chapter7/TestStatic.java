package chapter7;

/**
 * 静态成员
 */
public class TestStatic {

	public static void main(String[] args) {

		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();

		c1.j = 10;
		c2.j = 20;

		Count.m1();
	}

}

class Count {

	public static int i = 100;
	public int j = 0;
	
	static {		
		i = 100;
		System.out.println("静态初始化块1。。。");
	}

	public Count() {
		i++;
		j++;
	}
	
	static {
		System.out.println("静态初始化块2。。。");
	}

	public static void m1() {
		System.out.println("i=" + i);// 可以直接访问静态成员
		Count c = new Count();
		System.out.println("j=" + c.j);// 访问非静态成员必须通过创建对象访问
	}

}