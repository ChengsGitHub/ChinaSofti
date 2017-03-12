package chapter6.mypoint;

public class MySphere extends MyCircle {

	protected int z;

	public MySphere(int x, int y, int radius, int z) {
		super(x, y, radius);
		this.z = z;
	}

	/**
	 * ¸²¸Çequals·½·¨
	 */
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		
		if (!(obj instanceof MySphere))
			return false;
		
		MySphere other = (MySphere) obj;
		
		if (this.z == other.z)
			return true;
		
		return false;
	}
	
	public double getArea() {
		return 4 * super.getArea();
	}

	public double getVolume() {
		return this.getArea() * this.radius / 3.0;
	}

	@Override
	public String toString() {
		
		return super.toString() + "," + this.z;
	}

}
