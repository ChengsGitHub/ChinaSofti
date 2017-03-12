package com.icss.test;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.message.dao.MessageDaoImpl;
import com.icss.oa.message.pojo.Message;
import com.icss.oa.system.pojo.Emp;

public class TestMessageDao {

	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	
	private MessageDaoImpl dao = context.getBean(MessageDaoImpl.class);
	
	@Test
	public void TestInsert(){
			
			Message message = new Message(20,19,"第封信息",new Date(),2,2);
			dao.insert(message);
	}
	
	@Test
	public void TestSend(){
			
			Message message = new Message(20,19,"第封信息");
			dao.send(message);
		
	}
	
	@Test
	public void TestDelete(){
		for(int i = 32;i<34;i++)
			dao.delete(i);
	}
	
	@Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(), 1);
		List<Message> list = dao.query(pager);
		for (Message message : list) {
			System.out.println(message);
		}
	}
	
	@Test
	public void testQueryById(){
		Message message = dao.queryById(4);
		System.out.println(message);
	}
	
	@Test
	public void testQueryBySend() {
		Pager pager = new Pager(dao.getCount(), 1);
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		
		map.put("sendId", 2);
		List<Map<String,Object>> list = dao.queryBySend(map);
		for (Map<String,Object> map1 : list) {
			System.out.println(map1);
		}
	}
	
	@Test
	public void testQueryByIdRead() {
		Map<String, Object> map;
		
		
		map = dao.queryByIdRead(47);
		
		System.out.println(map.get("EMP_NAME")+"||"+map.get("M_SEND")+"||"+map.get("M_READ")+"||"
		+map.get("MESSAGE_CONT"));
		
	}
	
	@Test
	public void testQueryByRead() {
		Pager pager = new Pager(dao.getCount(),2);
		
		System.out.println("pageSize=" + pager.getPageSize());
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("recevId", 2);
		map.put("mSend", 2);
		List<Map<String,Object>> list = dao.queryByRead(map);
		for (Map<String,Object> map1 : list) {
			System.out.println(map1);
		}
	}
	
	@Test
	public void testUpdate(){
		Message message = new Message(3,19,24,"第1封信息，给吕布的！",new Date(),1,1);
		dao.update(message);
	}
	
	@Test
	public void testUpdateSend(){
		dao.updateSend(4);
		
	}
	
	@Test
	public void testUpdateRead(){
		dao.updateRead(3);
		
	}
	
	@Test
	public void testBoolOfBirth(){
		List<Map> list = dao.boolOfBirth(7, 21);
		for(Map message:list){
			System.out.println(message);
		}
	}

}
