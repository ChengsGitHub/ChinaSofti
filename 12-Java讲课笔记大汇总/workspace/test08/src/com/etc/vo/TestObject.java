package com.etc.vo;

import java.util.Calendar;
import java.util.Date;


public class TestObject {

	public static void main(String[] args) {
		Student stu01;	//declare var
		//Date bir, String name, double score, boolean sex, String sno
		stu01=new Student(null,"уер╟",5000,true,"110608");
		System.out.println(stu01.getSno()+"\t"+stu01.getName());
		
		//stu01.score=5000;
		//stu01.setScore(500);
		System.out.println(stu01.getScore());
		
		//stu01.print();
		int i=100;
		System.out.println(i);
		
		Student s=new Student(null,"уер╟",5000,true,"110608");
		System.out.println(s);
		//s.print();
		
		//Date d=new Date();
		/*Calendar c=Calendar.getInstance();
		c.set(2014,7,5);
		System.out.println(c.get(Calendar.DAY_OF_WEEK));*/
	}

}
