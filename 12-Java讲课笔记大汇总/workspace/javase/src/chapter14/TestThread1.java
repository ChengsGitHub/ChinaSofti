package chapter14;

public class TestThread1 {
	
	public static void main(String[] args) {
		
		System.out.println("������ʼ");

		Runner r1 = new Runner();
		Runner r2 = new Runner();
		
		r1.setName("��");
		r2.setName("��");
				
		r1.start();//����һ���µ��߳�
		r2.start();		
		
		System.out.println("���������");
	}

}

/*���߳���*/
class Runner extends Thread {

	@Override
	public void run() {
		for (int i = 1;i <= 20;i ++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
	
}