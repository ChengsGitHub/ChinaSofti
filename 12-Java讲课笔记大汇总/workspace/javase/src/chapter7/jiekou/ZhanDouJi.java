package chapter7.jiekou;

public class ZhanDouJi extends Plane implements Weapon{

	@Override
	public void fire() {
		System.out.println("���䵼��" + QTY + "ö");		
	}

}