package chapter3;

public class MyDate {

	public int year;
	
	public int month;
	
	public int day;

	public MyDate(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void print() {
		System.out.println(this.year + "-" + this.month + "-" + this.day);
	}
	
	public static void main(String[] args) {
		
		MyDate m1 = new MyDate(2005,7,19);
		MyDate m2 = m1;
		MyDate m3 = m2;
		
		m3.day = 11;
		
		m1.print();
		m2.print();		
	}
	
}