package com.icss.oa.emp1.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.emp1.dao.PermDao;
import com.icss.oa.emp1.dao.PermDaoImpl;


@Service
@Transactional(rollbackFor = Exception.class)
public class PermServiceImpl implements  PermService{

	@Autowired
	private PermDao dao;

	/**
	 * �����û�����ѯȨ���б�
	 * @param username
	 * @return
	 */
	public List<Map<String,Object>> qyeryPerm(String username) {
		return dao.qyeryPerm(username);	
	}
	
	/**
	 * �����û�����ѯ��ɫ�б�
	 * @param username
	 * @return
	 */
	public List<Map<String,Object>> qyeryRole(String username) {
		return dao.qyeryRole(username);	
	}
	
}