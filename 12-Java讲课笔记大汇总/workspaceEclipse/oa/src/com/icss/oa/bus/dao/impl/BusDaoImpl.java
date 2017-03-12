package com.icss.oa.bus.dao.impl;

import java.util.HashMap;
import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.bus.dao.BusDao;
import com.icss.oa.bus.pojo.Bus;
import com.icss.oa.common.Pager;

@Repository
public class BusDaoImpl implements BusDao{

	@Autowired
	private SqlSessionFactory factory;
	
	@Override
	public void insert(Bus bus) throws Exception {
		
		SqlSession session = factory.openSession();
		session.insert("BUS.insert", bus);
		
	}

	@Override
	public void update(Bus bus) throws Exception {
		
		SqlSession session = factory.openSession();
		session.update("BUS.update", bus);
		
	}

	@Override
	public void delete(Integer busId) throws Exception {
		
		SqlSession session = factory.openSession();
		session.delete("BUS.delete", busId);
		
	}

	@Override
	public Bus queryById(Integer busId) throws Exception {
		
		SqlSession session = factory.openSession();
		Bus bus = session.selectOne("BUS.queryById",busId);
		return bus;
		
	}
	@Override
	public List<Bus> queryByBusId(Integer busId) {
		SqlSession session = factory.openSession();
		List<Bus> list = session.selectList("BUS.queryByBusId", busId);		
		return list;
	}
	@Override
	public List<Bus> query(Pager pager) throws Exception {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Bus> list = session.selectList("BUS.query",map);
		return list;
	}

	@Override
	public Bus queryByBusType(String busType) throws Exception {
		SqlSession session = factory.openSession();
		Bus bus = session.selectOne("BUS.queryByRoomName", busType);
		return bus;
	}

	@Override
	public int getCount() throws Exception {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("BUS.getCount");
		return count;
	}

	@Override
	public List<Bus> queryByCondition(Pager pager, String busType)
			throws Exception {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("busType", busType);
		List<Bus> list = session.selectList("BUS.queryByCondition", map);
		return list;
	}

	@Override
	public int getConditionCount(String busType) throws Exception {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("busType", busType);
		int count = session.selectOne("BUS.getConditionCount",map);
		return count;
	}

	@Override
	public int getPrimaryKey() throws Exception {
		SqlSession session = factory.openSession();
		int primaryKey = session.selectOne("BUS.getPrimaryKey");
		return primaryKey;
	}

}
