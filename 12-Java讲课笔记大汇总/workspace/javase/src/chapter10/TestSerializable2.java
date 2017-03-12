package chapter10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 反序列化
 */
public class TestSerializable2 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		//文件流
		FileInputStream fis = new FileInputStream("f:\\obj.abc");

		// 序列化流
		ObjectInputStream ois = new ObjectInputStream(fis);

		//从流中读取出对象 
		Student stu = (Student) ois.readObject();
		
		System.out.println(stu.getId() + "," + stu.getName());

		ois.close();
	}

}