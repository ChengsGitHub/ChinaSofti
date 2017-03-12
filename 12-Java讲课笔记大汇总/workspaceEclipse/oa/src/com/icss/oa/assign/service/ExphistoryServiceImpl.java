package com.icss.oa.assign.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.assign.dao.ExphistoryDao;
import com.icss.oa.assign.pojo.Exphistory;

@Service
@Transactional(rollbackFor = Exception.class)
public class ExphistoryServiceImpl implements ExphistoryService{                 

	@Autowired
	private ExphistoryDao dao;

	public void insert(Exphistory exphistory) {
		dao.insert(exphistory);
	}

	public void update(Exphistory exphistory) {
		dao.update(exphistory);
	}

	public void delete(Integer exphistoryId2) {
		dao.delete(exphistoryId2);
	}

	public Exphistory queryById(Integer exphistoryId1) {

		return dao.queryById(exphistoryId1);
	}

	public List<Exphistory> query(Integer expinfId) {

		return dao.query(expinfId);
	}

	public int getCount() {

		return dao.getCount();
	}
	
}