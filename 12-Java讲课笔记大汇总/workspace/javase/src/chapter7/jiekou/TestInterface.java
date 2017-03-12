package chapter7.jiekou;

public class TestInterface {
	
	public static void main(String[] args) {
		
		Plane plane = new ZhanDouJi();//子类和父类多态
		plane.fly();
								
		Weapon weapon = new ZhanDouJi();//实现类和接口多态
		weapon.fire();
		
		Car car = new Tank();//子类和父类多态
		car.run();
		
		Weapon weapon2 = new Tank();//实现类和接口多态
		weapon2.fire();

		System.out.println(plane instanceof Weapon);//true
				
	}

}