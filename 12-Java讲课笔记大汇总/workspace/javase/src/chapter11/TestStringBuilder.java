package chapter11;

/**
 * StringBuilderҲ�ǿɱ��ַ������̲߳���ȫ�ģ� 
 */
public class TestStringBuilder {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder("abc");
		
		sb.append("xyz");//ƴ��
		
		sb.insert(2, "ABC");//����
		
		sb.reverse();//��ת
		
		System.out.println(sb);		
		
	}

}