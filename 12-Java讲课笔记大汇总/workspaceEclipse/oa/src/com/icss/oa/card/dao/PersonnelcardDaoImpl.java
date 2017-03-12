package com.icss.oa.card.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.card.pojo.Personnelcard;

@Repository
public class PersonnelcardDaoImpl implements PersonnelcardDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Personnelcard personnelcard) {
		SqlSession session = factory.openSession();
		session.insert("PERSONNELCARD.insert", personnelcard);		
	}
	
	public void update(Personnelcard personnelcard) {
		SqlSession session = factory.openSession();
		session.update("PERSONNELCARD.update", personnelcard);
	}
	
	public void delete(Integer cardId) {
		SqlSession session = factory.openSession();
		session.delete("PERSONNELCARD.delete", cardId);
	}
	
	public Personnelcard queryById(Integer cardId) {
		SqlSession session = factory.openSession();
		Personnelcard personnelcard = session.selectOne("PERSONNELCARD.queryById",cardId);
		return personnelcard;
	}
	
	public List<Map<String,Object>> query(Pager pager,Integer groupId) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("groupId", groupId);
		List<Map<String,Object>> list = session.selectList("PERSONNELCARD.query",map);
		return list;
	}
	
	public int getCount(Integer groupId) {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("PERSONNELCARD.getCount",groupId);
		return count;
	}
	
	public Personnelcard queryByEmpID(Integer empId){
		SqlSession session = factory.openSession();
		Personnelcard personnelcard = session.selectOne("PERSONNELCARD.queryByEmpId",empId);
		return personnelcard;
	}
	
	public List<Map<String,Object>> query2(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Map<String,Object>> list = session.selectList("EMP.query2", map);
		return list;
	}
	
	public List<Personnelcard> queryByCondition(Pager pager,String cardName,Integer empId) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("cardName", cardName);
		map.put("empId", empId);
		List<Personnelcard> list = session.selectList("PERSONNELCARD.queryByCondition", map);
		return list;
	}
	
	public int getConditionCount(String cardName,Integer empId) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cardName", cardName);
		map.put("empId",empId);
		int count = session.selectOne("PERSONNELCARD.getConditionCount",map);
		return count;
	}
}