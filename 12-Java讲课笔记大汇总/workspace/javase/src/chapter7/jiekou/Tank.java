package chapter7.jiekou;

public class Tank extends Car implements Weapon {

	@Override
	public void fire() {
		System.out.println("¿ªÅÚ" + QTY + "·¢");		
	}

}