package chapter11;

/**
 * StringBuffer�ǿɱ��ַ��� 
 */
public class TestStringBuffer {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();//��ʼʱ��
		
		StringBuffer sb = new StringBuffer();//���ַ�������
		
		//10000��ƴ���ַ���
		for (int i = 1;i <= 10000;i ++) {
			sb.append(i);
			sb.append('\n');
		}

		long end = System.currentTimeMillis();//����ʱ��
		
		System.out.println(sb);
		
		System.out.println("�ķѵ�ʱ�䣺" + (end-start) );
	}

}