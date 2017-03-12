package chapter9;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Junit测试类
 * 测试方法：必须test开头，没有返回值，没有参数，必须加@Test注解（Junit4支持注解，Junit3需要继承TestCase父类）
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
		//进行断言，对比预期结果和实际结果
		Assert.assertEquals(15, result);
	}
	
}