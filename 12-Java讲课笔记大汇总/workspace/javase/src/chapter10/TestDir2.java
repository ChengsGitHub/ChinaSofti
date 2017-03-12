package chapter10;

import java.io.File;

public class TestDir2 {

	public static void main(String[] args) {
		
		File dir = new File("f:\\企业整站");
		
		//返回目录中的文件和目录的名称
		String[] names = dir.list();
		
		for (String name : names) {
			System.out.println(name);
		}

	}

}