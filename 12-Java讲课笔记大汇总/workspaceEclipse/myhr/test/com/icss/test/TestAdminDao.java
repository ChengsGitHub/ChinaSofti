package com.icss.test;

import org.junit.Test;

import com.icss.hr.admin.dao.impl.AdminDaoImpl;
import com.icss.hr.admin.po.Admin;

public class TestAdminDao {
	
	private AdminDaoImpl dao = new AdminDaoImpl();
	
	@Test
	public void testQueryByName() throws Exception {
		
		Admin admin = dao.queryByName("admin");
		System.out.println(admin);
		
	}

}