package chapter6.mypoint;

import java.util.HashSet;

public class TestSet {

	public static void main(String[] args) {
		
		MyPoint mp1 = new MyPoint(5,3);		
		MyPoint mp2 = new MyPoint(5,3);
	
		HashSet set = new HashSet();
		
		set.add(mp1);
		set.add(mp2);
				
		System.out.println(set.size());
		
	}

}
