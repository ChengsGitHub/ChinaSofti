package com.icss.oa.meeting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.MeetingroomDao;
import com.icss.oa.meeting.pojo.Meetingroom;



@Service
@Transactional(rollbackFor = Exception.class)
public class MeetingroomServiceImpl implements MeetingroomService{

	@Autowired
	private MeetingroomDao dao;

	public void insert(Meetingroom meetingroom) throws Exception{
		dao.insert(meetingroom);
	}

	public void update(Meetingroom meetingroom) throws Exception {
		dao.update(meetingroom);
	}

	public void delete(Integer roomId) throws Exception  {
		dao.delete(roomId);
	}

	public Meetingroom queryById(Integer roomId) throws Exception {
		return dao.queryById(roomId);
	}

	public List<Meetingroom> query(Pager pager) throws Exception  {
		return dao.query(pager);
	}
	
	public List<Meetingroom> querByCondition(Pager pager, String roomName) throws Exception {

		return dao.queryByCondition(pager, roomName);
	}

	public int getCount() throws Exception {
		return dao.getCount();
	}
	
	public int getConditionCount(String roomName) throws Exception {

		return dao.getConditionCount(roomName);
	}

}
