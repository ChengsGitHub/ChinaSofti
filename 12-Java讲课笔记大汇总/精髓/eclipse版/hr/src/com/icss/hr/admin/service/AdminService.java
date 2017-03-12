package com.icss.hr.admin.service;

import com.icss.hr.admin.vo.AdminVo;

public interface AdminService {
	
	/**	 
	 * 
	 * @param vo 表单的数据 
	 * @return
	 * 传入用户VO数据
	 * 如果用户不存在，返回1
	 * 如果用户存在，密码错误，返回2
	 * 如果登陆级别不正确，返回3
	 * 如果用户名密码正确，返回4
	 * @throws Exception
	 */
	int checkLogin(AdminVo vo) throws Exception;

}
