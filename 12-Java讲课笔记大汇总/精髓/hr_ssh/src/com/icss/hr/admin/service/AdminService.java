package com.icss.hr.admin.service;

import com.icss.hr.admin.vo.AdminVo;

/**
 * ADMIN SERVICE接口
 * @author Administrator
 *
 */
public interface AdminService {

	/**
	 * 传入AdminVo对象，返回一个数字
	 * 1 用户名不存在
	 * 2 密码不正确
	 * 3 权限选择不正确
	 * 4 登陆成功
	 */
	int checkLogin(AdminVo vo);	
	
}