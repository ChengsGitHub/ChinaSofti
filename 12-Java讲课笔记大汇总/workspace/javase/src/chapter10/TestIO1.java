package chapter10;

import java.io.FileInputStream;

/**
 * 文件字节输入流FileInputStream 
 */
public class TestIO1 {

	public static void main(String[] args) throws Exception {
			
		FileInputStream fis = new FileInputStream("f:\\1.txt");
		
		int i = fis.read();

		while (i != -1) {
			System.out.print((char)i);
			i = fis.read();
		}
		
		fis.close();//关闭流，释放内存
				
	}

}