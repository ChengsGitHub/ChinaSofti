package chapter6;

/**
 * toString方法
 * @author Administrator
 *
 */
public class TestToString {

	public static void main(String[] args) {
		
		Employee e = new Employee("tom",2400,"1989-6-3");		
		Manager m = new Manager("jack",3600,"1991-5-2","NEC开发部");
		
		System.out.println(e);
		System.out.println(m);
		
		String s = "员工信息：" + e;
		System.out.println(s);
		
	}

}