package chapter10;

import java.io.File;
import java.text.SimpleDateFormat;

public class TestDir4 {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

	public static void main(String[] args) {
		
		File dir = new File("f:\\��ҵ��վ");
		print(dir);
		
	}
	
	/**
	 * ����һ��Ŀ¼����dir�������Ŀ¼�е��ļ���Ŀ¼����Ϣ
		����޸�ʱ��   		�ļ�/Ŀ¼    	��С     ����
		2005-6-9 15:30   �ļ�	        6587     1.txt
		2005-6-9 15:30   Ŀ¼			0		 abc
		��XXX���ļ�
		��XXX��Ŀ¼
	 */
	public static void print(File dir) {
				
		File[] files = dir.listFiles();
		
		int fileCount = 0;
		int dirCount = 0;
		
		for (File f : files) {
			System.out.print(sdf.format(f.lastModified()) + "\t\t");
			System.out.print( (f.isFile()?"�ļ�":"Ŀ¼") + "\t\t");
			
			if (f.isFile())
				System.out.print(f.length() + "\t\t");
			else
				System.out.print(getSize(f) + "\t\t");
			
			System.out.print(f.getName());
			System.out.println();
			
			if (f.isFile())
				fileCount ++;
			else
				dirCount ++;
		}
		
		System.out.println("��" + fileCount + "���ļ�");
		System.out.println("��" + dirCount + "��Ŀ¼");
		
	}

	//����һ��Ŀ¼������Ŀ¼�Ĵ�С
	public static long getSize(File dir) {
		
		long sumSize = 0;//�ۼӴ�С
		
		File[] files  = dir.listFiles();
		
		for (File f : files) {
			if (f.isFile())
				sumSize = sumSize + f.length();
			else
				sumSize = sumSize + getSize(f);//��Ŀ¼���ݹ���÷���ֵ�ۼ�
		}
		
		return sumSize;
	}
}