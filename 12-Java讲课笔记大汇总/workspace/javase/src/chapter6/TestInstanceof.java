package chapter6;

/**
 *instanceof������ж�һ�������Ƿ���ĳ�����ͻ�ĳ�����͵��������� 
 *
 */
public class TestInstanceof {

	public static void main(String[] args) {
		
		Employee e = new Employee("tom",2400,"1989-6-3");		
		Manager m = new Manager("jack",3600,"1991-5-2","NEC������");
		
		Employee e2 = new Manager("jack",3600,"1991-5-2","NEC������");
		
		System.out.println(e instanceof Employee);
		System.out.println(e instanceof Manager);
		System.out.println(m instanceof Manager);
		System.out.println(m instanceof Employee);
		System.out.println(e2 instanceof Manager);
		System.out.println(e2 instanceof Object);
	}

}