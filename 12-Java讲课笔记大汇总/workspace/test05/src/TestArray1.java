
public class TestArray1 {
	//int i;
	public static void main(String[] args) {
		// 1 ��������
		int [] a;
		// 2 ��������
		a = new int[4];
		// 3 ��ֵ
		a[0] = 100;
		a[1] = 101;
		a[2] = 102;
		a[3] = 103;
		// 4 ����
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("-----------------");
		for (int temp : a) {
			System.out.println(temp);
		}
	}

}
