import java.util.Scanner;

/**
 * ����һ���ַ������� �����ĸ�Ԫ�� �� ƻ�� �㽶 ���� ����
 * ����
 * �ӿ���̨����һ�� �ж��Ƿ���� �� ����
 * @author Administrator
 *
 */
public class TestArray2 {
	public static void main(String[] args) {
		 String [] a = new String [4];
		 a[0] = "�㽶";
		 a[1] = "����";
		 a[2] = "ƻ��";
		 a[3] = "����";
		 Scanner sc = new Scanner(System.in);
		 //System.out.println("������");
		 String b = sc.nextLine();
		 System.out.println(b);
		
		 boolean flag = true;
		 for (int i = 0; i < a.length; i++) {
			if(b.equals(a[i])){
				System.out.println("have");
				flag = false;
				break;
			}
		}
		 if(flag){
			 System.out.println("no");
		 }

	}

}
