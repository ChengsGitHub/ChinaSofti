package com.icss.hb.po;

// Generated 2014-11-10 16:46:08 by Hibernate Tools 3.4.0.CR1

import java.sql.Date;

/**
 * PO��  ʵ����
 */
public class Emp implements java.io.Serializable {

	private Integer empId;
	private String empName;
	private Integer empSalary;
	private Date empHiredate;
	
	public Emp() {
	}

	public Emp(Integer empId) {
		this.empId = empId;
	}

	public Emp(Integer empId, String empName, Integer empSalary, Date empHiredate) {
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empHiredate = empHiredate;
	}

	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Integer getEmpSalary() {
		return this.empSalary;
	}

	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}
	
	public Date getEmpHiredate() {
		return this.empHiredate;
	}

	public void setEmpHiredate(Date empHiredate) {
		this.empHiredate = empHiredate;
	}

	@Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + ", empSalary="
				+ empSalary + ", empHiredate=" + empHiredate + "]";
	}
	
}