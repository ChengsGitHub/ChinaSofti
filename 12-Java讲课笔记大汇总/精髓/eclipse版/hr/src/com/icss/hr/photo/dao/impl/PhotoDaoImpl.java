package com.icss.hr.photo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.icss.hr.common.ConnFactory;
import com.icss.hr.emp.pojo.Emp;
import com.icss.hr.photo.dao.PhotoDao;
import com.icss.hr.photo.pojo.Photo;

public class PhotoDaoImpl implements PhotoDao {
	
	@Override
	public void insert(Photo photo) throws Exception {
		
		Connection conn = ConnFactory.getConnection();
		String sql = "insert into photo values (photo_seq.nextval,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, photo.getPhotoPath());
		pstmt.setInt(2, photo.getEmp().getEmpId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();		
	}
	
	@Override
	public void delete(int photoId) throws Exception {
		
		Connection conn = ConnFactory.getConnection();
		String sql = "delete from photo where photo_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, photoId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		
	}

	@Override
	public ArrayList<Photo> query(int empId) throws Exception {
		
		ArrayList<Photo> list = new ArrayList<Photo>();
		
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from photo where emp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {			
			Emp emp = new Emp();
			emp.setEmpId(rs.getInt(3));
			Photo photo = new Photo(rs.getInt(1),rs.getString(2),emp);
			list.add(photo);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		
		return list;
	}

}
