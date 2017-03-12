package com.icss.hr.dept.service;

import java.util.List;

import com.icss.hr.dept.po.Dept;
import com.icss.hr.dept.vo.DeptVo;

/**
 * DEPT SERVICE½Ó¿Ú
 * @author Administrator
 *
 */
public interface DeptService {
	
	void add(DeptVo vo);
	
	void update(DeptVo vo);
	
	void delete(int deptId);
	
	Dept queryById(int deptId);

	List<Dept> query();
	
}