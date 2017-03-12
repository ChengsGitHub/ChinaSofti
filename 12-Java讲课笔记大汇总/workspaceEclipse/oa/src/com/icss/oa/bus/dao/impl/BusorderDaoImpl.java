package com.icss.oa.bus.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.bus.dao.BusorderDao;
import com.icss.oa.bus.pojo.Busorder;
import com.icss.oa.common.Pager;


@Repository
public class BusorderDaoImpl implements BusorderDao{

	@Autowired
	private SqlSessionFactory factory;

	@Override	
	public void insert(Busorder busorder) {
		SqlSession session = factory.openSession();
		session.insert("BUSORDER.insert", busorder);
	}

	@Override
	public void update(Busorder busorder){
		SqlSession session = factory.openSession();
		session.update("BUSORDER.update", busorder);
	}

	@Override
	public void delete(Integer borderId){
		SqlSession session = factory.openSession();
		session.delete("BUSORDER.delete", borderId);
	}

	@Override
	public List<Map> query(Pager pager,Integer empId){
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("empId", empId);
		List<Map> list = session.selectList("BUSORDER.query",map);
		return list;
	}
	
	@Override
	public Busorder queryById(Integer borderId) {
		SqlSession session = factory.openSession();
		Busorder busorder = session.selectOne("BUSORDER.queryById",borderId);
		return busorder;
	}
	@Override
	public int getCount(Integer empId) {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("BUSORDER.getCount",empId);
		return count;
	}


}
