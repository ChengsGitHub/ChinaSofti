package com.icss.oa.message.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.message.dao.MessageDao;
import com.icss.oa.message.pojo.Message;
import com.icss.oa.system.dao.EmpDao;
import com.icss.oa.system.pojo.Emp;

@Service("messageService")
@Transactional(rollbackFor = Exception.class)
public class MessageService {

	@Autowired
	private MessageDao dao;
	@Autowired
	private EmpDao eDao;
	
	public void insert(Message message){
		dao.insert(message);
	}
	
	public void delete(Message message){

		dao.update(message);
	}
	
	public void update(Message message){
		dao.update(message);
	}
	
	//发送已有消息
	public void sendOld(Message message){
		dao.update(message);
		dao.updateSend(message.getMessageId());
	}
	
	//发送新消息
	public void sendNew(Message message){
		dao.send(message);
		
	}
	//查看已发消息详情
	public Map<String,Object> readMySend(Integer messageId){
		
		Map<String,Object> map = dao.queryByIdSend(messageId);
		return map;
	}
	
	//查询某一消息
	public Message queryById(Integer messageId){
		
		return dao.queryById(messageId);
	}
	
	//读取消息
	public Map<String,Object> read(Integer messageId){
		dao.updateRead(messageId);
		Map<String,Object> map = dao.queryByIdRead(messageId);
		return map;
	}
	
	//查询自己所有消息
	public List<Map<String,Object>> querySend(Pager pager,Integer sendId){
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		
		map.put("sendId", sendId);
		List<Map<String,Object>> list = dao.queryBySend(map);
		return list;
	}
	
	//查询已发消息
	public List<Map<String,Object>> querySendYet(Pager pager,Integer sendId,Integer type){
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("mSend", 2);
		map.put("type", type);
		map.put("sendId", sendId);
		List<Map<String,Object>> list = dao.queryBySend(map);
		return list;
	}
	
	//查询未发消息（草稿箱）
	public List<Map<String,Object>> queryNoSend(Pager pager,Integer sendId,Integer type){
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("mSend", 1);
		map.put("type", type);
		map.put("sendId",sendId);
		List<Map<String,Object>> list = dao.queryBySend(map);
		return list;
	}

	
	//查询所有已收的消息
	public List<Map<String,Object>> queryRead(Pager pager,Integer recevId,Integer type){
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		
		map.put("recevId", recevId);
		map.put("mSend", 2);
		map.put("type", type);
		List<Map<String,Object>> list = dao.queryByRead(map);
		return list;
	}
	
	//查询已读消息
	public List<Map<String,Object>> queryReadYet(Pager pager,Integer recevId,Integer type){
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("mRead", 2);
		map.put("recevId", recevId);
		map.put("type", type);
		map.put("mSend", 2);
		List<Map<String,Object>> list = dao.queryByRead(map);
		return list;
	}
	
	//查询未读消息
	public List<Map<String,Object>> queryNoRead(Pager pager,Integer recevId,Integer type){
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("mRead", 1);
		map.put("recevId", recevId);
		map.put("mSend", 2);
		map.put("type", type);
		List<Map<String,Object>> list = dao.queryByRead(map);
		return list;
	}
	
	//获取未读消息数目
	public int getNewCount(Integer empId){
		int count = dao.getNewCount(empId);
		return count;
	}
	
	//获取已收消息数目
	public int getReadCount(Integer empId){
		int count = dao.getReadCount(empId);
		return count;
	}
	
	//获取未发消息数目
	public int getNoSendCount(Integer empId){
		int count = dao.getNoSendCount(empId);
		return count;
	}
	
	//获取已发消息数目
	public int getSendYetCount(Integer empId){
		int count = dao.getSendYetCount(empId);
		return count;
	}
	
	//获取已读消息数目
	public int getReadYetCount(Integer empId){
		int count = dao.getReadYetCount(empId);
		return count;
	}
	
	//定时发送生日提示信息
	public void autoSendBirth(){
		
		Calendar calendar =  Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
	
		Pager pager = new Pager(eDao.getCount(),1,eDao.getCount());
		List<Emp> eList = eDao.query(pager);
		List<Map> list = dao.boolOfBirth(month, day);
		for(Map emp : list){
			BigDecimal empId = (BigDecimal) emp.get("EMP_ID");
			String empName = (String) emp.get("EMP_NAME");
			Message message = new Message(1,empId.intValue(),empName+"生日快乐！祝你幸福！");
			dao.send(message);
			
		}
		
		
	}
	
}
