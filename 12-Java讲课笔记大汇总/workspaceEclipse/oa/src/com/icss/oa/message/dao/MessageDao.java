package com.icss.oa.message.dao;

import java.util.List;
import java.util.Map;

import com.icss.oa.common.Pager;
import com.icss.oa.message.pojo.Message;
import com.icss.oa.system.pojo.Emp;

public interface MessageDao {
	void insert(Message message);
	
	void send(Message message);
	
	void delete(Integer messageId);
	
	Message queryById(Integer messageId);
	
	Map<String,Object> queryByIdSend(Integer messageId);
	
	Map<String,Object> queryByIdRead(Integer messageId);
	
	List<Message> query(Pager pager);
	
	List<Map<String,Object>> queryByRead(Map map);

	List<Map<String,Object>> queryBySend(Map map);
	
	void update(Message message);
	
	void updateRead(Integer messageId);
	
	void updateSend(Integer messageId);
	
	int getCount();
	
	int getNewCount(Integer empId);
	
	int getReadCount(Integer empId);
	
	int getNoSendCount(Integer empId);
	
	int getSendYetCount(Integer empId);
	
	int getReadYetCount(Integer empId);
	
	List<Map> boolOfBirth(Integer month,Integer day);
	
//	Date formatDate(Date date);
}
