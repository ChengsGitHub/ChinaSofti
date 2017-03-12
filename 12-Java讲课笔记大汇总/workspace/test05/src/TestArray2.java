import java.util.Scanner;

/**
 * 定义一个字符串数组 含有四个元素 ： 苹果 香蕉 桃子 柚子
 * 遍历
 * 从控制台接收一种 判断是否存在 ： 查找
 * @author Administrator
 *
 */
public class TestArray2 {
	public static void main(String[] args) {
		 String [] a = new String [4];
		 a[0] = "香蕉";
		 a[1] = "桃子";
		 a[2] = "苹果";
		 a[3] = "柚子";
		 Scanner sc = new Scanner(System.in);
		 //System.out.println("请输入");
		 String b = sc.nextLine();
		 System.out.println(b);
		
		 boolean flag = true;
		 for (int i = 0; i < a.length; i++) {
			if(b.equals(a[i])){
				System.out.println("have");
				flag = false;
				break;
			}
		}
		 if(flag){
			 System.out.println("no");
		 }

	}

}
