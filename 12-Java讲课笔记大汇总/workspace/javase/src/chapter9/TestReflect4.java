package chapter9;

import java.lang.reflect.Constructor;

/**
 * ��̬������͵Ĺ�������Ϣ
 */
public class TestReflect4 {

	public static void main(String[] args) throws Exception {

		int[] a = new int[3];
		
		Class c1 = a.getClass();
		
		Constructor[] c = c1.getConstructors();
		
		System.out.println(c.length);
		
	}

}