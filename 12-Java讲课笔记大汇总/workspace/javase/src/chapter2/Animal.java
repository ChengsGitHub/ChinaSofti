package chapter2;

public class Animal {

	private String name;

	private int legs;
	
	public Animal() {
		
	}
	
	public Animal(String name) {		
		this.name = name;
	}

	public Animal(String name, int legs) {	
		this.name = name;
		this.legs = legs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLegs() {
		return legs;
	}

	public void setLegs(int legs) {
		if (legs == 2 || legs == 4 || legs == 6 || legs == 8)
			this.legs = legs;		
	}
	
	public void eat(String food,int qty,String unit) {
		System.out.println("≥‘" + qty + unit + food);
	}
	
	public void run() {
		System.out.println(this.name + "”√" + this.legs + "ÃıÕ»≈‹");
	}

}