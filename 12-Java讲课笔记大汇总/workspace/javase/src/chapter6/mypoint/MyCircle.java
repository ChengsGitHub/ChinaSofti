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
	 * ����equals����
	 */
	public boolean equals(Object obj) {
	
		//���ø���ķ����ж�ǰ��������ֵ�Ƿ���ͬ
		if (!super.equals(obj))
			return false;
		
		//�жϴ���Ķ����Ƿ��ǵ�ǰ����
		if (!(obj instanceof MyCircle))
			return false;
		
		MyCircle other = (MyCircle) obj;
		
		if (this.radius == other.radius) 
			return true;
		
		return false;
	}

	/**
	 * ��Բ���	
	 */
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {		
		return super.toString() + "," + this.radius;
	}

}
