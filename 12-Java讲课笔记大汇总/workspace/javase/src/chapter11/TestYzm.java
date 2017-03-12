package chapter11;

public class TestYzm {

	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {

			System.out.println("随机验证码：\t" + getYzm());
		}

	}

	// 获取4位随机的字母数字组合的验证码

	public static String getYzm() {

		char[] list = new char[36];

		String result = "";

		//大写字母
		for (int i = 0; i < 26; i++) {
			list[i] = (char) (i + 65);
		}
		
		//数字
		for (int i = 26; i < 36; i++) {
			list[i] = (char) (i + 22);
		}

		for (int i = 0; i < 4; i++) {
			//随机下标
			int num = (int) ((35 - 0 + 1) * Math.random() + 0);
			result += list[num];
		}

		return result;

	}
}
