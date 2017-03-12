package chapter14;

/**
 * ÄäÃûÀàĞ´·¨
 * @author Administrator
 *
 */
public class TestThread4 {

	public static void main(String[] args) {
		
		new Thread() {
			
			public void run() {
				for (int i = 1;i <= 20;i ++) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
			}
			
		}.start();

	}

}