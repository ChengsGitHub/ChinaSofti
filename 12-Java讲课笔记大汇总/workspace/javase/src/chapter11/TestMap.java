package chapter11;

import java.util.HashMap;
import java.util.Set;

public class TestMap {
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//增加元素
		map.put(1001, "tom");
		map.put(1002, "jack");
		map.put(1007, "rose");
		map.put(1002, "john");
		
		System.out.println("长度是：" + map.size());
		
		//传入键，返回值
		System.out.println(map.get(1002));//john
		System.out.println(map.get(1003));//null
		
		System.out.println("------------------");
		
		//遍历Map集合，先获得所有的key，再通过key返回值
		Set<Integer> keys = map.keySet();
		
		for (Integer key  : keys) {
			String value = map.get(key);
			System.out.println(key + "=" + value);
		}
		
	}

}