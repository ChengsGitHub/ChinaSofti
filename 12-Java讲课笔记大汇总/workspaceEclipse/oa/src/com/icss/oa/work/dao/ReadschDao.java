package com.icss.oa.work.dao;

import java.util.List;
import java.util.Map;

import com.icss.oa.common.Pager;
import com.icss.oa.work.pojo.Readsch;

public interface ReadschDao {
	void insert(Readsch readsch);
	void update(Readsch readsch);
	 void delete(Integer readschId);
	 Readsch queryById(Integer readschId);
	 List<Map> query(Pager pager,Integer empId) ;
	 int getCount(Integer empId);
	 int getOtherCount(Integer empId);
	 List<Map> query2(Pager pager,Integer empId);
	 Readsch queryByUsername(String username);
	 List<Readsch> queryByCondition(Pager pager,String readschName);
	 int getConditionCount(String readschName);
	 int getPrimaryKey();
}
