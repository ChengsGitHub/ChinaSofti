package com.icss.oa.assign.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.assign.pojo.Exphistory;

@Repository
public class ExphistoryDaoImpl implements ExphistoryDao {

	@Autowired
	private SqlSessionFactory factory;

	public void insert(Exphistory exphistory) {
		SqlSession session = factory.openSession();
		session.insert("EXPHISTORY.insert", exphistory);
	}

	public void update(Exphistory exphistory) {
		SqlSession session = factory.openSession();
		session.update("EXPHISTORY.update", exphistory);
	}

	public void delete(Integer exphistoryId2) {
		SqlSession session = factory.openSession();
		session.delete("EXPHISTORY.delete", exphistoryId2);
	}

	public Exphistory queryById(Integer exphistoryId1) {
		SqlSession session = factory.openSession();
		Exphistory exphistory = session.selectOne("EXPHISTORY.queryById", exphistoryId1);
		return exphistory;
	}

	public List<Exphistory> query(Integer expinfId) {
		SqlSession session = factory.openSession();				
		List<Exphistory> list = session.selectList("EXPHISTORY.query", expinfId);
		return list;
	}

	public int getCount() {
		SqlSession session = factory.openSession();
		int count = session.selectOne("EXPHISTORY.getCount");
		return count;
	}
	
}