package com.icss.test;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.message.pojo.Message;
import com.icss.oa.message.service.MessageService;

public class TestMessageService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	
	MessageService service = context.getBean(MessageService.class);
	
	@Test
	public void testUpdate(){
		Message message = new Message(3,19,24,"第1封信息",new Date(),1,1);
		service.update(message);
	}
	
	@Test
	public void testSendNew(){
		Message message = new Message(19,24,"第1封信息",new Date(),1,1);
		service.sendNew(message);
	}
	
//	@Test
//	public void testQuerySendYet(){
//		Pager pager = new Pager(service.getCount(),1);
//		List<Map<String,Object>> list = service.querySendYet(pager, 2);
//		for (Map<String,Object> map1 : list) {
//			System.out.println(map1.get("SEND_ID")+"|"+map1.get("EMP_NAME")+"|"+map1.get("MESSAGE_CONT")+"|"
//					+map1.get("MESSAGE_ID")+"|"+map1.get("M_SEND")+"|"+map1.get("M_READ"));
//		}
//	}
	
	@Test
	public void testRead(){
		Map<String,Object> map1 = service.read(47);
		System.out.println(map1.get("SEND_ID")+"|"+map1.get("EMP_NAME")+"|"+map1.get("MESSAGE_CONT")+"|"
					+map1.get("MESSAGE_ID")+"|"+map1.get("M_SEND")+"|"+map1.get("M_READ"));
		
	}
	
	@Test
	public void testQueryRead(){
		Pager pager = new Pager(service.getReadYetCount(2),1);
		List<Map<String,Object>> list = service.queryRead(pager, 2, 2);
		System.out.println(service.getReadYetCount(2));
		for(Map<String,Object> map:list){
			System.out.println(map);
		}
		
	}
	
	@Test
	public void testBoolOfBirth(){
		service.autoSendBirth();
		
	}
	
}
