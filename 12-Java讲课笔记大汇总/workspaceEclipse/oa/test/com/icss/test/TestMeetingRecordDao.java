package com.icss.test;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.meeting.dao.MeetingrecordDao;
import com.icss.oa.meeting.pojo.Meetingrecord;


public class TestMeetingRecordDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private MeetingrecordDao dao = (MeetingrecordDao) context.getBean(MeetingrecordDao.class);
	
	
	
	@Test
	public void testDownload() throws Exception {
		Meetingrecord record =  dao.download(63);
		System.out.println(record);
	}
	
}