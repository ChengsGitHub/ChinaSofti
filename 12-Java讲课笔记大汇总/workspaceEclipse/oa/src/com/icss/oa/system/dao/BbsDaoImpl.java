package com.icss.oa.system.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Bbs;

@Repository
public class BbsDaoImpl implements BbsDao{
	
	@Autowired
	private SqlSessionFactory factory;

	public void insert(Bbs bbs) {
		SqlSession session = factory.openSession();
		session.insert("BBS.insert", bbs);		
	}
	public int getCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("BBS.getCount");
		return count;
	}
	public Bbs queryById(Integer bbsId) {
		SqlSession session = factory.openSession();
		Bbs bbs = session.selectOne("BBS.queryById",bbsId);
		return bbs;
	}
	
	public void delete(Integer bbsId) {
		SqlSession session = factory.openSession();
		session.delete("BBS.delete", bbsId);
	}
	public void update(Bbs bbs) {
		SqlSession session = factory.openSession();
		session.update("BBS.update", bbs);
	}
	public void setTop(Integer setTopId) {
		SqlSession session = factory.openSession();
		session.update("BBS.setTop", setTopId);
	}
	
	public void cancelTop(Integer setTopId) {
		SqlSession session = factory.openSession();
		session.update("BBS.cancelTop", setTopId);
	}

	public List<Bbs> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Bbs> list = session.selectList("BBS.query",map);
		return list;
	}
	public List<Bbs> queryByTime(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Bbs> list = session.selectList("BBS.queryByTime",map);
		return list;
	}
	
	public List<Bbs> queryByTime1(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Bbs> list = session.selectList("BBS.queryByTime1",map);
		return list;
	}
	public int getConditionCount(String bbsCont) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bbsCont", bbsCont);
		int count = session.selectOne("BBS.getConditionCount",map);
		return count;
	}
	public List<Bbs> queryByCondition(Pager pager,String bbsCont) {
		System.out.println(bbsCont+"...............");
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("bbsCont", bbsCont);
		
		List<Bbs> list = session.selectList("BBS.queryByCondition", map);
		return list;
	}
}
