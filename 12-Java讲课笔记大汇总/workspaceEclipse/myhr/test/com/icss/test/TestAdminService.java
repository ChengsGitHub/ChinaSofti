package com.icss.test;

import org.junit.Test;

import com.icss.hr.admin.service.impl.AdminServiceImpl;
import com.icss.hr.admin.vo.AdminVo;

public class TestAdminService {

	private AdminServiceImpl service = new AdminServiceImpl();
	
	@Test
	public void testCheckLogin() throws Exception {
		AdminVo vo = new AdminVo("admin","admin",1);
		int flag = service.checkLogin(vo);
		System.out.println(flag);
	}
	
}