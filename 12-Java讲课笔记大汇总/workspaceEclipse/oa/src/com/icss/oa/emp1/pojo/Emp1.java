package com.icss.oa.emp1.pojo;

import java.util.Date;

public class Emp1 {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.EMP_ID
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private Integer emp1Id;
	private Integer isVisible;

	public Integer getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.EMP_NAME
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private String emp1Name;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.USERNAME
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private String username;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.PASSWORD
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private String password;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.EMP_SEX
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private String emp1Sex;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.EMP_BIRTHDATE
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private Date emp1Birthdate;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.EMP_EMAIL
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private String emp1Email;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.EMP_PHONE
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private String emp1Phone;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.EMP_MOBILE
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private String emp1Mobile;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.EMP_ADDRESS
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private String emp1Address;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.EMP_INFO
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private String emp1Info;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.DEPT_ID
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private Integer deptId;

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database column EMP.JOB_ID
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	private Integer jobId;

	public Emp1() {
		super();
	}

	public Emp1(String emp1Name, String username, String password, String emp1Sex,
			Date emp1Birthdate, String emp1Email, String emp1Phone,
			String emp1Mobile, String emp1Address, String emp1Info,
			Integer deptId, Integer jobId) {
		super();
		this.emp1Name = emp1Name;
		this.username = username;
		this.password = password;
		this.emp1Sex = emp1Sex;
		this.emp1Birthdate = emp1Birthdate;
		this.emp1Email = emp1Email;
		this.emp1Phone = emp1Phone;
		this.emp1Mobile = emp1Mobile;
		this.emp1Address = emp1Address;
		this.emp1Info = emp1Info;
		this.deptId = deptId;
		this.jobId = jobId;
	}

	public Emp1(Integer emp1Id, String emp1Name, String username, String password,
			String emp1Sex, Date emp1Birthdate, String emp1Email, String emp1Phone,
			String emp1Mobile, String emp1Address, String emp1Info,
			Integer deptId, Integer jobId) {
		super();
		this.emp1Id = emp1Id;
		this.emp1Name = emp1Name;
		this.username = username;
		this.password = password;
		this.emp1Sex = emp1Sex;
		this.emp1Birthdate = emp1Birthdate;
		this.emp1Email = emp1Email;
		this.emp1Phone = emp1Phone;
		this.emp1Mobile = emp1Mobile;
		this.emp1Address = emp1Address;
		this.emp1Info = emp1Info;
		this.deptId = deptId;
		this.jobId = jobId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.EMP_ID
	 * 
	 * @return the value of EMP.EMP_ID
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public Integer getEmp1Id() {
		return emp1Id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.EMP_ID
	 * 
	 * @param emp1Id
	 *            the value for EMP.EMP_ID
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setEmp1Id(Integer emp1Id) {
		this.emp1Id = emp1Id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.EMP_NAME
	 * 
	 * @return the value of EMP.EMP_NAME
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public String getEmp1Name() {
		return emp1Name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.EMP_NAME
	 * 
	 * @param emp1Name
	 *            the value for EMP.EMP_NAME
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setEmp1Name(String emp1Name) {
		this.emp1Name = emp1Name == null ? null : emp1Name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.USERNAME
	 * 
	 * @return the value of EMP.USERNAME
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.USERNAME
	 * 
	 * @param username
	 *            the value for EMP.USERNAME
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.PASSWORD
	 * 
	 * @return the value of EMP.PASSWORD
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.PASSWORD
	 * 
	 * @param password
	 *            the value for EMP.PASSWORD
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.EMP_SEX
	 * 
	 * @return the value of EMP.EMP_SEX
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public String getEmp1Sex() {
		return emp1Sex;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.EMP_SEX
	 * 
	 * @param emp1Sex
	 *            the value for EMP.EMP_SEX
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setEmp1Sex(String emp1Sex) {
		this.emp1Sex = emp1Sex == null ? null : emp1Sex.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.EMP_BIRTHDATE
	 * 
	 * @return the value of EMP.EMP_BIRTHDATE
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public Date getEmp1Birthdate() {
		return emp1Birthdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.EMP_BIRTHDATE
	 * 
	 * @param emp1Birthdate
	 *            the value for EMP.EMP_BIRTHDATE
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setEmp1Birthdate(Date emp1Birthdate) {
		this.emp1Birthdate = emp1Birthdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.EMP_EMAIL
	 * 
	 * @return the value of EMP.EMP_EMAIL
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public String getEmp1Email() {
		return emp1Email;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.EMP_EMAIL
	 * 
	 * @param emp1Email
	 *            the value for EMP.EMP_EMAIL
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setEmp1Email(String emp1Email) {
		this.emp1Email = emp1Email == null ? null : emp1Email.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.EMP_PHONE
	 * 
	 * @return the value of EMP.EMP_PHONE
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public String getEmp1Phone() {
		return emp1Phone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.EMP_PHONE
	 * 
	 * @param emp1Phone
	 *            the value for EMP.EMP_PHONE
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setEmp1Phone(String emp1Phone) {
		this.emp1Phone = emp1Phone == null ? null : emp1Phone.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.EMP_MOBILE
	 * 
	 * @return the value of EMP.EMP_MOBILE
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public String getEmp1Mobile() {
		return emp1Mobile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.EMP_MOBILE
	 * 
	 * @param emp1Mobile
	 *            the value for EMP.EMP_MOBILE
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setEmp1Mobile(String emp1Mobile) {
		this.emp1Mobile = emp1Mobile == null ? null : emp1Mobile.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.EMP_ADDRESS
	 * 
	 * @return the value of EMP.EMP_ADDRESS
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public String getEmp1Address() {
		return emp1Address;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.EMP_ADDRESS
	 * 
	 * @param emp1Address
	 *            the value for EMP.EMP_ADDRESS
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setEmp1Address(String emp1Address) {
		this.emp1Address = emp1Address == null ? null : emp1Address.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.EMP_INFO
	 * 
	 * @return the value of EMP.EMP_INFO
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public String getEmp1Info() {
		return emp1Info;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.EMP_INFO
	 * 
	 * @param emp1Info
	 *            the value for EMP.EMP_INFO
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setEmp1Info(String emp1Info) {
		this.emp1Info = emp1Info == null ? null : emp1Info.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.DEPT_ID
	 * 
	 * @return the value of EMP.DEPT_ID
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.DEPT_ID
	 * 
	 * @param deptId
	 *            the value for EMP.DEPT_ID
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column EMP.JOB_ID
	 * 
	 * @return the value of EMP.JOB_ID
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public Integer getJobId() {
		return jobId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column EMP.JOB_ID
	 * 
	 * @param jobId
	 *            the value for EMP.JOB_ID
	 * 
	 * @mbggenerated Tue Jun 24 11:25:19 CST 2014
	 */
	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	@Override
	public String toString() {
		return "Emp1 [emp1Id=" + emp1Id + ", emp1Name=" + emp1Name + ", username="
				+ username + ", password=" + password + ", emp1Sex=" + emp1Sex
				+ ", emp1Birthdate=" + emp1Birthdate + ", emp1Email=" + emp1Email
				+ ", emp1Phone=" + emp1Phone + ", emp1Mobile=" + emp1Mobile
				+ ", emp1Address=" + emp1Address + ", emp1Info=" + emp1Info
				+ ", deptId=" + deptId + ", jobId=" + jobId + "]";
	}

}