package chapter9;

/**
 * һ���򵥵ļ�����
 * @author Administrator
 */
public class MyMath {

	public int chufa(int a,int b) {
		try {
			int c = a / b;
			return c;
		} catch (Exception e) {
			return 0;
		}		
	}
	
	public int chengfa(int a,int b) {
		int c = a * b;
		return c;
	}
	
}