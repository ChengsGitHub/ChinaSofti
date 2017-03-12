public class Demo09 {
	public static void myChange(Object o){
		    double  t = (  Double  ) o;
		System.out.println(t);
	}

	public static void main(String[] args) {
		double b = 30.5;
		myChange(b);
	}
}