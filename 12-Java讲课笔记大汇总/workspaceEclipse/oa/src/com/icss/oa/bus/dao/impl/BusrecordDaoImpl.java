package com.icss.oa.bus.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.bus.dao.BusrecordDao;
import com.icss.oa.bus.pojo.Busrecord;
import com.icss.oa.common.Pager;


@Repository
public class BusrecordDaoImpl implements BusrecordDao{

	@Autowired
	private SqlSessionFactory factory;

	@Override	
	public void insert(Busrecord busrecord) {
		SqlSession session = factory.openSession();
		session.insert("BUSRECORD.insert", busrecord);
	}

	@Override
	public void update(Busrecord busrecord){
		SqlSession session = factory.openSession();
		session.update("BUSRECORD.update", busrecord);
		
	}

	@Override
	public void delete(Integer brecordId){
		SqlSession session = factory.openSession();
		session.delete("BUSRECORD.delete", brecordId);
	}

	@Override
	public List<Busrecord> query(Pager pager){
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Busrecord> list = session.selectList("BUSRECORD.query",map);
		return list;
	}
	
	@Override
	public Busrecord queryById(Integer brecordId) {
		SqlSession session = factory.openSession();
		Busrecord busrecord = session.selectOne("BUSRECORD.queryById",brecordId);
		return busrecord;
	}
	@Override
	public int getCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("BUSRECORD.getCount");
		return count;
	}


}
