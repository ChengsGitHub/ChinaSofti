package chapter10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * BufferedReader×Ö·ûÊäÈë»º³åÁ÷ 
 */
public class TestIO5 {

	public static void main(String[] args) throws IOException {
		
		FileReader fr = new FileReader("f:\\5.txt");		
		BufferedReader br = new BufferedReader(fr);
		
		String s = br.readLine();	
		
		while (s != null) {
			System.out.println(s);
			s = br.readLine();
		}	
		
		br.close();
		//fr.close();
	}

}