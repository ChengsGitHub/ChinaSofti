package chapter8;

import java.io.IOException;

public class TestException6 {

	public static void main(String[] args) throws IOException {
		m1();
	}
	
	public static void m1() throws IOException  {
		int i = System.in.read();
		System.out.println("i=" + i);
	}
	
}