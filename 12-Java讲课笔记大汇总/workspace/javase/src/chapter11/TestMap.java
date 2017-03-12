package chapter11;

import java.util.HashMap;
import java.util.Set;

public class TestMap {
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		//����Ԫ��
		map.put(1001, "tom");
		map.put(1002, "jack");
		map.put(1007, "rose");
		map.put(1002, "john");
		
		System.out.println("�����ǣ�" + map.size());
		
		//�����������ֵ
		System.out.println(map.get(1002));//john
		System.out.println(map.get(1003));//null
		
		System.out.println("------------------");
		
		//����Map���ϣ��Ȼ�����е�key����ͨ��key����ֵ
		Set<Integer> keys = map.keySet();
		
		for (Integer key  : keys) {
			String value = map.get(key);
			System.out.println(key + "=" + value);
		}
		
	}

}