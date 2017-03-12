package chapter7;

import static java.lang.Math.*;
import static java.lang.Integer.parseInt;

/**
 * 静态导入某些类的静态属性和静态方法，可以直接使用这些属性和方法，而无需加类名
 * @author Administrator
 *
 */
public class TestStaticImport {

	public static void main(String[] args) {
		
		System.out.println(PI);
		System.out.println(sqrt(16));
		
		String s = "157";
		int i = parseInt(s);
		System.out.println(i);
		
	}

}