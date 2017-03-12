package com.icss.oa.asserts.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.asserts.pojo.Offsup;

@Repository
public class OffsupDaoImpl implements  OffsupDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Offsup offsup) {
		SqlSession session = factory.openSession();
		session.insert("OFFSUP.insert", offsup);		
	}
	
	public void update(Offsup offsup) {
		SqlSession session = factory.openSession();
		session.update("OFFSUP.update", offsup);
	}
	
	public void delete(Integer id) {
		SqlSession session = factory.openSession();
		session.delete("OFFSUP.delete", id);
	}
	
	public Offsup queryById(Integer id) {
		SqlSession session = factory.openSession();
		Offsup offsup = session.selectOne("OFFSUP.queryById",id);
		return offsup;
	}

	public List<Offsup> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Offsup> list = session.selectList("OFFSUP.query",map);
		return list;
	}
	
	public int getContentCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("OFFSUP.getContentCount");
		return count;
	}
}