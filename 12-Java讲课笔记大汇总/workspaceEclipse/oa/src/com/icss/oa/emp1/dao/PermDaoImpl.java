package com.icss.oa.emp1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PermDaoImpl implements PermDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	/**
	 * �����û�����ѯȨ���б�
	 * @param username
	 * @return
	 */
	public List<Map<String,Object>> qyeryPerm(String username) {
		SqlSession sqlSession = factory.openSession();
		List<Map<String,Object>> list = sqlSession.selectList("PERM.queryPerm", username);
		return list;		
	}
	
	/**
	 * �����û�����ѯ��ɫ�б�
	 * @param username
	 * @return
	 */
	public List<Map<String,Object>> qyeryRole(String username) {
		SqlSession sqlSession = factory.openSession();
		List<Map<String,Object>> list = sqlSession.selectList("PERM.queryRole", username);
		return list;		
	}
	
}