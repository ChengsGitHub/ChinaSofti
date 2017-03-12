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
	 * 根据用户名查询权限列表
	 * @param username
	 * @return
	 */
	public List<Map<String,Object>> qyeryPerm(String username) {
		SqlSession sqlSession = factory.openSession();
		List<Map<String,Object>> list = sqlSession.selectList("PERM.queryPerm", username);
		return list;		
	}
	
	/**
	 * 根据用户名查询角色列表
	 * @param username
	 * @return
	 */
	public List<Map<String,Object>> qyeryRole(String username) {
		SqlSession sqlSession = factory.openSession();
		List<Map<String,Object>> list = sqlSession.selectList("PERM.queryRole", username);
		return list;		
	}
	
}