package chapter11;

/**
 * �ֽ��ַ���
 * @author Administrator
 *
 */
public class TestSplit {

	public static void main(String[] args) {
		
		String s = "����|�Ϻ�|�Ͼ�|����|����|����";
		
		String[] citys = s.split("\\|");//������ʽ�������ַ���Ҫ��ת��
		
		for (String city : citys) {
			System.out.println(city);
		}
		
	}

}