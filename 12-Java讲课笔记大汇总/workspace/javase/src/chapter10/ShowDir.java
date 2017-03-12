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
			System.out.println("请输入路径(请以X:\\\\XXX\\\\XXX的格式输入)：");
			System.out.print(sd+">");
			sdir=scd.next();
			File dir=new File(sdir);
			if (dir.exists()==false) {
				System.out.println("该路径不存在,请重新输入");
			}else {
				if (dir.isFile()==true) {
					Date d1=new Date(dir.lastModified());
					String s1=s.format(d1);
					System.out.println("最后修改时间 \t\t\t\t文件/目录\t\t大小\t\t\t名称");
					System.out.println(s1+"\t\t\t"+"文件\t\t"+dir.length()+"\t\t\t"+dir.getName());
				}else {
					System.out.println("\t\t");
					Date d2;
					String s2;
					int numD=0,numF=0;
					
					System.out.println("最后修改时间 \t\t\t\t文件/目录\t\t大小\t\t\t名称");
					String[] names=dir.list();
					File[] df=dir.listFiles();
					for (int i = 0; i < df.length; i++) {
						if (df[i].isFile()==true) {
							d2=new Date(df[i].lastModified());
							s2=s.format(d2);
							System.out.println(s2+"\t\t\t"+"文件\t\t"+df[i].length()+"\t\t\t"+df[i].getName());
							numF++;
						}else {
							d2=new Date(df[i].lastModified());
							s2=s.format(d2);
							System.out.println(s2+"\t\t\t"+"目录\t\t"+"."+"\t\t\t"+df[i].getName());
							numD++;
						}
					}
					System.out.println("\t\t\t"+numF+"个文件");
					System.out.println("\t\t\t"+numD+"个目录\n");
					
				}

			}
			
		}

		
		
	}
}
