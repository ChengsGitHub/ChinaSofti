package chapter12;

/**
 * 自定义泛型类 
 */
public class Tools<T> {

	public T getLast(T[] a) {
		return a[a.length-1];
	}
	
	public static <T> T getFirst(T[] a) {
		return a[0];
	}
	
	public static void main(String[] args) {
		
		String[] s = {"aaa","bbb","ccc"};
		Integer[] i = {51,58,47,62};
		
		Tools<String> tools1 = new Tools<String>();
		Tools<Integer> tools2 = new Tools<Integer>();
		
		System.out.println(tools1.getLast(s));
		System.out.println(tools2.getLast(i));
		
		System.out.println(Tools.<String>getFirst(s));
		System.out.println(Tools.getFirst(i));
	}

}