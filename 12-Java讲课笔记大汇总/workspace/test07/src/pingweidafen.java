package zuoye;

import java.util.Scanner;

public class pingweidafen {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []a;
		a=new int[5];
		Scanner sc=new Scanner(System.in);
		System.out.println("请评委打分:");
		int i,b,n=0,max,min,count1=0,count2=0,sum=0;
		double aver=0;
		for(i=0;i<5;i++){
			b=sc.nextInt();
			a[i]=b;
			
			if(a[i]!=0){sum=sum+a[i];}
			else {n=1;}
			}
		if(n==1){System.out.println("对不起您被淘汰了");sum=0;}
		
		max=a[0];min=a[0];
		for(i=1;i<5;i++){
			if(a[i]>max){max=a[i];count1=i;}
			else if(a[i]<min&&a[i]!=0){min=a[i];count2=i;}
		}
		if(sum!=0){aver=(sum-max-min)/(a.length-2);}
		if(sum==0){aver=0;}
		
		System.out.println("最高分"+max+"下标"+count1);
		System.out.println("最低分"+min+"下标"+count2);
		System.out.println("参赛成绩"+aver);
			
		}

	}


