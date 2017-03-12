package com.icss.oa.emp1.service;

import java.util.List;
import java.util.Map;

import com.icss.oa.common.Pager;
import com.icss.oa.emp1.pojo.Emp1;

public interface Emp1Service {
	public void update(Emp1 emp1);
	public Emp1 queryById(Integer emp1Id);
	public List<Emp1> queryByName(String emp1Name);
	public List<Map<String,Object>> queryByOther(String emp1Name,Integer deptId,Integer jobId);
	public List<Emp1> query(Pager pager);
	public int getCount() ;
	public List<Map<String,Object>> query2(Pager pager);
	public Map checkUser(Emp1 emp1);
}
