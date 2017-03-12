package com.icss.oa.emp1.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.emp1.dao.Emp1Dao;
import com.icss.oa.emp1.pojo.Emp1;

@Service
@Transactional(rollbackFor = Exception.class)
public class Emp1ServiceImpl implements Emp1Service{

	@Autowired
	private Emp1Dao dao;

	
	public void update(Emp1 emp1) {
		dao.update(emp1);
	}

	

	public Emp1 queryById(Integer emp1Id) {

		return dao.queryById(emp1Id);
	}
	
	
	public List<Emp1> queryByName(String emp1Name) {

		return dao.queryByName(emp1Name);
	}

	
	public List<Map<String,Object>> queryByOther(String emp1Name,Integer deptId,Integer jobId) {
		return dao.queryByOther(emp1Name, deptId, jobId);
	}
	public List<Emp1> query(Pager pager) {

		return dao.query(pager);
	}

	public int getCount() {

		return dao.getCount();
	}
	
	public List<Map<String,Object>> query2(Pager pager) {
		return dao.query2(pager);
	}
	/**
	 * 传入用户名和密码
	 * 
	 * @return 返回1 用户名不存在 2 密码错误 3 登陆成功
	 */
	public Map checkUser(Emp1 emp1)   {
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		Emp1 emp1Obj = dao.queryByUsername(emp1.getUsername());
		
		if (emp1Obj == null) {
			map.put("flag", 1);
		} else if (!emp1.getPassword().equals(emp1Obj.getPassword())) {
			map.put("flag", 2);
		} else {
			map.put("flag", 3);
		}
		
		map.put("emp1", emp1Obj);
		
		return map;		
	}

}