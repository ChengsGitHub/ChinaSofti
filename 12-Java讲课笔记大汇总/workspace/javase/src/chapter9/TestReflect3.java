package chapter9;

import java.lang.reflect.Method;

/**
 * ��̬��������
 */
public class TestReflect3 {

	public static void main(String[] args) throws Exception {

		// Student���͵�Class����
		Class c1 = Student.class;

		Student stu = (Student) c1.newInstance();
				
		Method m1 = c1.getMethod("setName",String.class);
		
		m1.invoke(stu, "jack");
		
		Method m2 = c1.getMethod("getName");
		
		String name = (String) m2.invoke(stu);
		
		System.out.println(name);

	}

}