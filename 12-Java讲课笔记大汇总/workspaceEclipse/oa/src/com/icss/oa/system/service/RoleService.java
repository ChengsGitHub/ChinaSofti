package com.icss.oa.system.service;

import java.util.List;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.system.pojo.Role;

public interface RoleService {
	public List<Role> queryRole(Pager pager);
	public Role queryRoleId(Integer roleId) ;
	public int getCount();
}
