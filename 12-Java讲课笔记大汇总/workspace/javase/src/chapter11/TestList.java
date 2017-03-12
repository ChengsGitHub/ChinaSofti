package chapter11;

import java.util.ArrayList;
import java.util.Iterator;

public class TestList {

	public static void main(String[] args) {
				
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("tom");
		list.add("jack");
		list.add("rose");
		list.add("jack");
		
		list.set(3, "john");//替换元素
		list.remove(2);//删除元素
		
		System.out.println("长度是：" + list.size());

		//遍历集合方式1：
		for (int i = 0;i < list.size(); i++) {
			System.out.println(list.get(i));//通过下标访问元素
		}
		
		System.out.println("------------------");
		
		//遍历集合方式2：
		for (String item : list) {			
			System.out.println(item);
		}
		
		System.out.println("------------------");
		
		//遍历集合方式3：
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}