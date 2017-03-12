package com.icss.hr.admin.service.impl;

import com.icss.hr.admin.dao.impl.AdminDaoImpl;
import com.icss.hr.admin.po.Admin;
import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.vo.AdminVo;

public class AdminServiceImpl implements AdminService {
	
	private AdminDaoImpl dao = new AdminDaoImpl();

	/**
	 * 返回值
	 * 1  用户名不存在
	 * 2 密码错误
	 * 3 级别错误
	 * 4 登陆成功
	 * @throws Exception 
	 */
	@Override
	public int checkLogin(AdminVo vo) throws Exception {
		
		Admin admin = dao.queryByName(vo.getAdminName());
		
		if (admin == null)
			return 1;
		else if (!vo.getAdminPwd().equals(admin.getAdminPwd()))
			return 2;
		else if (vo.getAdminLevel() != admin.getAdminLevel())
			return 3;		
		
		return 4;
	}

}