package chapter6;

/**
 * ��̬���� 
 */
public class TestEmp4 {

	public static void main(String[] args) {
		
		Employee e = new Manager("tom",2400,"1989-6-3","NEC������");
						
		System.out.println(e.getDetails());	//���õ�ʵ����������ĸ��Ƿ���
		
		System.out.println(e.getName());
		System.out.println(e.getSalary());
		System.out.println(e.getBirthDate());
		
		Manager m = (Manager) e;//��������ת�����������ͱ���ǿ��ת��
		System.out.println(m.getDepartment());
				
		Object o = m;
		System.out.println(o);//����ʱ������Manager���ͣ�
				
//		���³���ᷢ��ClassCastException�쳣
//		Employee emp = new Employee("tom",2400,"1989-6-3");
//		Manager mgr = (Manager) emp;
//		System.out.println(mgr.getDepartment());
		
//		String s = "abcd";
//		o = s;
//		m = (Manager) o;
		
	}

}