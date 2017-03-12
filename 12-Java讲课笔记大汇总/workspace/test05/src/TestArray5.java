import java.util.Arrays;
import java.util.Scanner;

/**
 * √∞≈›≈≈–Ú
 * @author Administrator
 *
 */
public class TestArray5 {
	public static void main(String[] args) {
		int [] a = new int[4];
		Scanner sc = new Scanner(System.in);
		System.out.println("«Î ‰»Î");
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		//≈≈–Ú
//		for (int i = 1; i < a.length ; i++) {
//			for (int j = 0; j < a.length - i; j++) {
//				if(a[j] > a[j + 1]){
//					int temp = a[j];
//					a[j] = a[j + 1];
//					a[j + 1] = temp;
//				}
//			}
//			
//		}
		Arrays.sort(a);
		for (int i : a) {
			System.out.println(i);
		}
		
	}

}
