package chapter12;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties�������Լ� 
 *
 */
public class TestProperties {

	public static void main(String[] args) throws IOException {

		//ͨ������õ��ļ�������
		InputStream is = TestProperties.class.getResourceAsStream("/chapter12/config.ini");

		//���Լ�����
		Properties p = new Properties();

		//�����ļ�����
		p.load(is);

		//ͨ��������ֵ
		String s = p.getProperty("username");
		System.out.println(s);

		is.close();
		
	}

}