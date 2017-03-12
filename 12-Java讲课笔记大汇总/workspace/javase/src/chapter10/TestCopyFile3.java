package chapter10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TestCopyFile3 {

	public static void main(String[] args) throws Exception {

		// 输入流
		FileReader fr = new FileReader("f:\\7.txt");
		BufferedReader br = new BufferedReader(fr);

		// 输出流
		FileWriter fw = new FileWriter("f:\\8.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);

		String s = br.readLine();

		int i = 1;// 行号

		while (s != null) {

			if (i < 10) {
				bw.write("000" + i + "\t");
			} else if (i < 100) {
				bw.write("00" + i + "\t");
			} else if (i < 1000) {
				bw.write("0" + i + "\t");
			} else {
				bw.write(i + "\t");
			}

			bw.write(s);
			bw.newLine();

			i ++;//行号递增

			s = br.readLine();
		}
		
		bw.close();
		br.close();

	}

}
