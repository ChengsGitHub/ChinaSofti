package chapter7;

/**
 * ��̬��Ա
 */
public class TestStatic {

	public static void main(String[] args) {

		Count c1 = new Count();
		Count c2 = new Count();
		Count c3 = new Count();

		c1.j = 10;
		c2.j = 20;

		Count.m1();
	}

}

class Count {

	public static int i = 100;
	public int j = 0;
	
	static {		
		i = 100;
		System.out.println("��̬��ʼ����1������");
	}

	public Count() {
		i++;
		j++;
	}
	
	static {
		System.out.println("��̬��ʼ����2������");
	}

	public static void m1() {
		System.out.println("i=" + i);// ����ֱ�ӷ��ʾ�̬��Ա
		Count c = new Count();
		System.out.println("j=" + c.j);// ���ʷǾ�̬��Ա����ͨ�������������
	}

}