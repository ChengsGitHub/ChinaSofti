import java.util.Scanner;

/**
 * ��̬��ֵ- ���ܺ� ƽ��ֵ - ����߳ɼ����ǵ�һ���� 
 * @author Administrator
 *
 */
public class TestArray4 {
	public static void main(String[] args) {
		double sum = 0;
		double max = 0;
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		//ѧ���ɼ�
		double [] a = new double[5];
		//��̬��ֵ
		System.out.println("������ɼ�");
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextDouble();
			sum += a[i];
			if(max < a[i]){
				max = a[i];
				temp = i;
			}
			
		}
		
		System.out.println(sum / 5);
		System.out.println(max + "," + (temp + 1));
	}
}
