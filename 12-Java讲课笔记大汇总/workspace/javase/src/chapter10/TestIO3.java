package chapter10;

import java.io.FileReader;
import java.io.IOException;

/**
 * 文件字符输入流FileReader 
 */
public class TestIO3 {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("f:\\3.txt");
		
		int i = fr.read();
		
		while (i != -1) {
			System.out.print((char)i);
			i = fr.read();
		}

		fr.close();
	}

}