package com.icss.hr.admin.dao;

import com.icss.hr.admin.po.Admin;

public interface AdminDao {
	
	Admin queryByName(String adminName) throws Exception;

}