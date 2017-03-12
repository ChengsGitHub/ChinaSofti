package chapter12;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

public class ReadCityCode {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("请输入城市名称：");
			String cityName = sc.next();
			String cityCode = getCityCode(cityName);
			if (cityCode == null)
				System.out.println("城市不存在");
			else
				System.out.println("城市代码是：" + cityCode);
		}
	}

	/**
	 * 读取CityCode.properties文件，得到对应城市的代码
	 * 
	 * @throws IOException
	 */
	public static String getCityCode(String cityName) throws IOException {

		InputStream is = ReadCityCode.class.getResourceAsStream("CityCode.properties");

		Properties p = new Properties();

		// 加载文件内容
		p.load(is);

		// 通过键返回值
		String cityCode = p.getProperty(cityName);
		
		return cityCode;

	}

}