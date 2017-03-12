package chapter11;

import java.util.HashSet;
import java.util.Iterator;

/**
 * set集合 
 */
public class TestSet {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("tom");
		set.add("jack");
		set.add("rose");
		set.add("jack");//重复元素无法加入
				
		System.out.println("长度是：" + set.size());

		//遍历集合方式1
		for (String item : set) {			
			System.out.println(item);
		}
		
		System.out.println("---------------------");
		
		//遍历集合方式2
		Iterator<String> it = set.iterator();//得到集合的遍历器对象
		
		while (it.hasNext()) {			
			System.out.println(it.next());
		}
		
	}

}