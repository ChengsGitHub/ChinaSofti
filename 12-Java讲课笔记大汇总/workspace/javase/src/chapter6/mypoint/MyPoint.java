package chapter6.mypoint;

public class MyPoint implements Comparable<MyPoint> {

	protected int x;
	protected int y;
	
	public MyPoint(){
		
	}

	public MyPoint(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public String toString() {
		return this.x + "," + this.y;
	}

	/**
	 * 覆盖equasl方法
	 */
	@Override
	public boolean equals(Object obj) {
		
		//判断是否是同一个对象实例
		if (this == obj)
			return true;
		
		//判断传入的对象是否是当前类型
		if (this.getClass() != obj.getClass())
			return false;
		
		//强制转换为MyPoint类型
		MyPoint other = (MyPoint) obj;
		
		//判断属性值是否相同
		if (this.x == other.x && this.y == other.y)
			return true;
		
		return false;
	}

	/**
	 * 覆盖hashCode方法
	 */
	@Override
	public int hashCode() {
		return this.x * 37 + this.y * 53 + 101;
	}

	/**
	 * 对象比较大小
	 */
	@Override
	public int compareTo(MyPoint other) {
				
		if (this.x > other.x)
			return 1;
		else if (this.x < other.x)
			return -1;
		
		return 0;
	}	
	
}