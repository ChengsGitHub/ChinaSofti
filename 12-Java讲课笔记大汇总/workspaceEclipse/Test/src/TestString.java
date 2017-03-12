import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;


public class TestString {

	public static void main(String[] args) {
		
		String s = "ABBCDDEFGH";
		
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();		
		
		for (int i = 0;i < s.length();i ++) {
			String c = s.charAt(i) + "";
			list.add(c);
		}
		
		for (String item : list) {			
			if (!list2.contains(item)) {
				list2.add(item);
			}
		}
						
		for (int i = list2.size() - 1;i >= 0;i --) {
			System.out.println(list2.get(i).toLowerCase());
		}
		
	}

}
