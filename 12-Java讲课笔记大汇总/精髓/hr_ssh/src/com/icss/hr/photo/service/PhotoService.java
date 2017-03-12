package com.icss.hr.photo.service;

import java.util.List;

import com.icss.hr.photo.po.Photo;
import com.icss.hr.photo.vo.PhotoVo;

public interface PhotoService {
	
	void add(PhotoVo vo) ;
	
	void delete(int photoId) ;
	
	List<Photo> query(int empId) ;

}
