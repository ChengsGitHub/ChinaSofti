package com.icss.oa.assign.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.assign.pojo.Image;

@Repository
public class ImageDaoImpl  implements ImageDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Image image){
		SqlSession session = factory.openSession();
		session.insert("IMAGE.insert", image);		
	}
	
	public List<Image> queryByEmpId(Integer empId) {
		SqlSession session = factory.openSession();
		List<Image> list = session.selectList("IMAGE.queryByEmpId", empId);		
		return list;
	}
	
	public Image queryById(Integer imageId) {
		SqlSession session = factory.openSession();
		Image image = session.selectOne("IMAGE.queryById", imageId);		
		return image;
	}
	
}