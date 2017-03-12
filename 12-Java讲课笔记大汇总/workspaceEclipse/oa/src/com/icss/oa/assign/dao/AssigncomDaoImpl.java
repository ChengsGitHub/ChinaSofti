package com.icss.oa.assign.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.assign.pojo.Assigncom;

@Repository
public class AssigncomDaoImpl implements AssigncomDao {

	@Autowired
	private SqlSessionFactory factory;

	public void insert(Assigncom assigncom) {
		SqlSession session = factory.openSession();
		session.insert("ASSIGNCOM.insert", assigncom);
	}

	public void update(Assigncom assigncom) {
		SqlSession session = factory.openSession();
		session.update("ASSIGNCOM.update", assigncom);
	}

	public void delete(Integer assigncomId) {
		SqlSession session = factory.openSession();
		session.delete("ASSIGNCOM.delete", assigncomId);
	}

	public Assigncom queryById(Integer assigncomId) {
		SqlSession session = factory.openSession();
		Assigncom assigncom = session.selectOne("ASSIGNCOM.queryById", assigncomId);
		return assigncom;
	}

	public List<Assigncom> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Assigncom> list = session.selectList("ASSIGNCOM.query", map);
		return list;
	}

	public int getCount() {
		SqlSession session = factory.openSession();
		int count = session.selectOne("ASSIGNCOM.getCount");
		return count;
	}
	
}