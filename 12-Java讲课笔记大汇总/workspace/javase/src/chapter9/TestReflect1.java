package chapter9;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * ��̬������͵�������Ϣ 
 */
public class TestReflect1 {

	public static void main(String[] args) {

		//Student���͵�Class����
		Class c1 = Student.class;

		//������͵�������������
		Field[] fields = c1.getDeclaredFields();

		//�����������������Ϣ
		for (Field f : fields) {
			System.out.println(Modifier.toString(f.getModifiers()) + ":"
					+ f.getName() + ":" + f.getType());
		}

	}

}