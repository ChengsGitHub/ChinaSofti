package chapter10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * �ڿ���̨��������д�뵽�ļ��� 
 *
 */
public class TestIO8 {

	public static void main(String[] args) throws IOException {

		//�ֽ���ת��Ϊ�ַ���
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		//�����
		PrintWriter pw = new PrintWriter("f:\\10.txt");
		
		while (true) {
			String s = br.readLine();
			
			if (s.equals("exit"))
				break;
			
			pw.println(s);
			System.out.println(s);
		}
		
		pw.close();
		br.close();		
	}

}
