package chapter6;

/**
 * 多态对象 
 */
public class TestEmp4 {

	public static void main(String[] args) {
		
		Employee e = new Manager("tom",2400,"1989-6-3","NEC开发部");
						
		System.out.println(e.getDetails());	//调用的实际上是子类的覆盖方法
		
		System.out.println(e.getName());
		System.out.println(e.getSalary());
		System.out.println(e.getBirthDate());
		
		Manager m = (Manager) e;//父类类型转换到子类类型必须强制转换
		System.out.println(m.getDepartment());
				
		Object o = m;
		System.out.println(o);//运行时类型是Manager类型！
				
//		以下程序会发生ClassCastException异常
//		Employee emp = new Employee("tom",2400,"1989-6-3");
//		Manager mgr = (Manager) emp;
//		System.out.println(mgr.getDepartment());
		
//		String s = "abcd";
//		o = s;
//		m = (Manager) o;
		
	}

}