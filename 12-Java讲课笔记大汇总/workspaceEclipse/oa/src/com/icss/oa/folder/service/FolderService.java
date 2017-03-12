package com.icss.oa.folder.service;

import java.util.List;

import com.icss.oa.folder.pojo.Folder;

public interface FolderService {
	public void insert(Folder folder) ;
	public void update(Folder folder) ;
	public void updateSharing(Folder folder);
	public void delete(Integer folderId);
	public List<Folder> queryByEmpId(Integer empId);
	public List<Folder> queryBySharing(Integer empId) ;
	public int getCount();
}
