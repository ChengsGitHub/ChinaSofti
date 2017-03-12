package com.icss.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.service.impl.AdminServiceImpl;
import com.icss.hr.admin.vo.AdminVo;

public class TestAdminService {

	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"application*.xml");
	
	private AdminService service = (AdminService) context.getBean("adminService");
	
	@Test
	public void testCheckLogin() throws Exception {
		AdminVo vo = new AdminVo("admin","admin",1);
		int flag = service.checkLogin(vo);
		System.out.println(flag);
	}
	
}