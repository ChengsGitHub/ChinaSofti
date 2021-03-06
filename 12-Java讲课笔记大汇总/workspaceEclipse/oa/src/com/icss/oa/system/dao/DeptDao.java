package com.icss.oa.system.dao;

import java.util.List;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Dept;

public interface DeptDao {
	public void insert(Dept dept);
	public void update(Dept dept);
	public void delete(Integer deptId);
	public Dept queryById(Integer deptId);
	public List<Dept> query(Pager pager) ;
	public int getCount();
}
