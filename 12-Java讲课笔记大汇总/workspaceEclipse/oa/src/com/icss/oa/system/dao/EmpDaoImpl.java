package com.icss.oa.system.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.system.pojo.Emp;

@Repository
public class EmpDaoImpl implements EmpDao{

	@Autowired
	private SqlSessionFactory factory;

	public void insert(Emp emp) {
		SqlSession session = factory.openSession();
		session.insert("EMP.insert", emp);
	}

	public void update(Emp emp) {
		SqlSession session = factory.openSession();
		session.update("EMP.update", emp);
	}

	public void delete(Integer empId) {
		SqlSession session = factory.openSession();
		session.delete("EMP.delete", empId);
	}

	public Emp queryById(Integer empId) {
		SqlSession session = factory.openSession();
		Emp emp = session.selectOne("EMP.queryById", empId);
		return emp;
	}
	
	

	public List<Emp> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Emp> list = session.selectList("EMP.query", map);
		return list;
	}

	public int getCount() {
		SqlSession session = factory.openSession();
		int count = session.selectOne("EMP.getCount");
		return count;
	}
	
	public List<Map<String,Object>> query2(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Map<String,Object>> list = session.selectList("EMP.query2", map);
		return list;
	}
	public void insertUserRole(Map<String,Integer> map) {
		SqlSession session = factory.openSession();
		session.insert("EMP.insertUserRole", map);
	}
	public void deleteRole(Integer ur) {
		SqlSession session = factory.openSession();
		session.delete("EMP.deleteRole", ur);
	}
	
	
	public List<Map<String,Object>> queryRole(Integer empId) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("empId",empId );
		List<Map<String,Object>> list = session.selectList("EMP.queryRole", map);
		return list;
	}
	
	public int getPrimaryKey() {
		SqlSession session = factory.openSession();
		int primaryKey = session.selectOne("EMP.getPrimaryKey");
		return primaryKey;
	}
}