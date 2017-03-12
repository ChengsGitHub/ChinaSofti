import java.util.Scanner;

/**
 * 动态赋值- 求总和 平均值 - 求最高成绩，是第一个人 
 * @author Administrator
 *
 */
public class TestArray4 {
	public static void main(String[] args) {
		double sum = 0;
		double max = 0;
		int temp = 0;
		Scanner sc = new Scanner(System.in);
		//学生成绩
		double [] a = new double[5];
		//动态赋值
		System.out.println("请输入成绩");
		
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
