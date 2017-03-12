package com.icss.oa.work.dao;

import java.util.List;
import java.util.Map;

import com.icss.oa.common.Pager;
import com.icss.oa.work.pojo.Schedule;

public interface ScheduleDao {
	void insert(Schedule schedule);
	void update(Schedule schedule);
	void delete(Integer scheduleId);
	Schedule queryById(Integer scheduleId);
	List<Schedule> query(Pager pager, Integer scheduleempid);
	int getCount(Integer scheduleempid);
	List<Map<String,Object>> query2(Pager pager);
	Schedule queryByUsername(String username);
	List<Schedule> queryByCondition(Pager pager,String scheduleEmpname);
	 int getConditionCount(String scheduleEmpname);
	 int getPrimaryKey();
}
