package chapter10;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ShowDir {
	public static void main(String[] args) {
		SimpleDateFormat s=new SimpleDateFormat("yyyy-MM-dd hh:mm");
		String sdir;
		Scanner scd=new Scanner(System.in);
		
		String sd="c\\Users\\";
		
		while(true){
			System.out.println("������·��(����X:\\\\XXX\\\\XXX�ĸ�ʽ����)��");
			System.out.print(sd+">");
			sdir=scd.next();
			File dir=new File(sdir);
			if (dir.exists()==false) {
				System.out.println("��·��������,����������");
			}else {
				if (dir.isFile()==true) {
					Date d1=new Date(dir.lastModified());
					String s1=s.format(d1);
					System.out.println("����޸�ʱ�� \t\t\t\t�ļ�/Ŀ¼\t\t��С\t\t\t����");
					System.out.println(s1+"\t\t\t"+"�ļ�\t\t"+dir.length()+"\t\t\t"+dir.getName());
				}else {
					System.out.println("\t\t");
					Date d2;
					String s2;
					int numD=0,numF=0;
					
					System.out.println("����޸�ʱ�� \t\t\t\t�ļ�/Ŀ¼\t\t��С\t\t\t����");
					String[] names=dir.list();
					File[] df=dir.listFiles();
					for (int i = 0; i < df.length; i++) {
						if (df[i].isFile()==true) {
							d2=new Date(df[i].lastModified());
							s2=s.format(d2);
							System.out.println(s2+"\t\t\t"+"�ļ�\t\t"+df[i].length()+"\t\t\t"+df[i].getName());
							numF++;
						}else {
							d2=new Date(df[i].lastModified());
							s2=s.format(d2);
							System.out.println(s2+"\t\t\t"+"Ŀ¼\t\t"+"."+"\t\t\t"+df[i].getName());
							numD++;
						}
					}
					System.out.println("\t\t\t"+numF+"���ļ�");
					System.out.println("\t\t\t"+numD+"��Ŀ¼\n");
					
				}

			}
			
		}

		
		
	}
}
