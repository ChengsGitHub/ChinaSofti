package com.icss.hr.admin.dao;

import com.icss.hr.admin.pojo.Admin;

public interface AdminDao {
	
	/**
	 * 传入用户账号，返回账号数据
	 * @param adminName 用户账号
	 * @return 如果账号存在，返回Admin对象（账号，密码，级别），如果账号不存在，那么返回null
	 * @throws Exception
	 */
	Admin queryByName(String adminName) throws Exception;

}