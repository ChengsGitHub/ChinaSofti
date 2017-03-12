package com.icss.hr.photo.dao;

import java.util.List;

import com.icss.hr.photo.po.Photo;

/**
 * PHOTO DAO½Ó¿Ú
 * @author Administrator
 *
 */
public interface PhotoDao {
	
	void add(Photo photo) ;

	void delete(Integer photoId) ;
	
	List<Photo> query(Integer empId) ;
	
}