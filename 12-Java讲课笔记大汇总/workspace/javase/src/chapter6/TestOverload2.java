package chapter6;

/**
 * �ɱ䳤���������Խ�����������Ĳ��� ������Ϊ��һ����������ط���
 * 
 * @author Administrator
 * 
 */
public class TestOverload2 {

	/**
	 * ������������� ������ӵĽ��	 
	 */
	public int sum(int... a) {

		int sumResult = 0;

		for (int i = 0; i < a.length; i++) {
			sumResult += a[i];
		}

		return sumResult;
	}

	public static void main(String[] args) {

		TestOverload2 t = new TestOverload2();
		int result = t.sum(5, 4, 3, 2, 1, 7, 8, 9, 10);
		System.out.println("�ܺͣ�" + result);
		
	}

}