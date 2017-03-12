package chapter6.encryptnum;

public class EncryptMyNumber extends MyNumber {

	/**
	 * 每位数字都加上5,然后用和除以10的余数代替该数字，再将第一位和第四位交换，第二位和第三位交换
	 */
	public int getEncryptNum() {
		
		if (num == 0)
			return 0;

		int a, b, c, d;
		a = num / 1000;// 第一位
		b = num / 100 % 10;// 第二位
		c = num % 100 / 10;// 第三位
		d = num % 10;// 第四位
		
		a = (a + 5) % 10;
		b = (b + 5) % 10;
		c = (c + 5) % 10;
		d = (d + 5) % 10;

		num = d * 1000 + c * 100 + b * 10 + a;

		return num;
	}

}
