package chapter6.encryptnum;

public class EncryptMyNumber extends MyNumber {

	/**
	 * ÿλ���ֶ�����5,Ȼ���úͳ���10��������������֣��ٽ���һλ�͵���λ�������ڶ�λ�͵���λ����
	 */
	public int getEncryptNum() {
		
		if (num == 0)
			return 0;

		int a, b, c, d;
		a = num / 1000;// ��һλ
		b = num / 100 % 10;// �ڶ�λ
		c = num % 100 / 10;// ����λ
		d = num % 10;// ����λ
		
		a = (a + 5) % 10;
		b = (b + 5) % 10;
		c = (c + 5) % 10;
		d = (d + 5) % 10;

		num = d * 1000 + c * 100 + b * 10 + a;

		return num;
	}

}
