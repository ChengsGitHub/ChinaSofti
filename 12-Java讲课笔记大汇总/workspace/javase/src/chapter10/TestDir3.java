package chapter10;

import java.io.File;

public class TestDir3 {

	public static void main(String[] args) {
		
		File dir = new File("f:\\��ҵ��վ");
		
		//����Ŀ¼�е��ļ���Ŀ¼�Ķ���
		File[] files = dir.listFiles();
		
		for (File f : files) {
			System.out.println(f.getName() + "," + f.length());
		}

	}

}