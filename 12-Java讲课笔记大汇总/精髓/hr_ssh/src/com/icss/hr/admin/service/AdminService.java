package com.icss.hr.admin.service;

import com.icss.hr.admin.vo.AdminVo;

/**
 * ADMIN SERVICE�ӿ�
 * @author Administrator
 *
 */
public interface AdminService {

	/**
	 * ����AdminVo���󣬷���һ������
	 * 1 �û���������
	 * 2 ���벻��ȷ
	 * 3 Ȩ��ѡ����ȷ
	 * 4 ��½�ɹ�
	 */
	int checkLogin(AdminVo vo);	
	
}