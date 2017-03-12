package chapter14;

public class TestThread2 {

	public static void main(String[] args) {
		
		MyRunner mr = new MyRunner();
		
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		
		t1.setName("��");
		t2.setName("��");
		
		t1.start();
		t2.start();
	}

}

//���߳�ʵ�ֵĵڶ��ַ�ʽ
class MyRunner implements Runnable {
	
	private int i = 0;

	@Override
	public void run() {
		for (i = 1;i <= 20;i ++) {			
			try {
				Thread.sleep(200);//��ǰ�߳�����200����֮���ټ���ִ��
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}			
			System.out.println(Thread.currentThread().getName() + ":" + i);						
		}
	}
	
}