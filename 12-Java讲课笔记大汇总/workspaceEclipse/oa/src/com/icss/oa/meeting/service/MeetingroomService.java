package com.icss.oa.meeting.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.pojo.Meetingroom;


public interface MeetingroomService {

	public void insert(Meetingroom meetingroom) throws Exception;

	public void update(Meetingroom meetingroom) throws Exception;

	public void delete(Integer roomId) throws Exception;

	public Meetingroom queryById(Integer roomId) throws Exception;

	public List<Meetingroom> query(Pager pager) throws Exception;
	
	public List<Meetingroom> querByCondition(Pager pager, String roomName) throws Exception;

	public int getCount() throws Exception;
	
	public int getConditionCount(String roomName) throws Exception;

}
