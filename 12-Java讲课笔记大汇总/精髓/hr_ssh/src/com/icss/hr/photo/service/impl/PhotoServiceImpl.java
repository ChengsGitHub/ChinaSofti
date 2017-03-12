package com.icss.hr.photo.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.emp.po.Emp;
import com.icss.hr.photo.dao.PhotoDao;
import com.icss.hr.photo.po.Photo;
import com.icss.hr.photo.service.PhotoService;
import com.icss.hr.photo.vo.PhotoVo;

@Transactional(rollbackFor=Exception.class)
public class PhotoServiceImpl implements PhotoService {

	private PhotoDao dao;

	public void setDao(PhotoDao dao) {
		this.dao = dao;
	}

	@Override
	public void add(PhotoVo vo) {
		Emp emp = new Emp();
		emp.setEmpId(vo.getEmpId());
		
		Photo photo = new Photo(vo.getPhotoPath(),emp);		
		dao.add(photo);
	}

	@Override
	public void delete(int photoId) {
		dao.delete(photoId);
	}

	@Override
	public List<Photo> query(int empId) {

		return dao.query(empId);
	}

}