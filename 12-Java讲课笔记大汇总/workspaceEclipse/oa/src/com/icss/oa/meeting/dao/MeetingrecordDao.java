package com.icss.oa.meeting.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.pojo.Meetingrecord;


@Repository
public interface MeetingrecordDao {
	@Autowired
	
	void insert(Meetingrecord meetingrecord) throws Exception;
	void update(Meetingrecord meetingrecord) throws Exception;
	
	Meetingrecord queryById(Integer orderId) throws Exception;
	
	List<Meetingrecord> query(Pager pager) throws Exception;

	int getCount() throws Exception;
	
	 void uploadFile(Meetingrecord meetingrecord) throws Exception;
	
	 Meetingrecord download(Integer orderId) throws Exception;
}
