package com.icss.oa.assign.service;

import java.util.List;

import com.icss.oa.assign.pojo.Image;

public interface ImageService {
	void insert(Image image);
	List<Image> queryByEmpId(Integer empId);
	Image queryById(Integer imageId);
}
