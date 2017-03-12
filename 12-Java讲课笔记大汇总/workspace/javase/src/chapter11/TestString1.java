package chapter11;

/**
 * String�ĳ���API 
 *
 */
public class TestString1 {

	public static void main(String[] args) {
						
		String s = "abcdefg";
		
		System.out.println(s.length());//7 �ַ�������
		System.out.println(s.charAt(3));//d ָ���±���ַ�
		System.out.println(s.substring(3));//defg  ��ȡ�ַ������Ӵ�
		System.out.println(s.substring(3,5));//de
		
		s = "abcdefgabcd";
		
		System.out.println(s.indexOf("cd"));//2  �����ַ������±� ���������ң��Ե�һ��Ϊ׼
		System.out.println(s.indexOf("cdf"));//�Ҳ�������-1
		System.out.println(s.lastIndexOf("cd"));//9  ������������ң��Ե�һ��Ϊ׼

		System.out.println("ABcd".toUpperCase());//��д
		System.out.println("ABcd".toLowerCase());//Сд
		
		System.out.println("abcd".startsWith("ab"));//�Ƿ���XX��ʼ true
		System.out.println("abcd".endsWith("cd"));//�Ƿ���XX����  true
		
		System.out.println("abcd".equalsIgnoreCase("ABCD"));//true ���Դ�Сд�Ƚ�
		
		System.out.println("123" + "    abcd    ".trim() + "456");
		
	}

}