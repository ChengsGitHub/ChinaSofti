package com.icss.oa.folder.dao;

import java.util.List;

import com.icss.oa.folder.pojo.Folder;

public interface FolderDao {
	public void insert(Folder folder);
	public void update(Folder folder) ;
	public void updateSharing(Folder folder);
	public void delete(Integer folderId);
	public List<Folder> queryByEmpId(Integer emp1Id);
	public List<Folder> queryBySharing(Integer emp1Id);
	public int getCount();
}
