package chapter6.encryptnum;

public class TestMyNumber {

	public static void main(String[] args) {
		
		EncryptMyNumber number = new EncryptMyNumber();
		number.setNum(2109);
		System.out.println("����ǰ��" +number.getNum());
		System.out.println("���ܺ�" + number.getEncryptNum());

	}

} 