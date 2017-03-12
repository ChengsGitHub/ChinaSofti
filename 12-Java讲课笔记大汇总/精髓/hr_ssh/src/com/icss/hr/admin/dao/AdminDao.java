package com.icss.hr.admin.dao;

import com.icss.hr.admin.po.Admin;

/**
 * ADMIN DAO½Ó¿Ú
 * @author Administrator
 *
 */
public interface AdminDao {

	Admin queryByName(String adminName);
	
}