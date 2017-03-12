package chapter14;

public class TestThread1 {
	
	public static void main(String[] args) {
		
		System.out.println("主程序开始");

		Runner r1 = new Runner();
		Runner r2 = new Runner();
		
		r1.setName("甲");
		r2.setName("乙");
				
		r1.start();//启动一个新的线程
		r2.start();		
		
		System.out.println("主程序结束");
	}

}

/*多线程类*/
class Runner extends Thread {

	@Override
	public void run() {
		for (int i = 1;i <= 20;i ++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
	
}