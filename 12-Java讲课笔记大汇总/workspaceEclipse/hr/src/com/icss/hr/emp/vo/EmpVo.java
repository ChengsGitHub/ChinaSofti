package com.icss.hr.emp.vo;

import java.sql.Date;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.job.pojo.Job;

public class EmpVo {

	private int empId;

	private String empName;

	private String empEmail;

	private String empPhone;

	private Date empHiredate;

	private String jobId;

	private int empSalary;

	private int deptId;

	public EmpVo() {
		super();
	}

	public EmpVo(String empName, String empEmail, String empPhone,
			Date empHiredate, String jobId, int empSalary, int deptId) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empHiredate = empHiredate;
		this.jobId = jobId;
		this.empSalary = empSalary;
		this.deptId = deptId;
	}

	public EmpVo(int empId, String empName, String empEmail, String empPhone,
			Date empHiredate, String jobId, int empSalary, int deptId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empHiredate = empHiredate;
		this.jobId = jobId;
		this.empSalary = empSalary;
		this.deptId = deptId;
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

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	
}
