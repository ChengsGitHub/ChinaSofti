package com.icss.hr.emp.service;

import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.vo.EmpVo;

public interface EmpService {

	void insert(EmpVo vo) throws Exception;

	void update(EmpVo vo) throws Exception;

	void delete(int empId) throws Exception;

	Emp queryById(int empId) throws Exception;// �����ѯ

	int getCount() throws Exception;// �ܼ�¼��

	ArrayList<Emp> query(Pager pager) throws Exception;

}
