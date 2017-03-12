package com.icss.oa.meeting.service;

import java.util.List;
import java.util.Map;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.pojo.Meetingorder;




public interface MeetingorderService {
	
	public void insert(Meetingorder meetingorder) throws Exception;

	public void update(Meetingorder meetingorder) throws Exception;
	
	public Meetingorder queryById(Integer orderId) throws Exception;
	
	public void delete(Integer orderId) throws Exception;
	
	public List<Map> query(Pager pager,Integer empId) throws Exception ;
	
	public List<Map> querymeeting(Pager pager,Integer empId) throws Exception ;
	int getMeetingCount(Integer empId) throws Exception;
	public int getCount(Integer empId) throws Exception;

	
	
}
