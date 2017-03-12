package chapter10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 在控制台输入数据写入到文件中 
 *
 */
public class TestIO8 {

	public static void main(String[] args) throws IOException {

		//字节流转换为字符流
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		//输出流
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
