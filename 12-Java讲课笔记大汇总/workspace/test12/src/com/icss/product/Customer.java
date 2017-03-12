package com.icss.product;

/**
 * 客户类
 * 
 * @author Administrator
 * 
 */
public class Customer {
	
	private String name;//客户姓名
	private String tel;//电话
	private String address;//地址
	private boolean vip;//是否是vip客户
	
	public Customer() {
		
	}

	public Customer(String name, String tel, String address, boolean vip) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.vip = vip;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}

}
