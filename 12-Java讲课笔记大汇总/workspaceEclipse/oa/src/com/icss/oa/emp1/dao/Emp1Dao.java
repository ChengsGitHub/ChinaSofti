package com.icss.oa.emp1.dao;

import java.util.List;
import java.util.Map;

import com.icss.oa.common.Pager;
import com.icss.oa.emp1.pojo.Emp1;

public interface Emp1Dao {
	public void update(Emp1 emp1);
	public Emp1 queryById(Integer emp1Id);
	public List<Emp1> queryByName(String emp1Name);
	public List<Map<String,Object>> queryByOther(String emp1Name,Integer deptID,Integer jobID);
	public List<Emp1> query(Pager pager) ;
	public int getCount() ;
	public List<Map<String,Object>> query2(Pager pager);
	public Emp1 queryByUsername(String username);
}
