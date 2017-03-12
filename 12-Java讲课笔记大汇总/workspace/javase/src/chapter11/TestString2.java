package chapter11;

public class TestString2 {

	public static void main(String[] args) {

		System.out.println(getLastThree("�й������ž�"));
		System.out.println(getReverse("abcd"));
		System.out.println(getIP("192.168.2.14"));
		System.out.println(checkUsername("a123_tom"));
	}

	// ���������ַ����������ַ����ĺ�3λ ���� abcdefg ���� efg
	public static String getLastThree(String str) {

		if (str.length() < 3)
			return str;

		String s = str.substring(str.length() - 3);

		return s;
	}

	// ��д�ַ��� ���� abcdefg ���� gfedcba
	public static String getReverse(String str) {

		String s = "";

		for (int i = str.length() - 1; i >= 0; i--) {

			s = s + str.charAt(i);
		}

		return s;
	}

	// ����һ��IP�����ش������IP������ 202.96.64.123 ���� 202.96.64.*
	public static String getIP(String ip) {
		
		String s = ip.substring(0,ip.lastIndexOf(".")) + ".*";
		return s;
	}

	// ����һ���û������ж��Ƿ�Ϸ���Сд��ĸ��ͷ�����������Сд��ĸ�����֣��»��ߣ�6-12λ��
	public static boolean checkUsername(String username) {
		
		/*
		if (username.length() < 6 || username.length() > 12) {
			System.out.println("λ��������6-12");
			return false;
		}
		
		char c = username.charAt(0);
		
		if (c < 'a' || c > 'z') {
			System.out.println("����Сд��ĸ��ͷ");
			return false;
		}
		
		for (int i = 1;i < username.length();i ++) {
			c = username.charAt(i);
			
			if( (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != '_' ) {
				System.out.println("��" + i + "λ�ַ��Ƿ�");
				return false;
			}
		}

		return true;
		*/
		
		return username.matches("^[a-z][a-z0-9_]{5,11}$");
	}

}