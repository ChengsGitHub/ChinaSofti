package chapter11;

public class TestString2 {

	public static void main(String[] args) {

		System.out.println(getLastThree("中国人民解放军"));
		System.out.println(getReverse("abcd"));
		System.out.println(getIP("192.168.2.14"));
		System.out.println(checkUsername("a123_tom"));
	}

	// 传入任意字符串，返回字符串的后3位 例如 abcdefg 返回 efg
	public static String getLastThree(String str) {

		if (str.length() < 3)
			return str;

		String s = str.substring(str.length() - 3);

		return s;
	}

	// 倒写字符串 例如 abcdefg 返回 gfedcba
	public static String getReverse(String str) {

		String s = "";

		for (int i = str.length() - 1; i >= 0; i--) {

			s = s + str.charAt(i);
		}

		return s;
	}

	// 传入一个IP，返回处理过的IP，例如 202.96.64.123 返回 202.96.64.*
	public static String getIP(String ip) {
		
		String s = ip.substring(0,ip.lastIndexOf(".")) + ".*";
		return s;
	}

	// 传入一个用户名，判断是否合法（小写字母开头，后面可以是小写字母，数字，下划线，6-12位）
	public static boolean checkUsername(String username) {
		
		/*
		if (username.length() < 6 || username.length() > 12) {
			System.out.println("位数必须是6-12");
			return false;
		}
		
		char c = username.charAt(0);
		
		if (c < 'a' || c > 'z') {
			System.out.println("必须小写字母开头");
			return false;
		}
		
		for (int i = 1;i < username.length();i ++) {
			c = username.charAt(i);
			
			if( (c < 'a' || c > 'z') && (c < '0' || c > '9') && c != '_' ) {
				System.out.println("第" + i + "位字符非法");
				return false;
			}
		}

		return true;
		*/
		
		return username.matches("^[a-z][a-z0-9_]{5,11}$");
	}

}