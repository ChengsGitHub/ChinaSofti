package chapter10;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * PrintWriter类直接提供了换行输出的方法，比较方便
 *
 */
public class TestIO7 {

	public static void main(String[] args) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter("f:\\9.txt");
		pw.println("中国人民解放军");
		pw.println("abcdefg");
		pw.close();

	}

}