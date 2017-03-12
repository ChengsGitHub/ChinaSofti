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
			Schedule schedule = new Schedule(2,"张三11","与习近平会谈",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"会谈很成功，中 华两国达成战略性共识，为未来的发展奠定良好的基础");
			Schedule schedule1 = new Schedule(2,"张三22","面见奥巴马",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"会谈很成功，中 华两国达成战略性共识，为未来的发展奠定良好的基础");
			Schedule schedule2 = new Schedule(2,"张三33","约谈普京",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"会谈很成功，中 华两国达成战略性共识，为未来的发展奠定良好的基础");
			//Schedule schedule1 = new Schedule(4,"张飞","面见奥巴马",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"会谈很成功，美 华两国达成战略性共识，表示在反恐，新能源，经济取得重大进展");
			
			//Schedule schedule2 = new Schedule(6,"李四4","约谈普京",Date.valueOf("2004-5-6"),Date.valueOf("2007-5-5"),"会谈很成功，在领土问题迫于华夏国的军事压力俄罗斯做出让步，同意归还我华夏国的领土，包括外蒙");
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