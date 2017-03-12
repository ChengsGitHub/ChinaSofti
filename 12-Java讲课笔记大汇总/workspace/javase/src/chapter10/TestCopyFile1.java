package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 复制文件（玩具程序，不推荐）
 * @author Administrator
 *
 */
public class TestCopyFile1 {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("f:\\1.exe");
		FileOutputStream fos = new FileOutputStream("f:\\2.exe");
		
		int i = fis.read();
		
		while (i != - 1) {
			fos.write(i);
			i = fis.read();
		}

		fos.close();
		fis.close();
	}

}