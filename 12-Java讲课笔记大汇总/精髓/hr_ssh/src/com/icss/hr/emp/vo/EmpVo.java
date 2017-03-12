package com.icss.hr.emp.vo;

import java.sql.Date;

/**
 * VO¿‡
 * @author Administrator
 *
 */
public class EmpVo {

	private Integer empId;

	private String empName;

	private String empEmail;

	private String empPhone;

	private Date empHiredate;

	private String jobId;

	private Integer empSalary;

	private Integer deptId;

	public EmpVo() {
		super();
	}

	public EmpVo(String empName, String empEmail, String empPhone,
			Date empHiredate, String jobId, Integer empSalary, Integer deptId) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPhone = empPhone;
		this.empHiredate = empHiredate;
		this.jobId = jobId;
		this.empSalary = empSalary;
		this.deptId = deptId;
	}

	public EmpVo(Integer empId, String empName, String empEmail, String empPhone,
			Date empHiredate, String jobId, Integer empSalary, Integer deptId) {
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

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
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

	public Integer getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(Integer empSalary) {
		this.empSalary = empSalary;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	
}