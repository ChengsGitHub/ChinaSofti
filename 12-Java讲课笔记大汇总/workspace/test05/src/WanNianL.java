import java.util.Scanner;

public class WanNianL {
	public static void main(String[] args) {
		String S="Y";
		do{
		int sumDay = 0;
		int count = 0;
		int count1 = 0, count2 = 0;
		int count11=0 ;
		int week;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("*----------------------欢迎使用万年历--------------------*");
		System.out.println("请输入年份（1900以后）：");
		int year = sc.nextInt();
		System.out.println("请输入月份：");
		int month = sc.nextInt();
		for (int i = 1900; i < year; i++) {
			if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
				count++;
			}
		}// for
		sumDay = (year - 1900) * 365 + count;//计算输入年到1900年1月有多少天

		count1 = (month - 1) * 30;//计算   输入月份   到    输入年1月   有多少天
		if (month > 2) {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				count1 = count1 - 1;
			} else {
				count1 = count1 - 2;
			}
		}// if1

		for (int j = 1; j < month; j++) {
			if (j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10
					|| j == 12) {
				count1++;
			}
		}

		count2 = sumDay + count1;
		week = (1 + count2) % 7;//计算星期几？
		//System.out.println(week);
		/*
		 * System.out.println(count); System.out.println(count2);
		 * System.out.println(count1); System.out.println(sumDay);
		 */
        System.out.println("-------------------------------------------------------");
		System.out.println("星期日"+"\t"+"星期一" + "\t" + "星期二" + "\t" + "星期三" + "\t" + "星期四"
				+ "\t" + "星期五" + "\t" + "星期六");
		
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: {
			for (int k = 1; k <= week; k++) {
				System.out.print("\t");
				count11++;
			}
			for (int q = 1; q <= 31; q++) {
				System.out.print(q + "\t");
				count11++;
				if (count11 % 7 == 0)
					System.out.println();
			}
			break;
		}
		case 4:
		case 6:
		case 9:
		case 11: {
			for (int k = 1; k <= week; k++) {
				System.out.print("\t");
				count11++;
			}
			for (int q = 1; q <= 30; q++) {
				System.out.print(q + "\t");
				count11++;
				if (count11 % 7 == 0)
					System.out.println();
			}
			break;
		}
		case 2: {
			if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
				for (int k = 1; k <=week; k++) {
					System.out.print("\t");
					count11++;
				}
				for (int q = 1; q <= 29; q++) {
					System.out.print(q + "\t");
					count11++;
					if (count11 % 7 == 0)
						System.out.println();
				}
				break;
			} else {
				for (int k = 1; k <=week; k++) {
					System.out.print("\t");
					count11++;
				}
				for (int q = 1; q <= 28; q++) {
					System.out.print(q + "\t");
					count11++;
					if (count11 % 7 == 0)
						System.out.println();
				}
				break;
			}
		}

		}// switch
		
		System.out.println();
		System.out.println("----------------继续---Y|y   退出-----N|n--------------");
		
		S=sc.next();
		
		}while(S.equals("Y")||S.equals("y"));//do-while结束
		
		System.out.println("----------------感谢使用万年历！！！！！-----------------");
		
		
		
		
	}
}
