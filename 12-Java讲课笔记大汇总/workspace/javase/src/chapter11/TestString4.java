package chapter11;

public class TestString4 {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();//��ʼʱ��
		
		String s = "";
		
		for (int i = 1;i <= 10000;i ++) {
			s += i;
			s += '\n';
		}
		
		long end = System.currentTimeMillis();//����ʱ��
		
		System.out.println(s);
		
		System.out.println("�ķѵ�ʱ�䣺" + (end-start) );
	}

}
