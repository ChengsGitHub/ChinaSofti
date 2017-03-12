package com.icss.hr.emp.service;

import java.util.List;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.vo.EmpVo;

/**
 * EMP SERVICE½Ó¿Ú
 * @author Administrator
 *
 */
public interface EmpService {
	
	void add(EmpVo vo);

	void update(EmpVo vo) ;
	
	void delete(Integer empId) ;
	
	Emp queryById(Integer empId);
	
	Integer getCount();
	
	List<Emp> query(Pager pager);
	
}