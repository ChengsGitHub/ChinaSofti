package com.icss.oa.meeting.service;

import java.util.List;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.pojo.Device;

public interface DeviceService {
	

	 void insert(Device device) throws Exception;

	 void update(Device device) throws Exception ;

	 void delete(Integer roomId) throws Exception;

	 List<Device> query(Pager pager) throws Exception;
	
	 Device queryById(Integer devId) throws Exception;

	 int getCount() throws Exception;
	
}
