package chapter7;

public class Cat extends Animal {
	
	public Cat(String name,int legs) {
		super(name,legs);
	}

	@Override
	public void run() {
		System.out.println("ÓÃ" + legs + "ÌõÍÈÅÜ");		
	}

}