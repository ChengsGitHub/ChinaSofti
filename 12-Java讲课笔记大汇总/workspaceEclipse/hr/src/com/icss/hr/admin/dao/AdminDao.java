package com.icss.hr.admin.dao;

import com.icss.hr.admin.pojo.Admin;

public interface AdminDao {
	
	/**
	 * �����û��˺ţ������˺�����
	 * @param adminName �û��˺�
	 * @return ����˺Ŵ��ڣ�����Admin�����˺ţ����룬���𣩣�����˺Ų����ڣ���ô����null
	 * @throws Exception
	 */
	Admin queryByName(String adminName) throws Exception;

}