package com.icss.hr.emp.service.impl;

import java.util.ArrayList;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.dao.impl.EmpDaoImpl;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.vo.EmpVo;
import com.icss.hr.job.pojo.Job;

public class EmpServiceImpl implements EmpService {

	private EmpDao dao = new EmpDaoImpl();

	@Override
	public void insert(EmpVo vo) throws Exception {
		Job job = new Job();
		job.setJobId(vo.getJobId());

		Dept dept = new Dept();
		dept.setDeptId(vo.getDeptId());

		Emp emp = new Emp(vo.getEmpName(), vo.getEmpEmail(), vo.getEmpPhone(),
				vo.getEmpHiredate(), job, vo.getEmpSalary(), dept);
		
		dao.insert(emp);
	}

	@Override
	public void update(EmpVo vo) throws Exception {
		Job job = new Job();
		job.setJobId(vo.getJobId());

		Dept dept = new Dept();
		dept.setDeptId(vo.getDeptId());

		Emp emp = new Emp(vo.getEmpId(),vo.getEmpName(), vo.getEmpEmail(), vo.getEmpPhone(),
				vo.getEmpHiredate(), job, vo.getEmpSalary(), dept);
		
		dao.update(emp);
	}

	@Override
	public void delete(int empId) throws Exception {
		dao.delete(empId);
	}

	@Override
	public Emp queryById(int empId) throws Exception {

		return dao.queryById(empId);
	}

	@Override
	public ArrayList<Emp> query(Pager pager) throws Exception {

		return dao.query(pager);
	}

	@Override
	public int getCount() throws Exception {

		return dao.getCount();
	}

}