package com.icss.oa.meeting.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.MeetingorderDao;
import com.icss.oa.meeting.pojo.Meetingorder;



@Service
@Transactional(rollbackFor = Exception.class)
public class MeetingorderServiceImpl implements MeetingorderService{

	@Autowired
	private MeetingorderDao dao;

	public void insert(Meetingorder meetingorder) throws Exception{
		dao.insert(meetingorder);
	}

	public void update(Meetingorder meetingorder) throws Exception{
		dao.update(meetingorder);
	}
	
	public Meetingorder queryById(Integer orderId) throws Exception {
		return dao.queryById(orderId);
	}
	public void delete(Integer orderId) throws Exception  {
		dao.delete(orderId);
	}
	public List<Map> query(Pager pager,Integer empId) throws Exception  {
		return dao.query(pager,empId);
	}
	
	public List<Map> querymeeting(Pager pager,Integer empId) throws Exception  {
		return dao.querymeeting(pager,empId);
	}

	public int getCount(Integer empId) throws Exception {
		return dao.getCount(empId);
	}

	public int getMeetingCount(Integer empId) throws Exception {
		return dao.getMeetingCount(empId);
	}
	
}
