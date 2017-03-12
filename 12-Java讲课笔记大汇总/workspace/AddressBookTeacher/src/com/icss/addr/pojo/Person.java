package com.icss.addr.pojo;

/**
 * ����ģ�ͣ���װ��Ա��Ϣ
 * pojo��JAVA����
 * 
 * @author Administrator
 * 
 */
public class Person {

	private String name;
	private String phone;

	public Person() {
		super();
	}

	public Person(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return name + "|" + phone;
	}	

}