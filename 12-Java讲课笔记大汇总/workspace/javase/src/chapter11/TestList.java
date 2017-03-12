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
		
		list.set(3, "john");//�滻Ԫ��
		list.remove(2);//ɾ��Ԫ��
		
		System.out.println("�����ǣ�" + list.size());

		//�������Ϸ�ʽ1��
		for (int i = 0;i < list.size(); i++) {
			System.out.println(list.get(i));//ͨ���±����Ԫ��
		}
		
		System.out.println("------------------");
		
		//�������Ϸ�ʽ2��
		for (String item : list) {			
			System.out.println(item);
		}
		
		System.out.println("------------------");
		
		//�������Ϸ�ʽ3��
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}