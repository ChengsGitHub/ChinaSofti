package chapter12;

import java.util.ArrayList;

/**
 * ���͵Ļ���ʹ��
 */
public class TestGeneric1 {

	public static void main(String[] args) {
		
		//���������ʱ�����÷���ΪString
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("tom");
		
		String name = list.get(0);
		
		System.out.println(name);
		
	}

}