package chapter8;

public class TestException1 {

	public static void main(String[] args) {
		
		String[] names = {"tom","jack","rose"};
				
		try {
						
			for (int i = 0;i <= names.length;i ++) {
				System.out.println(names[i]);
			}	
			
			System.out.println("ѭ������");
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�������쳣��" + e.getMessage());
			//e.printStackTrace();//��ӡ�����ջ��Ϣ
		}

		System.out.println("�������");
		
	}

}