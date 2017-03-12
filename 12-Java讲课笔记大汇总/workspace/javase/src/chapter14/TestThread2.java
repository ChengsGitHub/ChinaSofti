package chapter14;

public class TestThread2 {

	public static void main(String[] args) {
		
		MyRunner mr = new MyRunner();
		
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		
		t1.setName("甲");
		t2.setName("乙");
		
		t1.start();
		t2.start();
	}

}

//多线程实现的第二种方式
class MyRunner implements Runnable {
	
	private int i = 0;

	@Override
	public void run() {
		for (i = 1;i <= 20;i ++) {			
			try {
				Thread.sleep(200);//当前线程休眠200毫秒之后再继续执行
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
			System.out.println(Thread.currentThread().getName() + ":" + i);						
		}
	}
	
}