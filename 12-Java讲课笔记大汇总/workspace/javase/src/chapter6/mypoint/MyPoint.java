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
	 * ����equasl����
	 */
	@Override
	public boolean equals(Object obj) {
		
		//�ж��Ƿ���ͬһ������ʵ��
		if (this == obj)
			return true;
		
		//�жϴ���Ķ����Ƿ��ǵ�ǰ����
		if (this.getClass() != obj.getClass())
			return false;
		
		//ǿ��ת��ΪMyPoint����
		MyPoint other = (MyPoint) obj;
		
		//�ж�����ֵ�Ƿ���ͬ
		if (this.x == other.x && this.y == other.y)
			return true;
		
		return false;
	}

	/**
	 * ����hashCode����
	 */
	@Override
	public int hashCode() {
		return this.x * 37 + this.y * 53 + 101;
	}

	/**
	 * ����Ƚϴ�С
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