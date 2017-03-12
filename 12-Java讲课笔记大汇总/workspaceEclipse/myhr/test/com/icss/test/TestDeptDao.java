package com.icss.test;

import java.util.ArrayList;

import org.junit.Test;

import com.icss.hr.dept.dao.impl.DeptDaoImpl;
import com.icss.hr.dept.po.Dept;

/**
 * 测试类
 * @author Administrator
 *
 */
public class TestDeptDao {
	
	private DeptDaoImpl dao = new DeptDaoImpl();
	
	@Test
	public void testInsert() throws Exception {
		Dept dept = new Dept(20,"客房部","6楼~11楼");
		dao.insert(dept);
	}
	
	@Test
	public void testUpdate() throws Exception {
		Dept dept = new Dept(30,"内勤部","22楼");
		dao.update(dept);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(10);
	}
	
	@Test
	public void testQueryById() throws Exception {
		Dept dept = dao.queryById(10);
		System.out.println(dept);
	}
	
	@Test
	public void testQuery() throws Exception {
		ArrayList<Dept> list = dao.query();
		for (Dept d : list) {
			System.out.println(d);
		}
	}

}