package com.icss.oa.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.DeptDao;
import com.icss.oa.system.dao.DeptDaoImpl;
import com.icss.oa.system.pojo.Dept;

@Service
@Transactional(rollbackFor = Exception.class)
public class DeptServiceImpl 	implements DeptService{

	@Autowired
	private DeptDao dao;

	public void insert(Dept dept) {
		dao.insert(dept);
	}

	public void update(Dept dept) {
		dao.update(dept);
	}

	public void delete(Integer deptId) {
		dao.delete(deptId);
	}

	public Dept queryById(Integer deptId) {

		return dao.queryById(deptId);
	}

	public List<Dept> query(Pager pager) {

		return dao.query(pager);
	}

	public int getCount() {

		return dao.getCount();
	}

}
