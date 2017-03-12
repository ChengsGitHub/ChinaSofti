package com.icss.oa.meeting.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.MeetingroomDao;
import com.icss.oa.meeting.pojo.Meetingroom;


@Repository
public class MeetingroomDaoImpl implements MeetingroomDao{

	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Meetingroom meetingroom) {
		SqlSession session = factory.openSession();
		session.insert("MEETINGROOM.insert", meetingroom);
	}
	
	public void update(Meetingroom meetingroom) {
		SqlSession session = factory.openSession();
		session.update("MEETINGROOM.update", meetingroom);
	}
	
	public void delete(Integer roomId) {
		SqlSession session = factory.openSession();
		session.delete("MEETINGROOM.delete", roomId);
	}
	
	public Meetingroom queryById(Integer roomId) {
		SqlSession session = factory.openSession();
		Meetingroom meetingroom = session.selectOne("MEETINGROOM.queryById",roomId);
		return meetingroom;
	}

	public List<Meetingroom> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Meetingroom> list = session.selectList("MEETINGROOM.query",map);
		return list;
	}
	
	public Meetingroom queryByRoomName(String roomName) {
		SqlSession session = factory.openSession();
		Meetingroom meetingroom = session.selectOne("MEETINGROOM.queryByRoomName", roomName);
		return meetingroom;		
	}
	
	public int getCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("MEETINGROOM.getCount");
		return count;
	}
	
	public List<Meetingroom> queryByCondition(Pager pager,String roomName) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("roomName", roomName);
		List<Meetingroom> list = session.selectList("MEETINGROOM.queryByCondition", map);
		return list;
	}
	
	
	public int getConditionCount(String roomName) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("roomName", roomName);
		int count = session.selectOne("MEETINGROOM.getConditionCount",map);
		return count;
	}
	
	public int getPrimaryKey() {
		SqlSession session = factory.openSession();
		int primaryKey = session.selectOne("MEETINGROOM.getPrimaryKey");
		return primaryKey;
	}
}
