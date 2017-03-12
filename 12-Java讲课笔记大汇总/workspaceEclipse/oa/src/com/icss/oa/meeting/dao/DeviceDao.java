
package com.icss.oa.meeting.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.meeting.pojo.Device;



@Repository
public interface DeviceDao {
	
	@Autowired
	void insert(Device device) throws Exception;
	
	void update(Device device) throws Exception;
	
	void delete(Integer devId) throws Exception;
	
	List<Device> query(Pager pager) throws Exception;
	
	Device queryById(Integer deptId) throws Exception;

	int getCount() throws Exception;
}
