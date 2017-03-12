package com.icss.oa.assign.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.assign.dao.AssigncomDao;
import com.icss.oa.assign.pojo.Assigncom;

@Service
@Transactional(rollbackFor = Exception.class)
public class AssigncomServiceImpl implements AssigncomService{                 

	@Autowired
	private AssigncomDao dao;

	public void insert(Assigncom assigncom) {
		dao.insert(assigncom);
	}

	public void update(Assigncom assigncom) {
		dao.update(assigncom);
	}

	public void delete(Integer assigncomId) {
		dao.delete(assigncomId);
	}

	public Assigncom queryById(Integer assigncomId) {

		return dao.queryById(assigncomId);
	}

	public List<Assigncom> query(Pager pager) {

		return dao.query(pager);
	}

	public int getCount() {

		return dao.getCount();
	}
	
}