package chapter10;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * 递归遍历目录树 
 */
public class TestDir5 {
	
	public static void main(String[] args) {		
		File dir = new File("f:\\root");
		print(dir,0);
	}
	
	/**
	 * 递归输出目录中的子目录和文件名称	 
	 */
	public static void print(File dir,int level) {
		
		level ++;
		
		File[] files = dir.listFiles();
		
		for (File f : files) {
			//输出前导符
			for (int i = 1;i < level;i ++)
				System.out.print("...");
			
			System.out.println(f.getName());
			
			if (f.isDirectory())
				print(f,level);//如果是目录，递归调用（传入当前目录对象） 
		}				
	}

}