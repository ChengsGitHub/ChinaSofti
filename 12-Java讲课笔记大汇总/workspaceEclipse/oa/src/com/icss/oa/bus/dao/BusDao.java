package com.icss.oa.bus.dao;

import java.util.List;


import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.icss.oa.bus.pojo.Bus;
import com.icss.oa.common.Pager;

@Repository
public interface BusDao {


	
	void insert(Bus bus) throws Exception;
	
	void update(Bus bus) throws Exception;
	
	void delete(Integer busId) throws Exception;
	
	Bus queryById(Integer busId) throws Exception;
	
	List<Bus> queryByBusId(Integer busId);
	
	List<Bus> query(Pager pager) throws Exception;
	
	Bus queryByBusType(String busType)throws Exception ;
	
	int getCount() throws Exception;
	
	List<Bus> queryByCondition(Pager pager,String busType)throws Exception ;
	
	int getConditionCount(String busType)throws Exception; 
	
	public int getPrimaryKey()throws Exception ;
}
