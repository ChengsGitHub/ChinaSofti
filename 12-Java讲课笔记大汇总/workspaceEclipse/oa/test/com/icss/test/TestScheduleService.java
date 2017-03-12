package com.icss.test;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.icss.oa.work.pojo.Schedule;
import com.icss.oa.work.service.ScheduleService;

public class TestScheduleService {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private ScheduleService service = (ScheduleService) context.getBean(ScheduleService.class);
	
	@Test
	public void testInsert() throws IOException {	
			Schedule schedule = new Schedule(2,"����111","��ϰ��ƽ��̸",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����� ���������ս���Թ�ʶ��Ϊδ���ķ�չ�춨���õĻ���");
			Schedule schedule1 = new Schedule(2,"����222","����°���",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����� ���������ս���Թ�ʶ��Ϊδ���ķ�չ�춨���õĻ���");
			Schedule schedule2 = new Schedule(2,"����333","Լ̸�վ�",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����� ���������ս���Թ�ʶ��Ϊδ���ķ�չ�춨���õĻ���");
			//Schedule schedule1 = new Schedule(4,"�ŷ�","����°���",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����� ���������ս���Թ�ʶ����ʾ�ڷ��֣�����Դ������ȡ���ش��չ");
			
			//Schedule schedule2 = new Schedule(6,"����4","Լ̸�վ�",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����������������ڻ��Ĺ��ľ���ѹ������˹�����ò���ͬ��黹�һ��Ĺ�����������������");
			service.insert(schedule);
			service.insert(schedule1); 
			service.insert(schedule2); 
			
	}
	
}