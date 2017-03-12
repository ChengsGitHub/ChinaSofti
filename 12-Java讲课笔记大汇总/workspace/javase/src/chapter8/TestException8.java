package chapter8;

import java.io.IOException;

/**
 * 手动产生异常 
 */
public class TestException8 {

	public static void main(String[] args)  {
						
		try {
			throw new IOException("发生了IO异常啦啦啦");
		} catch (IOException e) {
			System.out.println("发生异常：" + e.getMessage());
		}
		
	}

}