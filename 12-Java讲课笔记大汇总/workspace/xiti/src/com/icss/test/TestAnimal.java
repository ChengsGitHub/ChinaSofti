package com.icss.test;

public class TestAnimal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Animal a = new Rabbit();
		Feeder liuxiang = new Feeder();
		liuxiang.feed(a);

	}

}
