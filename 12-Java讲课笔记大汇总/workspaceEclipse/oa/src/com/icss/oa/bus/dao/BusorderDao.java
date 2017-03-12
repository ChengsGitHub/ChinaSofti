
package com.icss.oa.bus.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.bus.pojo.Busorder;
import com.icss.oa.common.Pager;



@Repository
public interface BusorderDao {
	
	@Autowired 
	void insert(Busorder busorder) throws Exception;
	
	void update(Busorder busorder) throws Exception;
	
	void delete(Integer borderId) throws Exception;
	
	List<Map> query(Pager pager,Integer empId) throws Exception;
	
	Busorder queryById(Integer borderId) throws Exception;

	int getCount(Integer empId) throws Exception;
}
