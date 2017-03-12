package chapter10;

import java.io.File;

public class TestDir3 {

	public static void main(String[] args) {
		
		File dir = new File("f:\\企业整站");
		
		//返回目录中的文件和目录的对象
		File[] files = dir.listFiles();
		
		for (File f : files) {
			System.out.println(f.getName() + "," + f.length());
		}

	}

}