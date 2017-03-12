package com.icss.hr.dept.dao;

import java.util.ArrayList;

import com.icss.hr.dept.pojo.Dept;

public interface DeptDao {
	
	void insert(Dept dept) throws Exception;
	
	void update(Dept dept) throws Exception;
	
	void delete(int deptId) throws Exception;
	
	Dept queryById(int deptId) throws Exception;
	
	ArrayList<Dept> query()  throws Exception;

}