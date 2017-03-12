package chapter10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * BufferedWriter字符输出缓冲流 
 *
 */
public class TestIO6 {

	public static void main(String[] args) throws IOException {
		
		FileWriter fw = new FileWriter("f:\\6.txt",true);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("中国人民解放军");
		bw.newLine();//根据操作系统加换行符
		bw.write("abcdefg");
		bw.newLine();
				
		bw.close();
		
	}

}