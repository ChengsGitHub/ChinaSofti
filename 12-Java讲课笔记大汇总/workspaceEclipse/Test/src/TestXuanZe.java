import java.util.Arrays;


/**
 * ѡ������ 
 */
public class TestXuanZe {

	public static void main(String[] args) {
		
		int[] a = {14,54,36,47,98,21};
		
		for (int i = 0;i < a.length;i ++) {
			
			int min = i;//ÿ���ҳ�ʣ���Ԫ�ص���Сֵ���Ǹ��±�
			
			for (int j = i + 1;j < a.length;j ++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			
			//����С�±��Ԫ�غ�a[i]����
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;			
		}
		
		System.out.println(Arrays.toString(a));

	}

}