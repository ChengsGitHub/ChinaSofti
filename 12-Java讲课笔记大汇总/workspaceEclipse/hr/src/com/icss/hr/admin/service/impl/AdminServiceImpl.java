package com.icss.hr.admin.service.impl;

import com.icss.hr.admin.dao.AdminDao;
import com.icss.hr.admin.dao.impl.AdminDaoImpl;
import com.icss.hr.admin.pojo.Admin;
import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.vo.AdminVo;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao dao = new AdminDaoImpl();

	@Override
	public int checkLogin(AdminVo vo) throws Exception {
		
		Admin admin = dao.queryByName(vo.getAdminName());
		
		if (admin == null) {
			return 1;
		} else if (!vo.getAdminPwd().equals(admin.getAdminPwd())) {
			return 2;
		} else if (vo.getAdminLevel() != admin.getAdminLevel()) {
			return 3;
		} else {
			return 4;
		}
		
	}

}
