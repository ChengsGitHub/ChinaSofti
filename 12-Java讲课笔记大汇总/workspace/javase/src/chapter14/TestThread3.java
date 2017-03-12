package chapter14;

public class TestThread3 {

	public static void main(String[] args) {
		Tree tree = new Tree();
		Thread t1 = new Thread(tree);
		Thread t2 = new Thread(tree);
		t1.setName("��");
		t2.setName("��");
		t1.start();
		t2.start();		
	}

}

//�������������
class Tree implements Runnable  {
	
	private int bird = 0;//�������

	@Override
	public synchronized void run() {
		for (int i = 1;i <= 3;i ++) {
			bird = bird + i;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			bird = bird - i;			
			System.out.println(Thread.currentThread().getName() + ":" + bird);
		}
	}
	
}