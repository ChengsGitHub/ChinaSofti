package chapter6;

public class TestWrapper {

	public static void main(String[] args) {
		
//		int i = 10;
//		Integer objInt = new Integer(i);//�ֶ�װ��
//		int j = objInt.intValue();//�ֶ�����
//		System.out.println(j);

		int i = 10;
		Integer objInt = i;//�Զ�װ�䣨��������ת�������ͣ��ȼ���new Integer(i)
		int j = objInt + 100;//�Զ����䣨��������ת�������ͣ��ȼ���objInt.intValue()
		System.out.println(j);
		
		//�Զ�װ�������ƥ��Ļ������ͣ�
		Double objDouble = 3.0;
		Float objFloat = 3.14f;
		Long objLong = 100L;
		
		//objDouble = objFloat;//���󣬰�װ����û�д�С֮�ֵ�
		
		//�Ƚ���ȱ�����equals
		Integer objInt1 = 1000;
		Integer objInt2 = 1000;		
		System.out.println(objInt1 == objInt2);//false
		System.out.println(objInt1.equals(objInt2));//true
		
		//��-128~127֮�����߳����ص�ͬһ������
		Integer objInt3 = 127;
		Integer objInt4 = 127;		
		System.out.println(objInt3 == objInt4);//true
		
		//���������޷������ֵ����װ�����
		Integer salary = null;
	}

}