package chapter6;

/**
 * 多态的实际用途
 */
public class TestEmp5 {

	public static void main(String[] args) {
		
		Employee e = new Employee("tom",2400,"1989-6-3");		
		Manager m = new Manager("jack",3600,"1991-5-2","NEC开发部");
		
		TestEmp5 t = new TestEmp5();
		t.print(e);
		t.print(m);
	}
	
	/**
	 * 只需要声明一个方法，就可以接收Manager和Employee对象	 
	 */
	public void print(Employee e) {
		System.out.println(e.getDetails());
	}
	
}