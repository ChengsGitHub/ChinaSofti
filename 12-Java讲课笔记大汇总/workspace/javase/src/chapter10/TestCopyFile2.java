package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 复制文件（效率高，推荐） 
 * 
 */
public class TestCopyFile2 {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("f:\\1.exe");
		FileOutputStream fos = new FileOutputStream("f:\\2.exe");

		byte[] b = new byte[1024 * 8];//用字节数组做缓冲区

		int length = fis.read(b);//读取数据到数组中，返回实际读取的长度length
		
		while (length != -1) {
			fos.write(b,0,length);//按照实际读取长度写入数组的前N位
			length = fis.read(b);
		}
		
		fos.close();
		fis.close();
	}

}