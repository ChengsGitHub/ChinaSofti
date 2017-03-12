package com.icss.hr.emp.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.po.Emp;

public class EmpDaoImpl implements EmpDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Emp emp) {
		Session session = sessionFactory.getCurrentSession();
		session.save(emp);
	}

	@Override
	public void update(Emp emp) {
		Session session = sessionFactory.getCurrentSession();
		session.update(emp);
	}

	@Override
	public void delete(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Emp emp = (Emp) session.get(Emp.class, empId);
		session.delete(emp);
	}

	@Override
	public Emp queryById(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		Emp emp = (Emp) session.get(Emp.class, empId);
		return emp;
	}

	@Override
	public Integer getCount() {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "select count(*) from Emp e";
		Query query = session.createQuery(hql);	
		Long count = (Long) query.uniqueResult();//按照单一值取值
		
		return count.intValue();
	}

	@Override
	public List<Emp> query(Pager pager) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Emp e";
		Query query = session.createQuery(hql);	
		
		query.setFirstResult(pager.getStart() - 1);
		query.setMaxResults(pager.getPageSize());
		
		List<Emp> list = query.list();

		return list;
	}

}
