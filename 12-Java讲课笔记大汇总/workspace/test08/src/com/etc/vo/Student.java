package com.etc.vo;

import java.util.Date;

/**
 * 
 *@author Administrator
 *@version 2014-8-6 Student data
 */
public class Student {
	// data member
	private String sno; // sno
	private String name;
	private boolean sex;
	private Date bir;
	private double score;

	
	// method
	public Student() {
		super();
		System.out.println(this.sno);
	}

	public Student(Date bir, String name, double score, boolean sex, String sno) {
		super();
		this.score=this.getIfScore(score);
		this.bir = bir;
		this.name = name;
		this.sex = sex;
		this.sno = sno;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public Date getBir() {
		return bir;
	}

	public void setBir(Date bir) {
		this.bir = bir;
	}

	public double getIfScore(double score){
		if (score > 500 || score < -10) {
			score = 0;
		}
		return score;
	}
	
	public void setScore(double score) { // location
		this.score=this.getIfScore(score);
		
	}

	public double getScore() {
		return this.score;
	}

/*	public void print() {
		System.out.println(this.sno + "\t" + this.name + "\t" + this.score);
	}*/

	@Override
	public String toString() {
		return this.sno + "\t" + this.name + "\t" + this.score;
	}
	
}
