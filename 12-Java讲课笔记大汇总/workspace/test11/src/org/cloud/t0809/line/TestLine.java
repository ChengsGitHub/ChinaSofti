package org.cloud.t0809.line;

import java.util.Scanner;

public class TestLine{
    public static void main(String[] args) {
    	
        Scanner sc=new Scanner(System.in);
        System.out.println("�������һ��������꣺");
        
        Point a=new Point(sc.nextInt(), sc.nextInt());
        System.out.println("������ڶ���������꣺");
        
        Point b=new Point(sc.nextInt(), sc.nextInt());
        Line l=new Line(a, b);
        
        System.out.println("�߶εĳ����ǣ�"+l.getLength());
    }
}