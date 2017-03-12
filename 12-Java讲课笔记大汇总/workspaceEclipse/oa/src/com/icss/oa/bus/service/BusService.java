package com.icss.oa.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.bus.dao.BusDao;
import com.icss.oa.bus.pojo.Bus;
import com.icss.oa.bus.service.BusService;
import com.icss.oa.common.Pager;


@Service
@Transactional(rollbackFor = Exception.class)
public class BusService{

	@Autowired
	private BusDao dao;
	
	
	public void insert(Bus bus) throws Exception {
		dao.insert(bus);
	}

	
	public void update(Bus bus) throws Exception {
		dao.update(bus);
	}

	
	public void delete(Integer busId) throws Exception {
		dao.delete(busId);
	}

	
	public Bus queryById(Integer busId) throws Exception {
		
		return dao.queryById(busId);
	}

	public List<Bus> queryByBusId(Integer busId) {
		return dao.queryByBusId(busId);
	}
	public List<Bus> query(Pager pager) throws Exception {
		
		return dao.query(pager);
	}

	
	public List<Bus> querByCondition(Pager pager, String busType)
			throws Exception {
		
		return dao.queryByCondition(pager, busType);
	}


	public int getCount() throws Exception {
		
		return dao.getCount();
	}

	
	public int getConditionCount(String busType) throws Exception {
		
		return dao.getConditionCount(busType);
	}

}
