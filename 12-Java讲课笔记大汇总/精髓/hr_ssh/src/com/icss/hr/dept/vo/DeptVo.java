package com.icss.hr.dept.vo;

/**
 * VO¿‡
 * @author Administrator
 *
 */
public class DeptVo {

	private Integer deptId;

	private String deptName;

	private String deptLoc;

	public DeptVo() {
		super();
	}

	public DeptVo(Integer deptId, String deptName, String deptLoc) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptLoc = deptLoc;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptLoc() {
		return deptLoc;
	}

	public void setDeptLoc(String deptLoc) {
		this.deptLoc = deptLoc;
	}
	
}
