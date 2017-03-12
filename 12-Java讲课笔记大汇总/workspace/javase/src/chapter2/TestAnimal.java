package chapter2;

public class TestAnimal {

	public static void main(String[] args) {
		
		Animal cat = new Animal("小花猫");
				
		System.out.println("name=" + cat.getName());
		System.out.println("legs=" + cat.getLegs());
	
		cat.eat("猫粮",2,"罐");
		cat.eat("耗子",3,"只");
		cat.run();
	}

}