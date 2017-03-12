package com.icss.oa.meeting.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.MeetingrecordDao;
import com.icss.oa.meeting.pojo.Meetingrecord;


@Repository
public class MeetingrecordDaoImpl implements MeetingrecordDao{

	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Meetingrecord meetingrecord) {
		SqlSession session = factory.openSession();
		session.insert("MEETINGRECORD.insert", meetingrecord);
	}
	
	public Meetingrecord queryById(Integer orderId) {
		SqlSession session = factory.openSession();
		Meetingrecord meetingrecord = session.selectOne("MEETINGRECORD.queryById",orderId);
		return meetingrecord;
	}

	public List<Meetingrecord> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Meetingrecord> list = session.selectList("MEETINGRECORD.query",map);
		return list;
	}
	
	public int getCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("MEETINGRECORD.getCount");
		return count;
	}

	@Override
	public void update(Meetingrecord meetingrecord) throws Exception {
		SqlSession session = factory.openSession();
		session.update("MEETINGRECORD.update", meetingrecord);
	}
	
	public void uploadFile(Meetingrecord meetingrecord) throws Exception{
		SqlSession session = factory.openSession();
		session.update("MEETINGRECORD.uploadFile", meetingrecord);
	}
	
	public Meetingrecord download(Integer orderId) throws Exception{
		SqlSession session = factory.openSession();
		Meetingrecord meetingrecord = session.selectOne("MEETINGRECORD.download", orderId);
		return meetingrecord;
	 }
	
}
