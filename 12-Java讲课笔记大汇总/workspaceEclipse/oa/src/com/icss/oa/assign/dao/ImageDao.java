package com.icss.oa.assign.dao;

import java.util.List;

import com.icss.oa.assign.pojo.Image;

public interface ImageDao {
	void insert(Image image);
	List<Image> queryByEmpId(Integer empId);
	Image queryById(Integer imageId);
	
}
