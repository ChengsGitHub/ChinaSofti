package com.icss.oa.system.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.system.pojo.Role;

@Repository
public class RoleDaoImpl implements RoleDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	public List<Role> queryRole(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Role> list = session.selectList("ROLE.queryRole",map);
		return list;
	}
	
	
	public int getCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("ROLE.getCount");
		return count;
	}


	@Override
	public Role queryRoleId(Integer roleId) {
		SqlSession session = factory.openSession();
		Role role = session.selectOne("ROLE.queryRoleId",roleId);
		return role;
	}
}