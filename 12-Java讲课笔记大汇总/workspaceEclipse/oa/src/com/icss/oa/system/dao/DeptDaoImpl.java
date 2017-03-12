package com.icss.oa.system.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Dept;

@Repository
public class DeptDaoImpl implements DeptDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Dept dept) {
		SqlSession session = factory.openSession();
		session.insert("DEPT.insert", dept);		
	}
	
	public void update(Dept dept) {
		SqlSession session = factory.openSession();
		session.update("DEPT.update", dept);
	}
	
	public void delete(Integer deptId) {
		SqlSession session = factory.openSession();
		session.delete("DEPT.delete", deptId);
	}
	
	public Dept queryById(Integer deptId) {
		SqlSession session = factory.openSession();
		Dept dept = session.selectOne("DEPT.queryById",deptId);
		return dept;
	}

	public List<Dept> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Dept> list = session.selectList("DEPT.query",map);
		return list;
	}
	
	
	public int getCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("DEPT.getCount");
		return count;
	}
}