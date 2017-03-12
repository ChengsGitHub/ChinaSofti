package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * �����л�
 */
public class TestSerializable2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		//�ļ���
		FileInputStream fis = new FileInputStream("f:\\obj.abc");

		// ���л���
		ObjectInputStream ois = new ObjectInputStream(fis);

		//�����ж�ȡ������ 
		Student stu = (Student) ois.readObject();
		
		System.out.println(stu.getId() + "," + stu.getName());

		ois.close();
	}

}