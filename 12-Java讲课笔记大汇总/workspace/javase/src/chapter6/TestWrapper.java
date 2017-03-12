package chapter6;

public class TestWrapper {

	public static void main(String[] args) {
		
//		int i = 10;
//		Integer objInt = new Integer(i);//手动装箱
//		int j = objInt.intValue();//手动拆箱
//		System.out.println(j);

		int i = 10;
		Integer objInt = i;//自动装箱（基本类型转引用类型）等价于new Integer(i)
		int j = objInt + 100;//自动拆箱（引用类型转基本类型）等价于objInt.intValue()
		System.out.println(j);
		
		//自动装箱必须是匹配的基本类型！
		Double objDouble = 3.0;
		Float objFloat = 3.14f;
		Long objLong = 100L;
		
		//objDouble = objFloat;//错误，包装类是没有大小之分的
		
		//比较相等必须用equals
		Integer objInt1 = 1000;
		Integer objInt2 = 1000;		
		System.out.println(objInt1 == objInt2);//false
		System.out.println(objInt1.equals(objInt2));//true
		
		//在-128~127之间是走常量池的同一个对象
		Integer objInt3 = 127;
		Integer objInt4 = 127;		
		System.out.println(objInt3 == objInt4);//true
		
		//基本类型无法赋予空值，包装类可以
		Integer salary = null;
	}

}