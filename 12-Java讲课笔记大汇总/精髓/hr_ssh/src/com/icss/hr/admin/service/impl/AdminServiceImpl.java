package com.icss.hr.admin.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.admin.dao.AdminDao;
import com.icss.hr.admin.po.Admin;
import com.icss.hr.admin.service.AdminService;
import com.icss.hr.admin.vo.AdminVo;

/**
 * ADMIN SERVICEʵ����
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

		int loginCheck = 4;// �жϱ�ʶ��Ĭ�ϵ�½�ɹ�

		if (admin == null) { // �û���������
			loginCheck = 1;
		} else if (!admin.getAdminPwd().equals(vo.getAdminPwd())) { // �������
			loginCheck = 2;
		} else if (!(admin.getAdminLevel().equals(vo.getAdminLevel()))) { // �������
			loginCheck = 3;
		}

		return loginCheck;
	}

}