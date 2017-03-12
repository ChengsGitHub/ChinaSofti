package chapter6;

/**
 * String和包装类转换 
 */
public class TestWrapper2 {

	public static void main(String[] args) {
		
		String s = "100";		
		int i = Integer.parseInt(s);		
		System.out.println(i);
		
		s = "100.5";
		double d = Double.parseDouble(s);	
		System.out.println(d);
		
		int j = 200;
		s = j + "";
		s = String.valueOf(j);//推荐
		s = (new Integer(j)).toString();
		System.out.println(s);		
	}

}