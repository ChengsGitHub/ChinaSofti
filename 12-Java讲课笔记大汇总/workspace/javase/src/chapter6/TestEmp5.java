package chapter6;

/**
 * ��̬��ʵ����;
 */
public class TestEmp5 {

	public static void main(String[] args) {
		
		Employee e = new Employee("tom",2400,"1989-6-3");		
		Manager m = new Manager("jack",3600,"1991-5-2","NEC������");
		
		TestEmp5 t = new TestEmp5();
		t.print(e);
		t.print(m);
	}
	
	/**
	 * ֻ��Ҫ����һ���������Ϳ��Խ���Manager��Employee����	 
	 */
	public void print(Employee e) {
		System.out.println(e.getDetails());
	}
	
}