package chapter9;

import java.lang.reflect.Constructor;

/**
 * 动态获得类型的构造器信息
 */
public class TestReflect4 {

	public static void main(String[] args) throws Exception {

		int[] a = new int[3];
		
		Class c1 = a.getClass();
		
		Constructor[] c = c1.getConstructors();
		
		System.out.println(c.length);
		
	}

}