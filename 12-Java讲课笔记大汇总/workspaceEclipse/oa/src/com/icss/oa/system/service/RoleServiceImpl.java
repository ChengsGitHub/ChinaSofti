package com.icss.oa.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.RoleDao;
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.system.pojo.Role;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao dao;

	public List<Role> queryRole(Pager pager) {

		return dao.queryRole(pager);
	}

	public int getCount() {

		return dao.getCount();
	}
	public Role queryRoleId(Integer roleId) {

		return dao.queryRoleId(roleId);
	}

}
