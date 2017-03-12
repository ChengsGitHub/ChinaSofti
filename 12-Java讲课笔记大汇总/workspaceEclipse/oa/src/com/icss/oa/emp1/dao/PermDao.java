package com.icss.oa.emp1.dao;

import java.util.List;
import java.util.Map;

public interface PermDao {
	public List<Map<String,Object>> qyeryPerm(String username);
	public List<Map<String,Object>> qyeryRole(String username) ;
}
