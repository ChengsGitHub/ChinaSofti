package com.icss.oa.work.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.work.pojo.Readsch;

@Repository
public class ReadschDaoImpl implements ReadschDao {

	@Autowired
	private SqlSessionFactory factory;

	public void insert(Readsch readsch) {
		SqlSession session = factory.openSession();
		session.insert("READSCH.insert", readsch);
	}

	public void update(Readsch readsch) {
		SqlSession session = factory.openSession();
		session.update("READSCH.update", readsch);
	}

	public void delete(Integer readschId) {
		SqlSession session = factory.openSession();  
		session.delete("READSCH.delete", readschId);
	}

	public Readsch queryById(Integer readschId) {
		SqlSession session = factory.openSession();
		Readsch readsch = session.selectOne("READSCH.queryById", readschId);
		return readsch;
	}

	public List<Map> query(Pager pager,Integer empId) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);		
		map.put("empId", empId);
		List<Map> list = session.selectList("READSCH.query", map);
		return list;
	}

	public int getCount(Integer empId) {
		SqlSession session = factory.openSession();
		int count = session.selectOne("READSCH.getCount",empId);
		return count;
	}
	
	public int getOtherCount(Integer empId) {
		SqlSession session = factory.openSession();
		int count = session.selectOne("READSCH.getOtherCount",empId);
		return count;
	}
	
	public List<Map> query2(Pager pager,Integer empId) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("empId", empId);
		List<Map> list = session.selectList("READSCH.query2", map);
		return list;
	}
	
	/**
	 * 根据用户名查询员工数据
	 * @param username
	 * @return
	 */
	public Readsch queryByUsername(String username) {
		SqlSession session = factory.openSession();
		Readsch readsch = session.selectOne("READSCH.queryByUsername", username);
		return readsch;		
	}
	
	/**
	 * 根据检索条件查询
	 * @param pager
	 * @return
	 */
	public List<Readsch> queryByCondition(Pager pager,String readschName) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("readschName", readschName);
		List<Readsch> list = session.selectList("READSCH.queryByCondition", map);
		return list;
	}
	
	/**
	 * 返回满足条件的总记录数
	 * @return
	 */
	public int getConditionCount(String readschName) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("readschName", readschName);
		int count = session.selectOne("READSCH.getConditionCount",map);
		return count;
	}
	
	public int getPrimaryKey() {
		SqlSession session = factory.openSession();
		int primaryKey = session.selectOne("READSCH.getPrimaryKey");
		return primaryKey;
	}

}