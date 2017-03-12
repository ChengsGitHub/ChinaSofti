package com.icss.oa.system.dao;

import java.util.List;
import java.util.Map;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Emp;

public interface EmpDao  {
	public void insert(Emp emp);
	public void update(Emp emp);
	public void delete(Integer empId) ;
	public Emp queryById(Integer empId);
	public List<Emp> query(Pager pager);
	public int getCount() ;
	public List<Map<String,Object>> query2(Pager pager);
	void insertUserRole(Map<String,Integer> map);
	List<Map<String,Object>> queryRole(Integer empID);
	void deleteRole(Integer ur) ;
	int getPrimaryKey();
}
