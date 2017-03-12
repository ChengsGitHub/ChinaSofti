
public class TestArray1 {
	//int i;
	public static void main(String[] args) {
		// 1 声明数组
		int [] a;
		// 2 创建数组
		a = new int[4];
		// 3 赋值
		a[0] = 100;
		a[1] = 101;
		a[2] = 102;
		a[3] = 103;
		// 4 遍历
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		System.out.println("-----------------");
		for (int temp : a) {
			System.out.println(temp);
		}
	}

}
