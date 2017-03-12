package chapter10;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * �ݹ����Ŀ¼�� 
 */
public class TestDir5 {
	
	public static void main(String[] args) {		
		File dir = new File("f:\\root");
		print(dir,0);
	}
	
	/**
	 * �ݹ����Ŀ¼�е���Ŀ¼���ļ�����	 
	 */
	public static void print(File dir,int level) {
		
		level ++;
		
		File[] files = dir.listFiles();
		
		for (File f : files) {
			//���ǰ����
			for (int i = 1;i < level;i ++)
				System.out.print("...");
			
			System.out.println(f.getName());
			
			if (f.isDirectory())
				print(f,level);//�����Ŀ¼���ݹ���ã����뵱ǰĿ¼���� 
		}				
	}

}