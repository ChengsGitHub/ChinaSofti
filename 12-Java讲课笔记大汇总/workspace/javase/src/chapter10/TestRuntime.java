package chapter10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TestRuntime {
	
	public static void main(String[] args) throws IOException {
		
		//虚拟机对象 
		Runtime runtime = Runtime.getRuntime();
		
		//当前运行程序的进程对象
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