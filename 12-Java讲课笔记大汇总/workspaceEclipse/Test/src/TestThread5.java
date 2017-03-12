public class TestThread5 {
	public static void main(String args[]) {
		Runner5 r = new Runner5();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
		}
		for (int i = 0; i < 20; i++) {
			System.out.println("Ö÷Ïß³Ì:" + i);
		}
	}
}

class Runner5 implements Runnable {
	public void run() {
		for (int i = 0; i < 20; i++)
			System.out.println("SubThread: " + i + Thread.currentThread().getName());
	}
}