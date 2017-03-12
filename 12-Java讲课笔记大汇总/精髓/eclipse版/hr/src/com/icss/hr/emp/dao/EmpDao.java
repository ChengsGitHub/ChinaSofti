package com.icss.hr.emp.dao;

import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;

public interface EmpDao {
	
	void insert(Emp emp) throws Exception;
	
	void update(Emp emp) throws Exception;
	
	void delete(int empId) throws Exception;
	
	Emp queryById(int empId) throws Exception;//�����ѯ
	
	int getCount() throws Exception;//�ܼ�¼��
	
	ArrayList<Emp> query(Pager pager) throws Exception;

}