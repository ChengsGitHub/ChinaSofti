package com.icss.hr.emp.dao;

import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.po.Emp;

public interface EmpDao {
	
	void insert(Emp emp) throws Exception;
	
	void update(Emp emp) throws Exception;
	
	void delete(int empId) throws Exception;
	
	Emp queryById(int empId) throws Exception;
	
	ArrayList<Emp> query(Pager pager) throws Exception;
	
	int getCount() throws Exception;

}