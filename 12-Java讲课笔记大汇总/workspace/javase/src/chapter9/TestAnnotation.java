package chapter9;

import java.lang.reflect.Method;

/**
 * 用反射扫描注解，添加扩展功能
 *
 */
public class TestAnnotation {

	public static void main(String[] args) {
		
		Class c1 = Student.class;
		
		Method[] methods = c1.getDeclaredMethods();
		
		for (Method m : methods) {
			
			if ( m.isAnnotationPresent(MyAnnotation.class) ) {
				MyAnnotation anno = m.getAnnotation(MyAnnotation.class);
				System.out.println("记录日志" + anno.id() + "," + anno.name());
			}
			
			System.out.println(m.getName());
		}

	}

}