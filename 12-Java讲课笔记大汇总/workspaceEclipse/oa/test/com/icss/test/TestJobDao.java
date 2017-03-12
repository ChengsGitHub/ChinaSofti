package com.icss.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.JobDao;
import com.icss.oa.system.dao.JobDaoImpl;
import com.icss.oa.system.pojo.Job;
import com.icss.oa.system.service.JobService;

public class TestJobDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	private JobDao dao = (JobDao) context.getBean(JobDao.class);
	private JobService service = (JobService) context.getBean(JobService.class);

	@Test
	public void testInsert() {
		Job job  = new Job("测试人员");
		dao.insert(job);
	}
	
	@Test
	public void testInsertMany() {
		for (int i = 7;i <= 30;i ++) {
			Job job  = new Job("测试人员" + i);
			dao.insert(job);
		}
	}
	
	@Test
	public void testGetCount() {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}

	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(), 2,10);
		List<Job> list = dao.query(pager);
		for (Job job : list) {
			System.out.println(job);
		}
	}
}