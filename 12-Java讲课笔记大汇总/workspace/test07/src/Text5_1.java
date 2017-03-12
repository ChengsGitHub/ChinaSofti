

import java.util.Scanner;

public class Text5_1 {
	public static void main(String[] args) {
		System.out.println("***********欢迎光临双色球彩票系统\t票价2元**********");
		
		Scanner sc = new Scanner(System.in);
		int [] a;
		a= new int [6];
		int [] b;
		b = new int [6];
		int q;
		
		while(true){
		q=(int) ((16 - 1 + 1) * Math.random() + 1);
		for (int i = 0; i < b.length; i++) {
			b[i]=(int) ((33 - 1 + 1) * Math.random() + 1);
		}
		boolean equal=true;
		while(equal){
			equal=false;
 		for (int i = 0; i < b.length; i++) {
			for (int j = i+1; j < b.length; j++) {
				if(b[i]==b[j]){
					b[j]=(int) ((33 - 1 + 1) * Math.random() + 1);
					equal=true;
				}
			}
		}
 		}
 		System.out.println(q+"\t\t "+b[0]+" "+b[1]+" "+b[2]+" "+b[3]+" "+b[4]+" "+b[5]);
		int p;
		String n="";
		
		do{
			System.out.println(">>请输入双色球号码");
			System.out.println(">>请输入蓝色球号码(16选1)");
			p= sc.nextInt();
			System.out.println(">>请输入红色球号码(33选6，无重复)");
			
			for (int i = 0; i < a.length; i++) {
				a[i]=sc.nextInt();
			}
			System.out.println("----------顾客：您选择的号码如下----------");
			System.out.print("蓝色球为:"+p+"\t红色球为:");
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]+"   ");
			}
			System.out.println("是否确定(y/n)");
			n=sc.next();
		}while(n.equals("n"));
		
		
		int y=0;
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if(a[i]==b[j]){
					y++;
					break;
				}
			}
		}
		
		System.out.println("----------本注双色球号码为----------");
		System.out.print("蓝色球为:"+q+"\t红色球为:");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+"   ");
		}
		if(p==q){
			if(y==6){
				System.out.println("一等奖 500万");
			}else if(y==5){
				System.out.println("三等奖 3000元");
			}else if(y==4){
				System.out.println("四等奖 200元");
			}else if(y==3){
				System.out.println("五等奖 10元");
			}else{
				System.out.println("安慰奖 5元");
			}
		}else{
			if(y==6){
				System.out.println("二等奖 20万");
			}else if(y==5){
				System.out.println("四等奖 200元");
			}else if(y==4){
				System.out.println("五等奖 10元");
			}else{
				System.out.println("谢谢您的参与，祝您下次中奖");
			}
		}
		}
	}
}
