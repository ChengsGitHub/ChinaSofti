package com.icss.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.DeptDao;
import com.icss.oa.system.dao.DeptDaoImpl;
import com.icss.oa.system.dao.RoleDao;
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.system.pojo.Role;
import com.icss.oa.system.service.DeptService;
import com.icss.oa.system.service.RoleService;

public class TestRoleDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private RoleDao dao = (RoleDao) context.getBean(RoleDao.class);
	private RoleService service=(RoleService) context.getBean(RoleService.class);
	@Test
	public void testGetCount() {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
	
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(),2);
		List<Role> list = dao.queryRole(pager);
		for (Role role : list) {
			System.out.println(role);
		}
	}
	

	
	@Test
	public void testQueryRoleId() {
		Role role=dao.queryRoleId(1);
		System.out.println(role);
	}
}