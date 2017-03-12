package chapter6.mypoint;

public class MyCircle extends MyPoint {
	
	protected int radius;

	public MyCircle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}
	
	/**
	 * 覆盖equals方法
	 */
	public boolean equals(Object obj) {
	
		//调用父类的方法判断前两个属性值是否相同
		if (!super.equals(obj))
			return false;
		
		//判断传入的对象是否是当前类型
		if (!(obj instanceof MyCircle))
			return false;
		
		MyCircle other = (MyCircle) obj;
		
		if (this.radius == other.radius) 
			return true;
		
		return false;
	}

	/**
	 * 求圆面积	
	 */
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {		
		return super.toString() + "," + this.radius;
	}

}
