package chapter9;

import java.lang.reflect.Method;

/**
 * 动态获得类型的方法信息
 */
public class TestReflect2 {

	public static void main(String[] args) {

		// Student类型的Class对象
		Class c1 = Student.class;

		// 获得类型的所有声明属性
		Method[] methods = c1.getDeclaredMethods();

		// 遍历属性输出属性信息
		for (Method m : methods) {
			System.out.println(m.getName() + ":" + m.getReturnType());
		}

	}

}