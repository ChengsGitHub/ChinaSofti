package com.icss.hr.emp.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.common.Pager;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.dao.impl.EmpDaoImpl;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.vo.EmpVo;
import com.icss.hr.job.po.Job;

@Transactional(rollbackFor=Exception.class)
public class EmpServiceImpl implements EmpService {

	// 定义员工 DAO 接口实现类对象
	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	/**
	 * 增加员工方法
	 */
	@Override
	public void add(EmpVo vo) {

		// VO 转 PO
		Job job = new Job();
		job.setJobId(vo.getJobId());

		Dept dept = new Dept();
		dept.setDeptId(vo.getDeptId());

		Emp emp = new Emp(vo.getEmpName(), vo.getEmpEmail(), vo.getEmpPhone(),
				vo.getEmpHiredate(), job, vo.getEmpSalary(), dept);

		// 调用DAO增加员工方法
		dao.add(emp);

	}

	/**
	 * 修改员工方法
	 */
	@Override
	public void update(EmpVo vo) {

		// VO 转 PO
		Job job = new Job();
		job.setJobId(vo.getJobId());

		Dept dept = new Dept();
		dept.setDeptId(vo.getDeptId());

		Emp emp = new Emp(vo.getEmpId(), vo.getEmpName(), vo.getEmpEmail(),
				vo.getEmpPhone(), vo.getEmpHiredate(), job, vo.getEmpSalary(),
				dept);

		// 调用DAO修改员工方法
		dao.update(emp);

	}

	/**
	 * 删除员工方法
	 */
	@Override
	public void delete(Integer empId) {

		dao.delete(empId);

	}

	/**
	 * 获得员工总数方法
	 */
	@Override
	public Integer getCount() {

		// 调用DAO的getCount方法
		Integer count = dao.getCount();

		// 返回
		return count;
	}

	/**
	 * 查询所有员工方法
	 */
	@Override
	public List<Emp> query(Pager pager) {

		// 调用DAO查询所有员工方法
		List<Emp> list = dao.query(pager);

		// 返回list
		return list;
	}

	/**
	 * 查询单个员工方法
	 */
	@Override
	public Emp queryById(Integer empId) {

		// 调用DAO查询单个员工方法
		Emp emp = dao.queryById(empId);

		// 返回
		return emp;
	}

}