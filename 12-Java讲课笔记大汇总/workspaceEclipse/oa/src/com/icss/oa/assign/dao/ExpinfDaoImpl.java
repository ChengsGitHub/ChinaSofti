package com.icss.oa.assign.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.assign.pojo.Expinf;

@Repository
public class ExpinfDaoImpl implements ExpinfDao{

	@Autowired
	private SqlSessionFactory factory;

	public void insert(Expinf expinf) {
		SqlSession session = factory.openSession();
		session.insert("EXPINF.insert", expinf);
	}

	public void update(Expinf expinf) {
		SqlSession session = factory.openSession();
		session.update("EXPINF.update", expinf);
	}

	public void delete(Integer expinfId) {
		SqlSession session = factory.openSession();  
		session.delete("EXPINF.delete", expinfId);
	}

	public Expinf queryById(Integer expinfId) {
		SqlSession session = factory.openSession();
		Expinf expinf = session.selectOne("EXPINF.queryById", expinfId);
		return expinf;
	}

	public List<Expinf> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Expinf> list = session.selectList("EXPINF.query", map);
		return list;
	}

	public int getCount() {
		SqlSession session = factory.openSession();
		int count = session.selectOne("EXPINF.getCount");
		return count;
	}
	
	public List<Map<String,Object>> query2(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Map<String,Object>> list = session.selectList("EXPINF.query2", map);
		return list;
	}
	
	/**
	 * 根据用户名查询员工数据
	 * @param username
	 * @return
	 */
	public Expinf queryByUsername(String username) {
		SqlSession session = factory.openSession();
		Expinf expinf = session.selectOne("EXPINF.queryByUsername", username);
		return expinf;		
	}
	
	/**
	 * 根据检索条件查询
	 * @param pager
	 * @return
	 */
	public List<Expinf> queryByCondition(Pager pager,String expinfName) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("expinfName", expinfName);
		List<Expinf> list = session.selectList("EXPINF.queryByCondition", map);
		return list;
	}
	
	/**
	 * 返回满足条件的总记录数
	 * @return
	 */
	public int getConditionCount(String expinfName) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("expinfName", expinfName);
		int count = session.selectOne("EXPINF.getConditionCount",map);
		return count;
	}
	
	public int getPrimaryKey() {
		SqlSession session = factory.openSession();
		int primaryKey = session.selectOne("EXPINF.getPrimaryKey");
		return primaryKey;
	}

	public void uploadImg(Expinf expinf) {
		SqlSession session = factory.openSession();
		session.update("EXPINF.uploadImg", expinf);
	}
	
	public Expinf download(Integer expinfId) {
		SqlSession session = factory.openSession();
		Expinf expinf = session.selectOne("EXPINF.download", expinfId);
		return expinf;
	}
}