

import java.util.Scanner;

public class Text5_1 {
	public static void main(String[] args) {
		System.out.println("***********��ӭ����˫ɫ���Ʊϵͳ\tƱ��2Ԫ**********");
		
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
			System.out.println(">>������˫ɫ�����");
			System.out.println(">>��������ɫ�����(16ѡ1)");
			p= sc.nextInt();
			System.out.println(">>�������ɫ�����(33ѡ6�����ظ�)");
			
			for (int i = 0; i < a.length; i++) {
				a[i]=sc.nextInt();
			}
			System.out.println("----------�˿ͣ���ѡ��ĺ�������----------");
			System.out.print("��ɫ��Ϊ:"+p+"\t��ɫ��Ϊ:");
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i]+"   ");
			}
			System.out.println("�Ƿ�ȷ��(y/n)");
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
		
		System.out.println("----------��ע˫ɫ�����Ϊ----------");
		System.out.print("��ɫ��Ϊ:"+q+"\t��ɫ��Ϊ:");
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]+"   ");
		}
		if(p==q){
			if(y==6){
				System.out.println("һ�Ƚ� 500��");
			}else if(y==5){
				System.out.println("���Ƚ� 3000Ԫ");
			}else if(y==4){
				System.out.println("�ĵȽ� 200Ԫ");
			}else if(y==3){
				System.out.println("��Ƚ� 10Ԫ");
			}else{
				System.out.println("��ο�� 5Ԫ");
			}
		}else{
			if(y==6){
				System.out.println("���Ƚ� 20��");
			}else if(y==5){
				System.out.println("�ĵȽ� 200Ԫ");
			}else if(y==4){
				System.out.println("��Ƚ� 10Ԫ");
			}else{
				System.out.println("лл���Ĳ��룬ף���´��н�");
			}
		}
		}
	}
}
