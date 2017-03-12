package com.icss.hr.admin.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.icss.hr.admin.dao.AdminDao;
import com.icss.hr.admin.po.Admin;

public class AdminDaoImpl implements AdminDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Admin queryByName(String adminName) {
				
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Admin admin where admin.adminName=:adminName";
		Query query = session.createQuery(hql);
		query.setParameter("adminName", adminName);
		Admin admin = (Admin) query.uniqueResult();
		
		return admin;
	}

}
