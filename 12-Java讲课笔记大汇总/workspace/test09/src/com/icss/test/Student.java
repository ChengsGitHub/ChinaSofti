package com.icss.test;

public class Student {
	public int id;
	public String name;
	public String sex = "Ů";
	public int age;
	
//	public Student(){
//		
//	}
	
//	public Student(int id, String name) {
//		super();
//		this.id = id;
//		this.name = name;
//	}
	public Student(int id, String sex) {
		super();
		this.id = id;
		this.name = name;
	}

	public Student(int id, String name, String sex, int age) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public void Student(int age){
		this.age = age;
	}
	
	public String getSex(){
		return sex;
	}

}
