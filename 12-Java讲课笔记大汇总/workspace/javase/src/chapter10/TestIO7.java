package chapter10;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * PrintWriter��ֱ���ṩ�˻�������ķ������ȽϷ���
 *
 */
public class TestIO7 {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("f:\\9.txt");
		pw.println("�й������ž�");
		pw.println("abcdefg");
		pw.close();

	}

}