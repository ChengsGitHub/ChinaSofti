package com.icss.hr.admin.dao;

import com.icss.hr.admin.po.Admin;

/**
 * ADMIN DAO�ӿ�
 * @author Administrator
 *
 */
public interface AdminDao {

	Admin queryByName(String adminName);
	
}