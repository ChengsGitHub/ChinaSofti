package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * �����ļ���Ч�ʸߣ��Ƽ��� 
 * 
 */
public class TestCopyFile2 {

	public static void main(String[] args) throws Exception {

		FileInputStream fis = new FileInputStream("f:\\1.exe");
		FileOutputStream fos = new FileOutputStream("f:\\2.exe");

		byte[] b = new byte[1024 * 8];//���ֽ�������������

		int length = fis.read(b);//��ȡ���ݵ������У�����ʵ�ʶ�ȡ�ĳ���length
		
		while (length != -1) {
			fos.write(b,0,length);//����ʵ�ʶ�ȡ����д�������ǰNλ
			length = fis.read(b);
		}
		
		fos.close();
		fis.close();
	}

}