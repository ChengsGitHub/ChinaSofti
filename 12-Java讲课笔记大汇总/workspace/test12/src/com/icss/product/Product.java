package com.icss.product;

/**
 * 商品类
 * 
 * @author Administrator
 * 
 */
public class Product {

	private String name;// 商品名称
	private int id;// 商品编号
	private double price;// 单价
	private int count = 0;// 数量

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