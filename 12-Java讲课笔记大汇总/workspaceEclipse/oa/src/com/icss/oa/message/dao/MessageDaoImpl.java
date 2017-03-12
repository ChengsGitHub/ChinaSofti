package com.icss.oa.message.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.message.pojo.Message;
import com.icss.oa.system.pojo.Emp;

@Repository
public class MessageDaoImpl implements MessageDao {

	@Autowired
	private SqlSessionFactory factory;
	
	@Override
	public void insert(Message message){
		SqlSession session = factory.openSession();
		message.setSendTime(new Date());
		session.insert("MESSAGE.insert",message);
	}
	
	@Override
	public void delete(Integer messageId){
		SqlSession session = factory.openSession();
		session.insert("MESSAGE.delete",messageId);
	}
	
	@Override
	public Message queryById(Integer messageId){
		SqlSession session = factory.openSession();
		Message message = session.selectOne("MESSAGE.queryById", messageId);
		return message;
	}

	@Override
	public Map<String, Object> queryByIdSend(Integer messageId) {
		SqlSession session = factory.openSession();
		
		Map<String,Object> map = session.selectOne("MESSAGE.queryByIdSend",messageId);
		return map;
	}

	@Override
	public Map<String, Object> queryByIdRead(Integer messageId) {
		SqlSession session = factory.openSession();
		
		Map<String,Object> map = session.selectOne("MESSAGE.queryByIdRead",messageId);
		return map;
	}
	
	@Override
	public List<Message> query(Pager pager){
		SqlSession session = factory.openSession();
		
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Message> list = session.selectList("MESSAGE.query",map);
		return list;
	}
	
	@Override
	public List<Map<String,Object>> queryByRead(Map map){
		SqlSession session = factory.openSession();
		
//		HashMap<String, Integer> map = new HashMap<String,Integer>();
//		map.put("start", pager.getStart());
//		map.put("end", pager.getStart() + pager.getPageSize() - 1);
//		map.put("mRead", mRead);
//		map.put("recevId", recevId);
//		map.put("mSend", 2);
		List<Map<String,Object>> list = session.selectList("MESSAGE.queryByRead",map);
		return list;
	}
	
	@Override
	public List<Map<String,Object>> queryBySend(Map map){
		SqlSession session = factory.openSession();
		
//		HashMap<String, Integer> map = new HashMap<String,Integer>();
//		map.put("start", pager.getStart());
//		map.put("end", pager.getStart() + pager.getPageSize() - 1);
//		map.put("mSend", mSend);
//		map.put("sendId",sendId);
		List<Map<String,Object>> list = session.selectList("MESSAGE.queryBySend",map);
		return list;
	}

	@Override
	public int getCount() {
		SqlSession session = factory.openSession();
		
		int count = session.selectOne("MESSAGE.getCount");
		return count;
	}

	@Override
	public void update(Message message) {
		SqlSession session = factory.openSession();
		message.setSendTime(new Date());
		session.update("MESSAGE.update", message);
		   
	}

	@Override
	public void updateRead(Integer messageId) {
		SqlSession session = factory.openSession();
		
		session.update("MESSAGE.updateRead",messageId);
	}

	@Override
	public void updateSend(Integer messageId) {
		SqlSession session = factory.openSession();
		
		session.update("MESSAGE.updateSend",messageId);
	}

	@Override
	public int getNewCount(Integer empId) {
		SqlSession session = factory.openSession();
		return session.selectOne("MESSAGE.getNewCount",empId);
	}

	@Override
	public void send(Message message) {
		SqlSession session = factory.openSession();
		message.setSendTime(new Date());
		session.insert("MESSAGE.send",message);
		
	}

	@Override
	public int getReadCount(Integer empId) {
		SqlSession session = factory.openSession();
		return session.selectOne("MESSAGE.getReadCount",empId);
	}

	@Override
	public int getNoSendCount(Integer empId) {
		SqlSession session = factory.openSession();
		return session.selectOne("MESSAGE.getNoSendCount",empId);
	}

	@Override
	public int getSendYetCount(Integer empId) {
		SqlSession session = factory.openSession();
		return session.selectOne("MESSAGE.getSendYetCount",empId);
	}

	@Override
	public int getReadYetCount(Integer empId) {
		SqlSession session = factory.openSession();
		return session.selectOne("MESSAGE.getReadYetCount",empId);
	}

	@Override
	public List<Map> boolOfBirth(Integer month, Integer day) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("month", month);
		map.put("day", day);
		return session.selectList("MESSAGE.boolOfBirth",map);
	}

}
