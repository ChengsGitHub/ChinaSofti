package com.icss.product;

/**
 * �ͻ���
 * 
 * @author Administrator
 * 
 */
public class Customer {
	
	private String name;//�ͻ�����
	private String tel;//�绰
	private String address;//��ַ
	private boolean vip;//�Ƿ���vip�ͻ�
	
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
