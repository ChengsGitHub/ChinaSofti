package com.icss.oa.meeting.dao;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.pojo.Meetingorder;


@Repository
public interface MeetingorderDao {
	@Autowired
	
	void insert(Meetingorder meetingorder) throws Exception;
	void update(Meetingorder meetingorder) throws Exception;
	
	Meetingorder queryById(Integer orderId) throws Exception;
	void delete(Integer orderId) throws Exception;
	List<Map> query(Pager pager,Integer empId) throws Exception;
	List<Map> querymeeting(Pager pager,Integer empId) throws Exception;
	 int getMeetingCount(Integer empId);
	int getCount(Integer empId) ;

}
