package chapter10;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * �ļ��ֽ������FileOutputStream 
 */
public class TestIO2 {

	public static void main(String[] args) throws IOException {
		
		//true��ʾ׷��д���ļ����ļ���ǰ�����ݲ���ʧ��Ĭ����false����д��
		FileOutputStream fos = new FileOutputStream("2.txt",true);
		
		fos.write('a');
		fos.write(98);
		fos.write('c');
		fos.write('\r');
		fos.write('\n');
		
		fos.close();
	
	}

}