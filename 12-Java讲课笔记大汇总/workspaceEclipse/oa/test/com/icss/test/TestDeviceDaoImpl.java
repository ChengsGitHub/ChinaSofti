package com.icss.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.DeviceDao;
import com.icss.oa.meeting.pojo.Device;






public class TestDeviceDaoImpl {

	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private DeviceDao dao = (DeviceDao) context.getBean(DeviceDao.class);
	
	@Test
	public void testInsert() throws Exception {
		Device device = new Device("投影仪",10,"xxx",Date.valueOf("2010-5-6"),1);
		dao.insert(device);		
	}
	
	@Test
	public void testInsertMany() throws Exception {
		
		for (int i = 1;i <= 5;i ++) {
			Device device = new Device("电脑"+i,8,"xxx"+i,Date.valueOf("2010-5-6"),0);
		dao.insert(device);
		}
	}
	
	@Test
	public void testUpdate() throws Exception {
		Device device = new Device(3,"话筒",5,"xxx",Date.valueOf("2011-5-6"),0);
		dao.update(device);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(5);
	}
	
	@Test
	public void testGetCount() throws Exception {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
	
	@Test
	public void testQuery() throws Exception {
		Pager pager = new Pager(dao.getCount(),2);
		List<Device> list = dao.query(pager);
		for (Device device : list) {
			System.out.println(device);
		}
	}
}