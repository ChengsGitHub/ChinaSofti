package com.icss.oa.meeting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.dao.DeviceDao;
import com.icss.oa.meeting.pojo.Device;




@Service
@Transactional(rollbackFor = Exception.class)
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	private DeviceDao dao;

	public void insert(Device device) throws Exception{
		dao.insert(device);
	}

	public void update(Device device) throws Exception {
		dao.update(device);
	}

	public void delete(Integer roomId) throws Exception  {
		dao.delete(roomId);
	}

	public List<Device> query(Pager pager) throws Exception  {
		return dao.query(pager);
	}
	
	public Device queryById(Integer devId) throws Exception {
		return dao.queryById(devId);
	}

	public int getCount() throws Exception {
		return dao.getCount();
	}
	
}
