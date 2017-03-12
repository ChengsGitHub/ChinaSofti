package chapter10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 序列化
 */
public class TestSerializable1 {

	public static void main(String[] args) throws IOException {

		Student stu = new Student(10457, "张三");

		//文件流
		FileOutputStream fos = new FileOutputStream("f:\\obj.abc");

		// 序列化流
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		//写入对象到流中
		oos.writeObject(stu);

		oos.close();
	}

}