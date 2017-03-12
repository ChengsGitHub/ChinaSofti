package com.icss.oa.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.bus.dao.BusrecordDao;
import com.icss.oa.bus.pojo.Busrecord;
import com.icss.oa.common.Pager;



@Service
@Transactional(rollbackFor = Exception.class)
public class BusrecordService{

	@Autowired
	private BusrecordDao dao;

	public void insert(Busrecord busrecord) throws Exception{
		dao.insert(busrecord);
	}

	public void update(Busrecord busrecord) throws Exception {
		
		dao.update(busrecord);
		
	}

	public void delete(Integer brecordId) throws Exception  {
		dao.delete(brecordId);
	}

	public List<Busrecord> query(Pager pager) throws Exception  {
		return dao.query(pager);
	}
	
	public Busrecord queryById(Integer brecordId) throws Exception {
		return dao.queryById(brecordId);
	}

	public int getCount() throws Exception {
		return dao.getCount();
	}
	
}
