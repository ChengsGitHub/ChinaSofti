package org.cloud.t0809.line;

import java.util.Scanner;

public class TestLine{
    public static void main(String[] args) {
    	
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入第一个点的坐标：");
        
        Point a=new Point(sc.nextInt(), sc.nextInt());
        System.out.println("请输入第二个点的坐标：");
        
        Point b=new Point(sc.nextInt(), sc.nextInt());
        Line l=new Line(a, b);
        
        System.out.println("线段的长度是："+l.getLength());
    }
}