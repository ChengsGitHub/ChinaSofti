package Job3;

/**
 * ��ȭ����
 * @author Administrator
 *
 */
public class Rule {
	
	int count = 0;
	
	Computer computer;//ϵͳ
	
	Person person;//�û�

	/**
	 * �жϲ�ȭ��Ӯ
	 */
	public void ruleFist() {
		if (computer.num == person.num) {
			System.out.println("�;֣���˥���ٺ٣������ưɣ�");
		} else {
			
			if (person.num == 1) {
				if (computer.num == 3) {
					System.out.println("��ϲ����Ӯ��!");
					person.score++;
				} else {
					System.out.println("^_^�������ˣ��汿��");
					computer.score++;
				}
			}
			
			if (person.num == 2) {
				if (computer.num == 1) {
					System.out.println("��ϲ����Ӯ��!");
					person.score++;
				} else {
					System.out.println("^_^�������ˣ��汿��");
					computer.score++;
				}
			}
			
			if (person.num == 3) {
				if (computer.num == 2) {
					System.out.println("��ϲ����Ӯ��!");
					person.score++;
				} else {
					System.out.println("^_^�������ˣ��汿��");
					computer.score++;
				}
			}
		}
	}

	/**
	 * ���ֱȽ�
	 */
	public void showResult() {
		if (computer.score > person.score) {
			System.out.println("������Ǻǣ��������´μ��Ͱ���");
		} else if (computer.score < person.score) {
			System.out.println("���������ʤ��");
		} else if (computer.score == person.score) {
			System.out.println("�����ƽ�֣��´���ս");
		}
	}
}
