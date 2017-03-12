package com.icss.test;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.work.dao.ScheduleDao;
import com.icss.oa.work.pojo.Schedule;

public class TestScheduleDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private ScheduleDao dao = (ScheduleDao) context.getBean(ScheduleDao.class);
	
	@Test
	public void testInsert() throws IOException {	
			Schedule schedule = new Schedule(2,"����11","��ϰ��ƽ��̸",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����� ���������ս���Թ�ʶ��Ϊδ���ķ�չ�춨���õĻ���");
			Schedule schedule1 = new Schedule(2,"����22","����°���",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����� ���������ս���Թ�ʶ��Ϊδ���ķ�չ�춨���õĻ���");
			Schedule schedule2 = new Schedule(2,"����33","Լ̸�վ�",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����� ���������ս���Թ�ʶ��Ϊδ���ķ�չ�춨���õĻ���");
			//Schedule schedule1 = new Schedule(4,"�ŷ�","����°���",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����� ���������ս���Թ�ʶ����ʾ�ڷ��֣�����Դ������ȡ���ش��չ");
			
			//Schedule schedule2 = new Schedule(6,"����4","Լ̸�վ�",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"��̸�ܳɹ����������������ڻ��Ĺ��ľ���ѹ������˹�����ò���ͬ��黹�һ��Ĺ�����������������");
			dao.insert(schedule);
			dao.insert(schedule1); 
			dao.insert(schedule2); 
			
	}
	

	@Test
	public void testGetCount() {
		int count = dao.getCount(2);
		System.out.println("count=" + count);
	}
	@Test
	public void testgetPrimaryKey() {
		int count=dao.getPrimaryKey();
		System.out.println("count=" + count);
	}
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(2),1);
		List<Schedule> list = dao.query(pager, 2);
		for (Schedule schedule : list) {
			System.out.println(schedule);
		}
	}
}