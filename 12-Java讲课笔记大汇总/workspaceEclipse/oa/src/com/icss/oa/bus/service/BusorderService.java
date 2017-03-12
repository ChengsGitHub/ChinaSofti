package com.icss.oa.bus.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.bus.dao.BusorderDao;
import com.icss.oa.bus.pojo.Busorder;
import com.icss.oa.common.Pager;



@Service
@Transactional(rollbackFor = Exception.class)
public class BusorderService{

	@Autowired
	private BusorderDao dao;

	public void insert(Busorder busorder) throws Exception{
		dao.insert(busorder);
	}

	public void update(Busorder busorder) throws Exception {
		dao.update(busorder);
	}

	public void delete(Integer borderId) throws Exception  {
		dao.delete(borderId);
	}

	public List<Map> query(Pager pager,Integer empId) throws Exception  {
		return dao.query(pager,empId);
	}
	
	public Busorder queryById(Integer borderId) throws Exception {
		return dao.queryById(borderId);
	}

	public int getCount(Integer empId) throws Exception {
		return dao.getCount(empId);
	}
	
}
