package chapter8;

import java.io.IOException;

/**
 * �ֶ������쳣 
 */
public class TestException8 {

	public static void main(String[] args)  {
						
		try {
			throw new IOException("������IO�쳣������");
		} catch (IOException e) {
			System.out.println("�����쳣��" + e.getMessage());
		}
		
	}

}