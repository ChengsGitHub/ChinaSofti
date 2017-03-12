package com.icss.hr.emp.dao;

import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;

public interface EmpDao {
	
	void insert(Emp emp) throws Exception;
	
	void update(Emp emp) throws Exception;
	
	void delete(int empId) throws Exception;
	
	Emp queryById(int empId) throws Exception;//单表查询
	
	int getCount() throws Exception;//总记录数
	
	ArrayList<Emp> query(Pager pager) throws Exception;

}