package chapter7.jiekou;

public class TestInterface {
	
	public static void main(String[] args) {
		
		Plane plane = new ZhanDouJi();//����͸����̬
		plane.fly();
								
		Weapon weapon = new ZhanDouJi();//ʵ����ͽӿڶ�̬
		weapon.fire();
		
		Car car = new Tank();//����͸����̬
		car.run();
		
		Weapon weapon2 = new Tank();//ʵ����ͽӿڶ�̬
		weapon2.fire();

		System.out.println(plane instanceof Weapon);//true
				
	}

}