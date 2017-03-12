package chapter11;

/**
 * 分解字符串
 * @author Administrator
 *
 */
public class TestSplit {

	public static void main(String[] args) {
		
		String s = "北京|上海|南京|深圳|广州|大连";
		
		String[] citys = s.split("\\|");//正则表达式的特殊字符需要被转义
		
		for (String city : citys) {
			System.out.println(city);
		}
		
	}

}