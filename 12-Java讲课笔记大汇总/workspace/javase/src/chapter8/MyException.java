package chapter8;

/**
 * �Զ����쳣�� 
 */
public class MyException extends Exception {

	private int errorId;//�����

	public MyException(String message, int errorId) {
		super(message);
		this.errorId = errorId;
	}

	public int getErrorId() {
		return errorId;
	}

	//����
	public static void main(String[] args) {
		MyException mye = new MyException("����һ��XX�쳣",1001);
		try {
			throw mye;
		} catch (MyException e) {
			System.out.println("�쳣��Ϣ��" + e.getMessage() + ",����ţ�" + e.getErrorId());
		}
	}
	
}