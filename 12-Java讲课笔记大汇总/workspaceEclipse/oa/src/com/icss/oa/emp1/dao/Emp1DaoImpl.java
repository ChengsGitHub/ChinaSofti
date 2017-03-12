package com.icss.oa.emp1.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.emp1.pojo.Emp1;

@Repository
public class Emp1DaoImpl implements Emp1Dao{

	@Autowired
	private SqlSessionFactory factory;


	public void update(Emp1 emp1) {
		SqlSession session = factory.openSession();
		session.update("EMP1.update", emp1);
	}


	public Emp1 queryById(Integer emp1Id) {
		SqlSession session = factory.openSession();
		Emp1 emp1 = session.selectOne("EMP1.queryById", emp1Id);
		return emp1;
	}
	
	
	public List<Emp1> queryByName(String emp1Name) {
		SqlSession session = factory.openSession();
		List<Emp1> list = session.selectList("EMP1.queryByName", emp1Name);
		return  list;
	}

	
	public List<Map<String,Object>> queryByOther(String emp1Name,Integer deptID,Integer jobID) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("emp1Name",emp1Name );
		map.put("deptId",deptID );
		map.put("jobId",jobID );
		List<Map<String,Object>> list = session.selectList("EMP1.queryByOther", map);
		return list;
	}
	
	public List<Emp1> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Emp1> list = session.selectList("EMP1.query", map);
		return list;
	}

	public int getCount() {
		SqlSession session = factory.openSession();
		int count = session.selectOne("EMP1.getCount");
		return count;
	}
	
	public List<Map<String,Object>> query2(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Map<String,Object>> list = session.selectList("EMP1.query2", map);
		return list;
	}
	
	
	/**
	 * 根据用户名查询员工数据
	 * @param username
	 * @return
	 */
	public Emp1 queryByUsername(String username) {
		SqlSession session = factory.openSession();
		Emp1 emp1 = session.selectOne("EMP1.queryByUsername", username);
		return emp1;		
	}
}