package chapter6;

/**
 *instanceof运算符判断一个变量是否是某种类型或某种类型的子类类型 
 *
 */
public class TestInstanceof {

	public static void main(String[] args) {
		
		Employee e = new Employee("tom",2400,"1989-6-3");		
		Manager m = new Manager("jack",3600,"1991-5-2","NEC开发部");
		
		Employee e2 = new Manager("jack",3600,"1991-5-2","NEC开发部");
		
		System.out.println(e instanceof Employee);
		System.out.println(e instanceof Manager);
		System.out.println(m instanceof Manager);
		System.out.println(m instanceof Employee);
		System.out.println(e2 instanceof Manager);
		System.out.println(e2 instanceof Object);
	}

}