package chapter7;

public abstract class Animal {
	
	protected String name;
	
	protected int legs;
		
	public Animal(String name, int legs) {
		super();
		this.name = name;
		this.legs = legs;
	}

	public void eat() {
		System.out.println(name + "用嘴巴吃东西");
	}
	
	//抽象方法
	public abstract void run(); 
	
	//模板方法：调用抽象方法
	public void catchFood() {
		run();
		System.out.println("捕食猎物");
	}

}