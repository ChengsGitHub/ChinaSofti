package com.icss.hr.admin.po;

public class Admin {
	
	private String adminName;
	
	private String adminPwd;
	
	private int adminLevel;

	public Admin() {
		super();
	}

	public Admin(String adminName, String adminPwd, int adminLevel) {
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

	public int getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(int adminLevel) {
		this.adminLevel = adminLevel;
	}

	@Override
	public String toString() {
		return "Admin [adminName=" + adminName + ", adminPwd=" + adminPwd
				+ ", adminLevel=" + adminLevel + "]";
	}
	
}