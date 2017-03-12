package com.icss.oa.meeting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.MeetingrecordDao;
import com.icss.oa.meeting.pojo.Meetingrecord;



@Service
@Transactional(rollbackFor = Exception.class)
public class MeetingrecordServiceImpl implements MeetingrecordService{

	@Autowired
	private MeetingrecordDao dao;

	public void insert(Meetingrecord meetingrecord) throws Exception{
		dao.insert(meetingrecord);
	}

	public void update(Meetingrecord meetingrecord) throws Exception{
		dao.update(meetingrecord);
	}
	
	public Meetingrecord queryById(Integer orderId) throws Exception {
		return dao.queryById(orderId);
	}

	public List<Meetingrecord> query(Pager pager) throws Exception  {
		return dao.query(pager);
	}
	
	
	public int getCount() throws Exception {
		return dao.getCount();
	}

	public void uploadFile(Meetingrecord meetingrecord) throws Exception{
		
		dao.uploadFile(meetingrecord);
	}
	
	public Meetingrecord download(Integer orderId) throws Exception{
		
		 Meetingrecord meetingrecord = dao.download(orderId);		
		return meetingrecord;
	}
	
	
}
