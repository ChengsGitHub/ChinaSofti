package chapter10;

import java.io.File;
import java.util.Date;

public class TestFile1 {

	public static void main(String[] args) {
		
		File f = new File("f:\\1.txt");
		
		System.out.println(f.getName());//�ļ���
		System.out.println(f.getAbsolutePath());//����·��
		System.out.println(f.length());//�ļ���С
		System.out.println(f.exists());//�Ƿ����
		System.out.println(f.canWrite());//�Ƿ��д
		System.out.println(f.isFile());//�Ƿ��ļ�
		System.out.println(f.isDirectory());//�Ƿ�Ŀ¼
						
		Date d = new Date(f.lastModified());//����޸�ʱ�� 
		System.out.println(d);				
	}

}