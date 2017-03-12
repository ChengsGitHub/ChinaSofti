package chapter12;

import java.util.ArrayList;

/**
 * 泛型的基本使用
 */
public class TestGeneric1 {

	public static void main(String[] args) {
		
		//创建对象的时候设置泛型为String
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("tom");
		
		String name = list.get(0);
		
		System.out.println(name);
		
	}

}