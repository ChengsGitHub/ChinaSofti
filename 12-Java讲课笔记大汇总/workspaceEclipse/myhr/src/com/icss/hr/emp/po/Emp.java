package com.icss.hr.emp.po;

import java.sql.Date;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.job.po.Job;

public class Emp {

	private int empId;

	private String empName;

	private String empEmail;

	private String empPhone;

	private Date empHiredate;

	private Job job;// 多对一

	private int empSalary;

	private Dept dept;

	public Emp() {
		super();
	}

	public Emp(String empName, String empEmail, String empPhone,
			Date empHiredate, Job job, int empSalary, Dept dept) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empHiredate = empHiredate;
		this.job = job;
		this.empSalary = empSalary;
		this.dept = dept;
	}

	public Emp(int empId, String empName, String empEmail, String empPhone,
			Date empHiredate, Job job, int empSalary, Dept dept) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empHiredate = empHiredate;
		this.job = job;
		this.empSalary = empSalary;
		this.dept = dept;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public Date getEmpHiredate() {
		return empHiredate;
	}

	public void setEmpHiredate(Date empHiredate) {
		this.empHiredate = empHiredate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empEmail="
				+ empEmail + ", empPhone=" + empPhone + ", empHiredate="
				+ empHiredate + ", job=" + job + ", empSalary=" + empSalary
				+ ", dept=" + dept + "]";
	}

	/*
	public static void main(String[] args) {

		Job job = new Job();
		job.setJobName("文员");

		Dept dept = new Dept();
		dept.setDeptName("客房部");

		Emp emp = new Emp(100, "张三", "zhang@163.com", "10086",
				Date.valueOf("2005-09-06"), job, 2400, dept);
		
		System.out.println(emp);

	}
	*/
}