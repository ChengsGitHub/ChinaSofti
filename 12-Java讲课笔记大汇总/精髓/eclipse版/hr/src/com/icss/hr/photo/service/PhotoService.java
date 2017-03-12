package com.icss.hr.photo.service;

import java.util.ArrayList;

import com.icss.hr.photo.pojo.Photo;
import com.icss.hr.photo.vo.PhotoVo;

public interface PhotoService {
	
	void insert(PhotoVo vo) throws Exception;
	
	void delete(int photoId) throws Exception;
	
	ArrayList<Photo> query(int empId) throws Exception;

}
