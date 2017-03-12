package com.icss.student.pojo;

/**
 * 学生POJO类，封装表数据
 * 
 * @author Ambow
 * 
 */
public class Student {

	private int id;

	private int stuCode;

	private String stuName;

	private String stuPhone;

	public Student() {
		super();
	}

	public Student(int stuCode, String stuName, String stuPhone) {
		super();
		this.stuCode = stuCode;
		this.stuName = stuName;
		this.stuPhone = stuPhone;
	}

	public Student(int id, int stuCode, String stuName, String stuPhone) {
		super();
		this.id = id;
		this.stuCode = stuCode;
		this.stuName = stuName;
		this.stuPhone = stuPhone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStuCode() {
		return stuCode;
	}

	public void setStuCode(int stuCode) {
		this.stuCode = stuCode;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuPhone() {
		return stuPhone;
	}

	public void setStuPhone(String stuPhone) {
		this.stuPhone = stuPhone;
	}
	
}