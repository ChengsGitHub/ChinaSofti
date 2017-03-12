package chapter11;

public class TestReplace {

	public static void main(String[] args) {
		
		String s = "abcdefgabcdefgabcd";
		
		System.out.println(s.replace("cd", "*"));
		
		String s2 = "中国<a>1111</a>你好<a>222</a>世界<a>33</a>hello,world";
		
		//用正则表示式模糊匹配
		System.out.println(s2.replaceAll("<a>\\d{2,4}</a>", "（和谐）"));

	}

}