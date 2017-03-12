package chapter10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestRuntime {
	
	public static void main(String[] args) throws IOException {
		
		//��������� 
		Runtime runtime = Runtime.getRuntime();
		
		//��ǰ���г���Ľ��̶���
		Process p = runtime.exec("cmd /c ping 192.168.2.1");
		
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);		
		BufferedReader br = new BufferedReader(isr);
		
		String s = br.readLine();
		
		while (s != null) {
			System.out.println(s);
			s = br.readLine();
		}
		
		br.close();
	}

}