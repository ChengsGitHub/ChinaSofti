package com.icss.test;

import org.junit.Test;

import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.service.impl.AdminServiceImpl;
import com.icss.hr.admin.vo.AdminVo;

public class TestAdminService {

	@Test
	public void testCheckLogin() throws Exception {
		
		AdminService service = new AdminServiceImpl();
		
		AdminVo vo = new AdminVo("admin","admin",2);
		
		int result = service.checkLogin(vo);
		
		System.out.println(result);
		
	}

}
