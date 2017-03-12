package com.icss.hr.photo.service.impl;

import java.util.ArrayList;

import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.photo.dao.PhotoDao;
import com.icss.hr.photo.dao.impl.PhotoDaoImpl;
import com.icss.hr.photo.pojo.Photo;
import com.icss.hr.photo.service.PhotoService;
import com.icss.hr.photo.vo.PhotoVo;

public class PhotoServiceImpl implements PhotoService {
	
	private PhotoDao dao = new PhotoDaoImpl();

	@Override
	public void insert(PhotoVo vo) throws Exception {
		Emp emp = new Emp();
		emp.setEmpId(vo.getEmpId());
		Photo photo = new Photo(vo.getPhotoPath(),emp);
		dao.insert(photo);
	}

	@Override
	public void delete(int photoId) throws Exception {
		dao.delete(photoId);
	}

	@Override
	public ArrayList<Photo> query(int empId) throws Exception {

		return dao.query(empId);
	}

}