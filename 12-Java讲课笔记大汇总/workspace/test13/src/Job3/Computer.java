package Job3;

/**
 * ϵͳ
 * @author Administrator
 *
 */
public class Computer {
	
	public int score=0;//����
	public int num;//�������1ʯͷ2��3
	public String name;//�����������
	
	/**
	 * ���������������
	 * @return
	 */
	public String computerHero() {
		int a = (int) ((3 - 1 + 1) * Math.random() + 1);
		if (a == 1)
			return name = "����";
		if (a == 2)
			return name = "��Ȩ";
		else
			return name = "�ܲ�";
	}

	/**
	 * �������ʯͷ���Ӳ�
	 */
	public void showFist() {
		num = (int) ((3 - 1 + 1) * Math.random() + 1);
		if (num == 1) {
			System.out.println("���Գ�ȭ������");
		} else if (num == 2) {
			System.out.println("���Գ�ȭ��ʯͷ");
		} else if (num == 3) {
			System.out.println("���Գ�ȭ����");
		}
	}
	
}