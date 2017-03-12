package com.icss.oa.work.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.work.pojo.Schedule;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

	@Autowired
	private SqlSessionFactory factory;

	public void insert(Schedule schedule) {
		SqlSession session = factory.openSession();
		session.insert("SCHEDULE.insert", schedule);
		
		System.out.println("ScheduleDao.insert被执行");
	}

	public void update(Schedule schedule) {
		SqlSession session = factory.openSession();
		session.update("SCHEDULE.update", schedule);
	}

	public void delete(Integer scheduleId) {
		SqlSession session = factory.openSession();
		session.delete("SCHEDULE.delete", scheduleId);
	}

	public Schedule queryById(Integer scheduleId) {
		SqlSession session = factory.openSession();
		Schedule schedule = session.selectOne("SCHEDULE.queryById", scheduleId);
		return schedule;
	}

	public List<Schedule> query(Pager pager, Integer scheduleempid) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("schedule_Empid", scheduleempid);
		List<Schedule> list = session.selectList("SCHEDULE.query", map);
		return list;
	}

	public int getCount(Integer scheduleempid) {
		SqlSession session = factory.openSession();
		int count = session.selectOne("SCHEDULE.getCount",scheduleempid);
		return count;
	}
	
	public List<Map<String,Object>> query2(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Map<String,Object>> list = session.selectList("SCHEDULE.query2", map);
		return list;
	}
	
	/**
	 * 根据用户名查询员工数据
	 * @param username
	 * @return
	 */
	public Schedule queryByUsername(String username) {
		SqlSession session = factory.openSession();
		Schedule schedule = session.selectOne("SCHEDULE.queryByUsername", username);
		return schedule;		
	}
	
	/**
	 * 根据检索条件查询
	 * @param pager
	 * @return
	 */
	public List<Schedule> queryByCondition(Pager pager,String scheduleSch) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("scheduleSch", scheduleSch);
		List<Schedule> list = session.selectList("SCHEDULE.queryByCondition", map);
		return list;
	}
	
	/**
	 * 返回满足条件的总记录数
	 * @return
	 */
	public int getConditionCount(String scheduleSch) {
		SqlSession session = factory.openSession();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("scheduleSch", scheduleSch);
		int count = session.selectOne("SCHEDULE.getConditionCount",map);
		return count;
	}
	
	public int getPrimaryKey() {
		SqlSession session = factory.openSession();
		int primaryKey = session.selectOne("SCHEDULE.getPrimaryKey");
		return primaryKey;
	}
}