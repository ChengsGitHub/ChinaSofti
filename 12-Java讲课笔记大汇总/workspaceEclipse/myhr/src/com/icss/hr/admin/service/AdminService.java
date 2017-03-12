package com.icss.hr.admin.service;

import com.icss.hr.admin.vo.AdminVo;

public interface AdminService {
	
	int checkLogin(AdminVo vo) throws Exception;

}