package chapter8;

public class TestException4 {

	public static void main(String[] args) {

		String[] names = { "tom", "jack", "rose" };

		try {
			
			for (int i = 0; i <= names.length; i++) {
				System.out.println(names[i]);
			}

			System.out.println("ѭ������");

		} catch (Exception e) {
			System.out.println("�������쳣��" + e.getMessage());
			e.printStackTrace();
			//return;
		} finally {
			System.out.println("�����ִ�е����");
		}

		System.out.println("�������");
	}

}