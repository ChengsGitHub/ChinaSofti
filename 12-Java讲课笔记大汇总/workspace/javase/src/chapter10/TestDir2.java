package chapter10;

import java.io.File;

public class TestDir2 {

	public static void main(String[] args) {
		
		File dir = new File("f:\\��ҵ��վ");
		
		//����Ŀ¼�е��ļ���Ŀ¼������
		String[] names = dir.list();
		
		for (String name : names) {
			System.out.println(name);
		}

	}

}