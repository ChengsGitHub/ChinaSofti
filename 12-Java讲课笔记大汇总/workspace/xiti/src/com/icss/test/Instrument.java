package com.icss.test;

public class Instrument {
	private String type;
	private double price;
	
	public Instrument() {
		super();
	}

	public Instrument(double price, String type) {
		super();
		this.price = price;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public void play(){
		System.out.println("ЕЏзр");
	}

}
