package com.icss.hr.dept.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.icss.hr.dept.dao.DeptDao;
import com.icss.hr.dept.po.Dept;

public class DeptDaoImpl implements DeptDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Dept dept) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dept);
	}

	@Override
	public void update(Dept dept) {
		Session session = sessionFactory.getCurrentSession();
		session.update(dept);
	}

	@Override
	public void delete(int deptId) {
		Session session = sessionFactory.getCurrentSession();
		Dept dept = (Dept) session.get(Dept.class, deptId);
		session.delete(dept);
	}

	@Override
	public Dept queryById(int deptId) {
		Session session = sessionFactory.getCurrentSession();
		Dept dept = (Dept) session.get(Dept.class, deptId);
		return dept;
	}

	@Override
	public List<Dept> query() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Dept d";
		Query query = session.createQuery(hql);
		List<Dept> list = query.list();
		
		return list;
	}

}