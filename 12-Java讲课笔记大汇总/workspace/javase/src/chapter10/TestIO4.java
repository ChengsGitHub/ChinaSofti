package chapter10;

import java.io.FileWriter;
import java.io.IOException;

/**
 * �ļ��ַ������FileWriter 
 *
 */
public class TestIO4 {
	
	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("f:\\4.txt",true);

		fw.write("�й������ž�");
		fw.write("abcdefg");
		
		fw.close();
	}

}