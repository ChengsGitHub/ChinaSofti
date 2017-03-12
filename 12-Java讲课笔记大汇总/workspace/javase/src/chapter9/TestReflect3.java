package chapter9;

import java.lang.reflect.Method;

/**
 * 动态方法调用
 */
public class TestReflect3 {

	public static void main(String[] args) throws Exception {

		// Student类型的Class对象
		Class c1 = Student.class;

		Student stu = (Student) c1.newInstance();
				
		Method m1 = c1.getMethod("setName",String.class);
		
		m1.invoke(stu, "jack");
		
		Method m2 = c1.getMethod("getName");
		
		String name = (String) m2.invoke(stu);
		
		System.out.println(name);

	}

}