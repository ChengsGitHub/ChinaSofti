package chapter8;

public class TestException3 {

	public static void main(String[] args) {
						
		String[] names = {"tom","jack","rose"};
				
		try {	
			String s = null;
			s.length();
						
			int j = 10 / 0;//�����������
						
			for (int i = 0;i <= names.length;i ++) {
				System.out.println(names[i]);
			}	
			
			System.out.println("ѭ������");
			
		}  catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("�������±�Խ���쳣��" + e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("��������ѧ�쳣��" + e.getMessage());
		} catch (Exception e) {
			System.out.println("�������쳣��" + e.getMessage());
		}

		System.out.println("�������");		
	}

}