package chapter11;

public class TestReplace {

	public static void main(String[] args) {
		
		String s = "abcdefgabcdefgabcd";
		
		System.out.println(s.replace("cd", "*"));
		
		String s2 = "�й�<a>1111</a>���<a>222</a>����<a>33</a>hello,world";
		
		//�������ʾʽģ��ƥ��
		System.out.println(s2.replaceAll("<a>\\d{2,4}</a>", "����г��"));

	}

}