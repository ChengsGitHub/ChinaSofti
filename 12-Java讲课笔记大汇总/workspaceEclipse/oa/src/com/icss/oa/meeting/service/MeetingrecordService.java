package com.icss.oa.meeting.service;

import java.util.List;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.pojo.Meetingrecord;


public interface MeetingrecordService {



	void insert(Meetingrecord meetingrecord) throws Exception ;
	
	void update(Meetingrecord meetingrecord) throws Exception;
	
	Meetingrecord queryById(Integer orderId) throws Exception;
	
	List<Meetingrecord> query(Pager pager) throws Exception;
	
	
	int getCount() throws Exception;

	void uploadFile(Meetingrecord meetingrecord) throws Exception;
	
	Meetingrecord download(Integer orderId) throws Exception;
	
	
}
