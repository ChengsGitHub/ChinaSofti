package com.icss.hr.admin.service;

import com.icss.hr.admin.vo.AdminVo;

public interface AdminService {
	
	/**	 
	 * 
	 * @param vo �������� 
	 * @return
	 * �����û�VO����
	 * ����û������ڣ�����1
	 * ����û����ڣ�������󣬷���2
	 * �����½������ȷ������3
	 * ����û���������ȷ������4
	 * @throws Exception
	 */
	int checkLogin(AdminVo vo) throws Exception;

}
