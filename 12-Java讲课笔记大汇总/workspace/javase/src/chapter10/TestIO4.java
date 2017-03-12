package chapter10;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件字符输出流FileWriter 
 *
 */
public class TestIO4 {
	
	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("f:\\4.txt",true);

		fw.write("中国人民解放军");
		fw.write("abcdefg");
		
		fw.close();
	}

}