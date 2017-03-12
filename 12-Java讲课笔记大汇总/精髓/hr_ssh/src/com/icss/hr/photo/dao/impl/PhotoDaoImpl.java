package com.icss.hr.photo.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.icss.hr.photo.dao.PhotoDao;
import com.icss.hr.photo.po.Photo;

public class PhotoDaoImpl implements PhotoDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Photo photo) {
		Session session = sessionFactory.getCurrentSession();
		session.save(photo);
	}

	@Override
	public void delete(Integer photoId) {
		Session session = sessionFactory.getCurrentSession();
		Photo photo = (Photo) session.get(Photo.class, photoId);
		session.delete(photo);
	}

	@Override
	public List<Photo> query(Integer empId) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Photo p where p.emp.empId=:empId";
		Query query = session.createQuery(hql);
		query.setParameter("empId", empId);
		List<Photo> list = query.list();
		
		return list;
	}

}
