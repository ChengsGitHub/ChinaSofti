package com.icss.oa.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.EmpDao;
import com.icss.oa.system.dao.EmpDaoImpl;
import com.icss.oa.system.pojo.Emp;

@Service
@Transactional(rollbackFor = Exception.class)
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDao dao;

	public void insert(Emp emp) {
		dao.insert(emp);
	}
	public void insertUserRole(Map<String,Integer> map) {
		dao.insertUserRole(map);
	}

	public void update(Emp emp) {
		dao.update(emp);
	}

	public void delete(Integer empId) {
		dao.delete(empId);
	}

	public Emp queryById(Integer empId) {

		return dao.queryById(empId);
	}

	public List<Emp> query(Pager pager) {

		return dao.query(pager);
	}

	public int getCount() {

		return dao.getCount();
	}
	
	public List<Map<String,Object>> query2(Pager pager) {
		return dao.query2(pager);
	}
	public List<Map<String,Object>> queryRole(Integer empId) {
		return dao.queryRole(empId);
	}
	public void deleteRole(Integer ur) {
		dao.deleteRole(ur);
	}
	@Override
	public int getPrimaryKey() {
		int primaryKey = dao.getPrimaryKey();
		return primaryKey;
	}
	
}