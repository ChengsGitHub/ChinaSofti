package chapter12;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class ReadCityCode {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("������������ƣ�");
			String cityName = sc.next();
			String cityCode = getCityCode(cityName);
			if (cityCode == null)
				System.out.println("���в�����");
			else
				System.out.println("���д����ǣ�" + cityCode);
		}
	}

	/**
	 * ��ȡCityCode.properties�ļ����õ���Ӧ���еĴ���
	 * 
	 * @throws IOException
	 */
	public static String getCityCode(String cityName) throws IOException {

		InputStream is = ReadCityCode.class.getResourceAsStream("CityCode.properties");

		Properties p = new Properties();

		// �����ļ�����
		p.load(is);

		// ͨ��������ֵ
		String cityCode = p.getProperty(cityName);
		
		return cityCode;

	}

}