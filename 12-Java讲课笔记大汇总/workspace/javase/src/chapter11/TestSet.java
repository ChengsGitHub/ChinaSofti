package chapter11;

import java.util.HashSet;
import java.util.Iterator;

/**
 * set���� 
 */
public class TestSet {

	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("tom");
		set.add("jack");
		set.add("rose");
		set.add("jack");//�ظ�Ԫ���޷�����
				
		System.out.println("�����ǣ�" + set.size());

		//�������Ϸ�ʽ1
		for (String item : set) {			
			System.out.println(item);
		}
		
		System.out.println("---------------------");
		
		//�������Ϸ�ʽ2
		Iterator<String> it = set.iterator();//�õ����ϵı���������
		
		while (it.hasNext()) {			
			System.out.println(it.next());
		}
		
	}

}