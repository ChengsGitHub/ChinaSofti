package com.icss.oa.system.dao;

import java.util.List;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.system.pojo.Role;

public interface RoleDao {
	public List<Role> queryRole(Pager pager) ;
	public int getCount();
	public Role queryRoleId(Integer roleId);
}
