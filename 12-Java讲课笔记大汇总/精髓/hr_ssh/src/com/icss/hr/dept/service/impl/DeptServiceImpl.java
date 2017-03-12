package com.icss.hr.dept.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.service.DeptService;
import com.icss.hr.dept.vo.DeptVo;

/**
 * DEPT SERVICE µœ÷¿‡
 * 
 * @author Administrator
 * 
 */
@Transactional(rollbackFor=Exception.class)
public class DeptServiceImpl implements DeptService {

	private DeptDao dao;

	public void setDao(DeptDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(DeptVo vo) {
		Dept dept = new Dept(vo.getDeptId(), vo.getDeptName(), vo.getDeptLoc());
		dao.add(dept);
	}

	@Override
	public void update(DeptVo vo) {
		Dept dept = new Dept(vo.getDeptId(), vo.getDeptName(), vo.getDeptLoc());
		dao.update(dept);		
	}

	@Override
	public void delete(int deptId) {
		dao.delete(deptId);
	}

	@Override
	public List<Dept> query() {
		return dao.query();
	}

	@Override
	public Dept queryById(int deptId) {

		return dao.queryById(deptId);
	}

}