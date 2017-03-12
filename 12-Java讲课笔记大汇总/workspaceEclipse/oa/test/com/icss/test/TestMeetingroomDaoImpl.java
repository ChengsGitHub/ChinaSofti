package com.icss.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.MeetingroomDao;
import com.icss.oa.meeting.pojo.Meetingroom;





public class TestMeetingroomDaoImpl {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private MeetingroomDao dao = (MeetingroomDao) context.getBean(MeetingroomDao.class);
	
	@Test
	public void testInsert() throws Exception {
		Meetingroom meetingroom = new Meetingroom("一号会议室","三楼",100,0,1);
		dao.insert(meetingroom);		
	}
	
	@Test
	public void testInsertMany() throws Exception {
		
		for (int i = 1;i <= 5;i ++) {
		Meetingroom meetingroom = new Meetingroom(010+i,"一号会议室","三楼",100,0,1);
		dao.insert(meetingroom);
		}
	}
	
	@Test
	public void testUpdate() throws Exception {
		Meetingroom meetingroom = new Meetingroom(004,"二号会议室","三楼",100,0,1);
		dao.update(meetingroom);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(003);
	}
	
	@Test
	public void testGetCount() throws Exception {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() throws Exception {
		Pager pager = new Pager(dao.getCount(),2);
		List<Meetingroom> list = dao.query(pager);
		for (Meetingroom meetingroom : list) {
			System.out.println(meetingroom);
		}
	}
}