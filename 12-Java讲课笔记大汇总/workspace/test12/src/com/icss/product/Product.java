package com.icss.product;

/**
 * ��Ʒ��
 * 
 * @author Administrator
 * 
 */
public class Product {

	private String name;// ��Ʒ����
	private int id;// ��Ʒ���
	private double price;// ����
	private int count = 0;// ����

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}