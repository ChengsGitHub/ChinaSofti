package com.icss.hr.admin.vo;

/**
 * VO¿‡
 * @author Administrator
 *
 */
public class AdminVo {
	
	private String adminName;
	
	private String adminPwd;
	
	private Integer adminLevel;

	public AdminVo() {
		super();
	}

	public AdminVo(String adminName, String adminPwd, Integer adminLevel) {
		super();
		this.adminName = adminName;
		this.adminPwd = adminPwd;
		this.adminLevel = adminLevel;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPwd() {
		return adminPwd;
	}

	public void setAdminPwd(String adminPwd) {
		this.adminPwd = adminPwd;
	}

	public Integer getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(Integer adminLevel) {
		this.adminLevel = adminLevel;
	}
	
	

}