package com.icss.oa.folder.dao;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.icss.oa.folder.pojo.Folder;


@Repository
public class FolderDaoImpl implements FolderDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Folder folder) {
		SqlSession session = factory.openSession();
		session.insert("FOLDER.insert", folder);		
	}
	
	public void update(Folder folder) {
		SqlSession session = factory.openSession();
		session.update("FOLDER.update", folder);
	}
	
	public void updateSharing(Folder folder) {
		SqlSession session = factory.openSession();
		session.update("FOLDER.updateSharing", folder);
	}
	
	public void delete(Integer folderId) {
		SqlSession session = factory.openSession();
		session.delete("FOLDER.delete", folderId);
	}
	
	public List<Folder> queryByEmpId(Integer emp1Id) {
		SqlSession session = factory.openSession();
		List<Folder> list = session.selectList("FOLDER.queryByEmpId", emp1Id);
		return list;
	}
	

	public List<Folder> queryBySharing(Integer emp1Id) {
		SqlSession session = factory.openSession();
		List<Folder> list = session.selectList("FOLDER.queryBySharing", emp1Id);
		return list;
	}
	
	
	public int getCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("FOLDER.getCount");
		return count;
	}
}