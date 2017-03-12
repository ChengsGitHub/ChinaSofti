package com.icss.oa.work.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.work.dao.ReadschDao;
import com.icss.oa.work.pojo.Readsch;

@Service
@Transactional(rollbackFor = Exception.class)
public class ReadschService {

	@Autowired
	private ReadschDao dao;


	public void insert(Readsch readsch) throws IOException {

		dao.insert(readsch);
	}

	public void update(Readsch readsch) throws IOException {
		dao.update(readsch);
	}

	public void delete(Integer readschId) throws IOException {
		dao.delete(readschId);
	}

	public Readsch queryById(Integer readschId) {

		return dao.queryById(readschId);
	}

	public List<Map> query(Pager pager,Integer empId) {

		return dao.query(pager,empId);
	}
	
	public List<Map> query2(Pager pager,Integer empId) {

		return dao.query2(pager,empId);
	}

	public List<Readsch> querByCondition(Pager pager, String readschName) {

		return dao.queryByCondition(pager, readschName);
	}

	public int getCount(Integer empId) {

		return dao.getCount(empId);
	}

	public int getOtherCount(Integer empId) {

		return dao.getOtherCount(empId);
	}
	public int getConditionCount(String readschName) {

		return dao.getConditionCount(readschName);
	}
	
}