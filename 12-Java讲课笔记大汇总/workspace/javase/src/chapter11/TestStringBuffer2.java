package chapter11;

/**
 * StringBuffer�ǿɱ��ַ������̰߳�ȫ�ģ� 
 */
public class TestStringBuffer2 {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer("abc");
		
		sb.append("xyz");//ƴ��
		
		sb.insert(2, "ABC");//����
		
		sb.reverse();//��ת
		
		System.out.println(sb);		
		
	}

}