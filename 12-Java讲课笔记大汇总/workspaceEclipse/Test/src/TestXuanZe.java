import java.util.Arrays;


/**
 * 选择排序 
 */
public class TestXuanZe {

	public static void main(String[] args) {
		
		int[] a = {14,54,36,47,98,21};
		
		for (int i = 0;i < a.length;i ++) {
			
			int min = i;//每次找出剩余的元素的最小值的那个下标
			
			for (int j = i + 1;j < a.length;j ++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			
			//把最小下标的元素和a[i]交换
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;			
		}
		
		System.out.println(Arrays.toString(a));

	}

}