package com.icss.oa.meeting.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.MeetingorderDao;
import com.icss.oa.meeting.pojo.Meetingorder;


@Repository
public class MeetingorderDaoImpl implements MeetingorderDao{

	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Meetingorder meetingorder) {
		SqlSession session = factory.openSession();
		session.insert("MEETINGORDER.insert", meetingorder);
	}
	
	public Meetingorder queryById(Integer orderId) {
		SqlSession session = factory.openSession();
		Meetingorder meetingorder = session.selectOne("MEETINGORDER.queryById",orderId);
		return meetingorder;
	}
	public void delete(Integer orderId) {
		SqlSession session = factory.openSession();
		session.delete("MEETINGORDER.delete", orderId);
	}

	public List<Map> query(Pager pager,Integer empId) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("empId",empId);
		List<Map> list = session.selectList("MEETINGORDER.query",map);
		return list;
	}
	public List<Map> querymeeting(Pager pager,Integer empId) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("empId",empId);
		List<Map> list = session.selectList("MEETINGORDER.querymeeting",map);
		return list;
	}
	
//	public int getCount() {
//		SqlSession session = factory.openSession();
//		int count =  session.selectOne("MEETINGORDER.getCount");
//		return count;
//	}
	
	public int getCount(Integer empId) {
		SqlSession session = factory.openSession();
		 
		return  session.selectOne("MEETINGORDER.getCount", empId);
	}

	public int getMeetingCount(Integer empId) {
		SqlSession session = factory.openSession();
		return  session.selectOne("MEETINGORDER.getMeetingCount", empId);
	}
	@Override
	public void update(Meetingorder meetingorder) throws Exception {
		SqlSession session = factory.openSession();
		session.update("MEETINGORDER.update", meetingorder);
	}
	
}
