package chapter10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * ���л�
 */
public class TestSerializable1 {

	public static void main(String[] args) throws IOException {

		Student stu = new Student(10457, "����");

		//�ļ���
		FileOutputStream fos = new FileOutputStream("f:\\obj.abc");

		// ���л���
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		//д���������
		oos.writeObject(stu);

		oos.close();
	}

}