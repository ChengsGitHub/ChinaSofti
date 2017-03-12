package com.icss.oa.assign.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.assign.dao.ImageDao;
import com.icss.oa.assign.pojo.Image;

@Service
@Transactional(rollbackFor = Exception.class)
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageDao dao;

	public void insert(Image image) {
		dao.insert(image);
	}

	public List<Image> queryByEmpId(Integer empId) {
		return dao.queryByEmpId(empId);
	}
	
	public Image queryById(Integer imageId) {
		return dao.queryById(imageId);
	}
	
}