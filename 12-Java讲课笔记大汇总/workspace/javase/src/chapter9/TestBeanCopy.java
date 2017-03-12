package chapter9;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import chapter6.mypoint.MyPoint;

public class TestBeanCopy {

	public static void main(String[] args) throws Exception {

		Student stu1 = new Student(100, "tom", "boy");
		Student stu2 = new Student();

		MyPoint mp1 = new MyPoint(5, 3);
		MyPoint mp2 = new MyPoint();

		copy(stu1, stu2);

		System.out.println(mp2);
	}

	// ����������������󣬸���obj1������ֵ��obj2��ͬ������
	public static void copy(Object obj1, Object obj2) throws Exception {

		Class c1 = obj1.getClass();

		// ������͵�������������
		Field[] fields = c1.getDeclaredFields();

		// �����������������Ϣ
		for (Field f : fields) {
			
			//��̬���obj1����������ֵ
			String methodName1 = "get"
					+ String.valueOf(f.getName().charAt(0)).toUpperCase()
					+ f.getName().substring(1);
			Method m1 = c1.getMethod(methodName1);
			Object result = m1.invoke(obj1);
						
			//��̬��obj2�������Ը�ֵ
			String methodName2 = "set"
				+ String.valueOf(f.getName().charAt(0)).toUpperCase()
				+ f.getName().substring(1);
			Method m2 = c1.getMethod(methodName2,f.getType());
			m2.invoke(obj2, result);
		}

	}
}