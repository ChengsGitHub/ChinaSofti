package chapter10;

import java.io.File;
import java.text.SimpleDateFormat;

public class TestDir4 {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");

	public static void main(String[] args) {
		
		File dir = new File("f:\\企业整站");
		print(dir);
		
	}
	
	/**
	 * 传入一个目录，仿dir命令输出目录中的文件和目录的信息
		最后修改时间   		文件/目录    	大小     名称
		2005-6-9 15:30   文件	        6587     1.txt
		2005-6-9 15:30   目录			0		 abc
		共XXX个文件
		共XXX个目录
	 */
	public static void print(File dir) {
				
		File[] files = dir.listFiles();
		
		int fileCount = 0;
		int dirCount = 0;
		
		for (File f : files) {
			System.out.print(sdf.format(f.lastModified()) + "\t\t");
			System.out.print( (f.isFile()?"文件":"目录") + "\t\t");
			
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
		
		System.out.println("共" + fileCount + "个文件");
		System.out.println("共" + dirCount + "个目录");
		
	}

	//传入一个目录，返回目录的大小
	public static long getSize(File dir) {
		
		long sumSize = 0;//累加大小
		
		File[] files  = dir.listFiles();
		
		for (File f : files) {
			if (f.isFile())
				sumSize = sumSize + f.length();
			else
				sumSize = sumSize + getSize(f);//是目录，递归调用返回值累加
		}
		
		return sumSize;
	}
}