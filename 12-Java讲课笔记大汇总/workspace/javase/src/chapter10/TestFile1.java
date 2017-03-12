package chapter10;

import java.io.File;
import java.util.Date;

public class TestFile1 {

	public static void main(String[] args) {
		
		File f = new File("f:\\1.txt");
		
		System.out.println(f.getName());//文件名
		System.out.println(f.getAbsolutePath());//绝对路径
		System.out.println(f.length());//文件大小
		System.out.println(f.exists());//是否存在
		System.out.println(f.canWrite());//是否可写
		System.out.println(f.isFile());//是否文件
		System.out.println(f.isDirectory());//是否目录
						
		Date d = new Date(f.lastModified());//最后修改时间 
		System.out.println(d);				
	}

}