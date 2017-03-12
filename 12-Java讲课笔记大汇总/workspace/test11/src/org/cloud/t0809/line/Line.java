package org.cloud.t0809.line;

/**
 * 线，有两个点
 * @author Administrator
 *
 */
public class Line {

	private Point a;
	private Point b;

	public Line(Point a, Point b) {
		super();
		this.a = a;
		this.b = b;
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public double getLength() {
		int xl = a.getX() - b.getX();
		int yl = a.getY() - b.getY();
		return Math.sqrt((xl * xl) + (yl * yl));
	}

}