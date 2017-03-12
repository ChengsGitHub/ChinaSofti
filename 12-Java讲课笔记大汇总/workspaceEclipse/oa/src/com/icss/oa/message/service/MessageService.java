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
	
	//����������Ϣ
	public void sendOld(Message message){
		dao.update(message);
		dao.updateSend(message.getMessageId());
	}
	
	//��������Ϣ
	public void sendNew(Message message){
		dao.send(message);
		
	}
	//�鿴�ѷ���Ϣ����
	public Map<String,Object> readMySend(Integer messageId){
		
		Map<String,Object> map = dao.queryByIdSend(messageId);
		return map;
	}
	
	//��ѯĳһ��Ϣ
	public Message queryById(Integer messageId){
		
		return dao.queryById(messageId);
	}
	
	//��ȡ��Ϣ
	public Map<String,Object> read(Integer messageId){
		dao.updateRead(messageId);
		Map<String,Object> map = dao.queryByIdRead(messageId);
		return map;
	}
	
	//��ѯ�Լ�������Ϣ
	public List<Map<String,Object>> querySend(Pager pager,Integer sendId){
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		
		map.put("sendId", sendId);
		List<Map<String,Object>> list = dao.queryBySend(map);
		return list;
	}
	
	//��ѯ�ѷ���Ϣ
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
	
	//��ѯδ����Ϣ���ݸ��䣩
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

	
	//��ѯ�������յ���Ϣ
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
	
	//��ѯ�Ѷ���Ϣ
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
	
	//��ѯδ����Ϣ
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
	
	//��ȡδ����Ϣ��Ŀ
	public int getNewCount(Integer empId){
		int count = dao.getNewCount(empId);
		return count;
	}
	
	//��ȡ������Ϣ��Ŀ
	public int getReadCount(Integer empId){
		int count = dao.getReadCount(empId);
		return count;
	}
	
	//��ȡδ����Ϣ��Ŀ
	public int getNoSendCount(Integer empId){
		int count = dao.getNoSendCount(empId);
		return count;
	}
	
	//��ȡ�ѷ���Ϣ��Ŀ
	public int getSendYetCount(Integer empId){
		int count = dao.getSendYetCount(empId);
		return count;
	}
	
	//��ȡ�Ѷ���Ϣ��Ŀ
	public int getReadYetCount(Integer empId){
		int count = dao.getReadYetCount(empId);
		return count;
	}
	
	//��ʱ����������ʾ��Ϣ
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
			Message message = new Message(1,empId.intValue(),empName+"���տ��֣�ף���Ҹ���");
			dao.send(message);
			
		}
		
		
	}
	
}
