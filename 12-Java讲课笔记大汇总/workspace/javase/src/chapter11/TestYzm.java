package chapter11;

public class TestYzm {

	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {

			System.out.println("�����֤�룺\t" + getYzm());
		}

	}

	// ��ȡ4λ�������ĸ������ϵ���֤��

	public static String getYzm() {

		char[] list = new char[36];

		String result = "";

		//��д��ĸ
		for (int i = 0; i < 26; i++) {
			list[i] = (char) (i + 65);
		}
		
		//����
		for (int i = 26; i < 36; i++) {
			list[i] = (char) (i + 22);
		}

		for (int i = 0; i < 4; i++) {
			//����±�
			int num = (int) ((35 - 0 + 1) * Math.random() + 0);
			result += list[num];
		}

		return result;

	}
}
