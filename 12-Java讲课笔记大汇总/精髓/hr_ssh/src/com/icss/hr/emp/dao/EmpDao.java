package com.icss.hr.emp.dao;

import java.util.List;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.po.Emp;

/**
 * EMP DAO½Ó¿Ú
 * @author Administrator
 *
 */
public interface EmpDao {
	
	void add(Emp emp) ;
	
	void update(Emp emp) ;
	
	void delete(Integer empId) ;
	
	Emp queryById(Integer empId) ;
	
	Integer getCount();
	
	List<Emp> query(Pager pager);

}