package chapter3;

public class TestVarible {

	private int i = 10;

	public void m1() {

		int j = 20;
		System.out.println(j);
		j ++;
	}

	public void m2() {
		System.out.println(this.i);
	}

	public static void main(String[] args) {
		TestVarible t = new TestVarible();
		t.m1();			
	}

}