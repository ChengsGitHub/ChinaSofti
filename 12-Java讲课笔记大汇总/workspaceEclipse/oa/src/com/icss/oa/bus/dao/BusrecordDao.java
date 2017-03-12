
package com.icss.oa.bus.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.bus.pojo.Busrecord;
import com.icss.oa.common.Pager;



@Repository
public interface BusrecordDao {
	
	@Autowired 
	void insert(Busrecord busrecord) throws Exception;
	
	void update(Busrecord busrecord) throws Exception;
	
	void delete(Integer brecordId) throws Exception;
	
	List<Busrecord> query(Pager pager) throws Exception;
	
	Busrecord queryById(Integer brecordId) throws Exception;

	int getCount() throws Exception;
}
