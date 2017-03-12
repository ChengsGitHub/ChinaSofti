package com.icss.hr.photo.dao;

import java.util.ArrayList;

import com.icss.hr.photo.pojo.Photo;

public interface PhotoDao {
	
	ArrayList<Photo> query(int empId) throws Exception;
	
	void delete(int photoId) throws Exception;
	
	void insert(Photo photo) throws Exception;

}