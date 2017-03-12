package com.icss.hr.admin.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.admin.dao.AdminDao;
import com.icss.hr.admin.po.Admin;
import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.vo.AdminVo;

/**
 * ADMIN SERVICE实现类
 * 
 * @author Administrator
 * 
 */
@Transactional(rollbackFor=Exception.class)
public class AdminServiceImpl implements AdminService {

	private AdminDao dao;

	public void setDao(AdminDao dao) {
		this.dao = dao;
	}

	@Override
	public int checkLogin(AdminVo vo) {

		Admin admin = dao.queryByName(vo.getAdminName());

		int loginCheck = 4;// 判断标识，默认登陆成功

		if (admin == null) { // 用户名不存在
			loginCheck = 1;
		} else if (!admin.getAdminPwd().equals(vo.getAdminPwd())) { // 密码错误
			loginCheck = 2;
		} else if (!(admin.getAdminLevel().equals(vo.getAdminLevel()))) { // 级别错误
			loginCheck = 3;
		}

		return loginCheck;
	}

}