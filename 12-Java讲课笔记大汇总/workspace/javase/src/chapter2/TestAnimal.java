package chapter2;

public class TestAnimal {

	public static void main(String[] args) {
		
		Animal cat = new Animal("С��è");
				
		System.out.println("name=" + cat.getName());
		System.out.println("legs=" + cat.getLegs());
	
		cat.eat("è��",2,"��");
		cat.eat("����",3,"ֻ");
		cat.run();
	}

}