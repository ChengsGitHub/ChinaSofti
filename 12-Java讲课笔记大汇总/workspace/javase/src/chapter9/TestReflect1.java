package chapter9;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 动态获得类型的属性信息 
 */
public class TestReflect1 {

	public static void main(String[] args) {

		//Student类型的Class对象
		Class c1 = Student.class;

		//获得类型的所有声明属性
		Field[] fields = c1.getDeclaredFields();

		//遍历属性输出属性信息
		for (Field f : fields) {
			System.out.println(Modifier.toString(f.getModifiers()) + ":"
					+ f.getName() + ":" + f.getType());
		}

	}

}