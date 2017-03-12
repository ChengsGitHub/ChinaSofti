package chapter12;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties操作属性集 
 *
 */
public class TestProperties {

	public static void main(String[] args) throws IOException {

		//通过反射得到文件数据流
		InputStream is = TestProperties.class.getResourceAsStream("/chapter12/config.ini");

		//属性集对象
		Properties p = new Properties();

		//加载文件内容
		p.load(is);

		//通过键返回值
		String s = p.getProperty("username");
		System.out.println(s);

		is.close();
		
	}

}