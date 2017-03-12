package com.icss.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.emp1.dao.Emp1Dao;
import com.icss.oa.emp1.dao.Emp1DaoImpl;
import com.icss.oa.emp1.pojo.Emp1;
import com.icss.oa.emp1.service.Emp1Service;
import com.icss.oa.emp1.service.Emp1ServiceImpl;
import com.icss.oa.system.dao.EmpDao;
import com.icss.oa.system.dao.EmpDaoImpl;
import com.icss.oa.system.pojo.Emp;
import com.icss.oa.system.service.EmpService;

public class TestEmpDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private EmpService service = (EmpService) context.getBean(EmpService.class);
	private EmpDao dao = (EmpDao) context.getBean(EmpDao.class);
	private Emp1Dao dao1 = (Emp1Dao) context.getBean(Emp1Dao.class);

	@Test
	public void testInsert() {
		Emp emp = new Emp("李四", "lisi", "123456", "男",
				Date.valueOf("1987-5-6"), "lisi@163.com", "84755556",
				"13012345678", "高新园区天地软件园", "这家伙很懒，什么都没有留下", 2, 1);
		dao.insert(emp);
	}
	
	@Test
	public void testUpdate() {
		Emp1 emp1 = new Emp1(21,"李四", "zhangsan", "666999", "男",
				Date.valueOf("1987-5-6"), "lisi@163.com", "84755556",
				"13012345678", "高新园区天地软件园", "这家伙很懒，什么都没有留下", 3, 1);
		dao1.update(emp1);
	}
	
	@Test
	public void testDelete() {
		
		dao.delete(201);
	}
	
	@Test
	public void testInsertMany() {
		for (int i = 1;i <= 20;i ++) {
		Emp emp = new Emp("李四" + i, "lisi", "123456", "男",
				Date.valueOf("1987-5-6"), "lisi@163.com", "84755556",
				"13012345678", "高新园区天地软件园", "这家伙很懒，什么都没有留下", 2, 1);
			dao.insert(emp);
		}
	}

	@Test
	public void testGetCount() {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQueryById() {
		Emp1 emp1 = dao1.queryById(1);
		System.out.println(emp1);
	}
	
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(), 2);
		List<Emp> list = dao.query(pager);
		for (Emp emp1 : list) {
			System.out.println(emp1);
		}
	}
	
	@Test
	public void testQuery3() {
		Pager pager = new Pager(dao.getCount(), 1);
		List<Emp> list = service.query(pager);
		for (Emp emp1 : list) {
			System.out.println(emp1);
		}
	}
	
	@Test
	public void testQuery2() {
		Pager pager = new Pager(dao.getCount(), 1);
		List<Map<String,Object>> list = dao.query2(pager);
		for (Map<String,Object> map : list) {
			System.out.println(map.get("EMP_NAME"));;
		}
	}
	
	
	@Test
	public void testQueryRoleService() {
		List<Map<String, Object>> list=service.queryRole(2);
		for (Map<String,Object> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void testDeleteRoleService() {
		
		service.deleteRole(21);
		
	}
	@Test
	public void testgetPrimaryKey() {
		int count=dao.getPrimaryKey();
		System.out.println("count=" + count);
	}
}