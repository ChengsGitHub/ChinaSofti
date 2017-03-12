package com.icss.oa.folder.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.folder.dao.FolderDao;
import com.icss.oa.folder.dao.FolderDaoImpl;
import com.icss.oa.folder.pojo.Folder;

@Service
@Transactional(rollbackFor = Exception.class)
public class FolderServiceImpl implements FolderService{

	@Autowired
	private FolderDao dao;

	public void insert(Folder folder) {
		dao.insert(folder);
	}

	public void update(Folder folder) {
		dao.update(folder);
	}
	
	public void updateSharing(Folder folder) {
		dao.updateSharing(folder);
	}

	public void delete(Integer folderId) {
		dao.delete(folderId);
	}

	public List<Folder> queryByEmpId(Integer empId) {

		return dao.queryByEmpId(empId);
	}
	
	
	public List<Folder> queryBySharing(Integer empId) {

		return dao.queryBySharing(empId);
	}

	public int getCount() {

		return dao.getCount();
	}
}