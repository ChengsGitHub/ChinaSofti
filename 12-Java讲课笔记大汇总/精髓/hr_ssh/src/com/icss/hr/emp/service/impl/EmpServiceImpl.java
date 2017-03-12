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

	// ����Ա�� DAO �ӿ�ʵ�������
	private EmpDao dao;

	public void setDao(EmpDao dao) {
		this.dao = dao;
	}

	/**
	 * ����Ա������
	 */
	@Override
	public void add(EmpVo vo) {

		// VO ת PO
		Job job = new Job();
		job.setJobId(vo.getJobId());

		Dept dept = new Dept();
		dept.setDeptId(vo.getDeptId());

		Emp emp = new Emp(vo.getEmpName(), vo.getEmpEmail(), vo.getEmpPhone(),
				vo.getEmpHiredate(), job, vo.getEmpSalary(), dept);

		// ����DAO����Ա������
		dao.add(emp);

	}

	/**
	 * �޸�Ա������
	 */
	@Override
	public void update(EmpVo vo) {

		// VO ת PO
		Job job = new Job();
		job.setJobId(vo.getJobId());

		Dept dept = new Dept();
		dept.setDeptId(vo.getDeptId());

		Emp emp = new Emp(vo.getEmpId(), vo.getEmpName(), vo.getEmpEmail(),
				vo.getEmpPhone(), vo.getEmpHiredate(), job, vo.getEmpSalary(),
				dept);

		// ����DAO�޸�Ա������
		dao.update(emp);

	}

	/**
	 * ɾ��Ա������
	 */
	@Override
	public void delete(Integer empId) {

		dao.delete(empId);

	}

	/**
	 * ���Ա����������
	 */
	@Override
	public Integer getCount() {

		// ����DAO��getCount����
		Integer count = dao.getCount();

		// ����
		return count;
	}

	/**
	 * ��ѯ����Ա������
	 */
	@Override
	public List<Emp> query(Pager pager) {

		// ����DAO��ѯ����Ա������
		List<Emp> list = dao.query(pager);

		// ����list
		return list;
	}

	/**
	 * ��ѯ����Ա������
	 */
	@Override
	public Emp queryById(Integer empId) {

		// ����DAO��ѯ����Ա������
		Emp emp = dao.queryById(empId);

		// ����
		return emp;
	}

}