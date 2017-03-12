package com.icss.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.action.MeetingroomAction;
import com.icss.oa.meeting.pojo.Meetingroom;
import com.icss.oa.meeting.service.MeetingroomService;


public class TestMeetingroomServiceImpl {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private MeetingroomService service = (MeetingroomService) context.getBean(MeetingroomService.class);
		
	private MeetingroomAction action = (MeetingroomAction) context.getBean(MeetingroomAction.class);
	
	@Test
	public void testQuery() throws Exception {
		Pager pager = new Pager(service.getCount(),1);
		List<Meetingroom> list = service.query(pager);
		for (Meetingroom meetingroom : list) {
			System.out.println(meetingroom);
		}
		System.out.println(service.getClass().getName());
	}
	
	@Test
	public void testAction() throws Exception {
		System.out.println(service.getClass().getName());
	}
}