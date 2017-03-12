package com.icss.test;



import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.MeetingorderDao;
import com.icss.oa.meeting.pojo.Meetingorder;



public class TestMeetingorderDaoImpl {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private MeetingorderDao dao = (MeetingorderDao) context.getBean(MeetingorderDao.class);
	
	@Test
	public void testInsert() throws Exception {
		Meetingorder meetingorder = new Meetingorder("xxx",11,12,"ccc",10,Timestamp.valueOf("2014-03-05 12:00:00"),Timestamp.valueOf("2014-03-05 13:00:00"),"电脑","未审批");
		dao.insert(meetingorder);		
	}
	
	@Test
	public void testInsertMany() throws Exception {
		
		for (int i = 1;i <= 5;i ++) {
		Meetingorder meetingorder = new Meetingorder("ccc"+i,11,12,"xxx"+i,10,Timestamp.valueOf("2014-03-05 12:00:00"),Timestamp.valueOf("2014-03-05 12:30:00"),"电脑，投影仪，麦克风","未审批");
		dao.insert(meetingorder);
		}
	}
	
	@Test
	public void testUpdate() throws Exception {
		
		Meetingorder meetingorder = new Meetingorder(62,"xxx",11,12,"ccc",10,Timestamp.valueOf("2014-03-05 12:00:00"),Timestamp.valueOf("2014-03-05 13:00:00"),"电脑","批准");
		dao.update(meetingorder);
	}
	
	
	@Test
	public void testGetCount() throws Exception {
		int count = dao.getCount(1);
		System.out.println("count=" + count);
	}
	
	@Test
	public void testGetMeetingCount() throws Exception {
		int count = dao.getMeetingCount(1);
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() throws Exception {
		Pager pager = new Pager(dao.getCount(1),3);
		List<Map> list = dao.query(pager,null);
		for (Map meetingorder : list) {
			System.out.println("-----------------"+meetingorder);
		}
	}
	
	@Test
	public void testQueryById() throws Exception {
		Meetingorder meetingorder=dao.queryById(11);
		System.out.println("==================="+meetingorder);
	}
	
}