package com.icss.oa.meeting.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.DeviceDao;
import com.icss.oa.meeting.pojo.Device;


@Repository
public class DeviceDaoImpl implements DeviceDao{

	@Autowired
	private SqlSessionFactory factory;

	
	public void insert(Device device) {
		SqlSession session = factory.openSession();
		session.insert("DEVICE.insert", device);
	}

	
	public void update(Device device){
		SqlSession session = factory.openSession();
		session.update("DEVICE.update", device);
	}

	
	public void delete(Integer devId){
		SqlSession session = factory.openSession();
		session.delete("DEVICE.delete", devId);
	}

	
	public List<Device> query(Pager pager){
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Device> list = session.selectList("DEVICE.query",map);
		return list;
	}
	
	
	public Device queryById(Integer devId) {
		SqlSession session = factory.openSession();
		Device device = session.selectOne("DEVICE.queryById",devId);
		return device;
	}
	
	public int getCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("DEVICE.getCount");
		return count;
	}
	
}
