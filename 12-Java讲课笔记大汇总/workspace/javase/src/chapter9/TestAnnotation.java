package chapter9;

import java.lang.reflect.Method;

/**
 * �÷���ɨ��ע�⣬�����չ����
 *
 */
public class TestAnnotation {

	public static void main(String[] args) {
		
		Class c1 = Student.class;
		
		Method[] methods = c1.getDeclaredMethods();
		
		for (Method m : methods) {
			
			if ( m.isAnnotationPresent(MyAnnotation.class) ) {
				MyAnnotation anno = m.getAnnotation(MyAnnotation.class);
				System.out.println("��¼��־" + anno.id() + "," + anno.name());
			}
			
			System.out.println(m.getName());
		}

	}

}