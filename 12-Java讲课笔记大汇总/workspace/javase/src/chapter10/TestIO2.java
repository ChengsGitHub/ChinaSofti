package chapter10;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件字节输出流FileOutputStream 
 */
public class TestIO2 {

	public static void main(String[] args) throws IOException {
		
		//true表示追加写入文件，文件以前的内容不丢失，默认是false覆盖写入
		FileOutputStream fos = new FileOutputStream("2.txt",true);
		
		fos.write('a');
		fos.write(98);
		fos.write('c');
		fos.write('\r');
		fos.write('\n');
		
		fos.close();
	
	}

}