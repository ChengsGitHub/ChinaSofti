package chapter9;

import java.lang.reflect.Method;

/**
 * ��̬������͵ķ�����Ϣ
 */
public class TestReflect2 {

	public static void main(String[] args) {

		// Student���͵�Class����
		Class c1 = Student.class;

		// ������͵�������������
		Method[] methods = c1.getDeclaredMethods();

		// �����������������Ϣ
		for (Method m : methods) {
			System.out.println(m.getName() + ":" + m.getReturnType());
		}

	}

}