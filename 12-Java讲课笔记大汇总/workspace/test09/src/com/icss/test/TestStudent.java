
package com.icss.test;

public class TestStudent {
	public static void main(String[] args) {
		Student lq = new Student(10,"aa");
		 lq = new Student(10,"aa","Ů",21);
		lq.name = "lily";
		//lq.setAge(21);
		System.out.println(lq.name);
		//String sex = lq.getSex();
		System.out.println(lq.getSex());
	}

}
