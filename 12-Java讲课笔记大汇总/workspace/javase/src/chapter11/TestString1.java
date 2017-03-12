package chapter11;

/**
 * String的常用API 
 *
 */
public class TestString1 {

	public static void main(String[] args) {
						
		String s = "abcdefg";
		
		System.out.println(s.length());//7 字符串长度
		System.out.println(s.charAt(3));//d 指定下标的字符
		System.out.println(s.substring(3));//defg  截取字符串的子串
		System.out.println(s.substring(3,5));//de
		
		s = "abcdefgabcd";
		
		System.out.println(s.indexOf("cd"));//2  查找字符串的下标 从左向右找，以第一个为准
		System.out.println(s.indexOf("cdf"));//找不到返回-1
		System.out.println(s.lastIndexOf("cd"));//9  方向从右向左找，以第一个为准

		System.out.println("ABcd".toUpperCase());//大写
		System.out.println("ABcd".toLowerCase());//小写
		
		System.out.println("abcd".startsWith("ab"));//是否以XX开始 true
		System.out.println("abcd".endsWith("cd"));//是否以XX结束  true
		
		System.out.println("abcd".equalsIgnoreCase("ABCD"));//true 忽略大小写比较
		
		System.out.println("123" + "    abcd    ".trim() + "456");
		
	}

}