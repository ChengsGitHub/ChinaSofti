package com.icss.oa.meeting.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.pojo.Meetingroom;

@Repository
public interface MeetingroomDao {
	@Autowired
	
	void insert(Meetingroom meetingroom) throws Exception;
	
	void update(Meetingroom meetingroom) throws Exception;
	
	void delete(Integer roomId) throws Exception;
	
	Meetingroom queryById(Integer deptId) throws Exception;
	
	List<Meetingroom> query(Pager pager) throws Exception;
	
	 Meetingroom queryByRoomName(String roomName)throws Exception ;
	int getCount() throws Exception;
	
	 List<Meetingroom> queryByCondition(Pager pager,String roomName)throws Exception ;
	
	
	 int getConditionCount(String roomName)throws Exception; 
	
	public int getPrimaryKey()throws Exception ;
}
