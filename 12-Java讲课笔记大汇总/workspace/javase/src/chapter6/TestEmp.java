package chapter6;

public class TestEmp {

	public static void main(String[] args) {
		
		Employee emp = new Employee("tom",2400,"1989-6-3");		
		System.out.println(emp.getDetails());
		
		Manager manager = new Manager("tom",2400,"1989-6-3","ICSS");
		System.out.println(manager.getDetails());
		
	}

}