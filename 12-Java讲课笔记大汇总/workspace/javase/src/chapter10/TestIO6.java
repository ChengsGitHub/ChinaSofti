package chapter10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter�ַ���������� 
 *
 */
public class TestIO6 {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("f:\\6.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("�й������ž�");
		bw.newLine();//���ݲ���ϵͳ�ӻ��з�
		bw.write("abcdefg");
		bw.newLine();
				
		bw.close();
		
	}

}