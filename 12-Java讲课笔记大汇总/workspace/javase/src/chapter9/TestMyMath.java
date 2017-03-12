package chapter9;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Junit������
 * ���Է���������test��ͷ��û�з���ֵ��û�в����������@Testע�⣨Junit4֧��ע�⣬Junit3��Ҫ�̳�TestCase���ࣩ
 *
 */
public class TestMyMath {
	
	MyMath myMath = new MyMath();
	
	@Test
	public void testChuFa() {		
		int result = myMath.chufa(10, 0);
		System.out.println(result);
	}

	@Test
	public void testChengFa() {
		int result = myMath.chengfa(5, 3);
		System.out.println(result);		
		//���ж��ԣ��Ա�Ԥ�ڽ����ʵ�ʽ��
		Assert.assertEquals(15, result);
	}
	
}