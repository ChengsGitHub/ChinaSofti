package com.icss.hr.dept.dao;

import java.util.List;

import com.icss.hr.dept.po.Dept;

public interface DeptDao {

	void add(Dept dept);

	void update(Dept dept);

	void delete(int deptId);

	Dept queryById(int deptId);

	List<Dept> query();

}