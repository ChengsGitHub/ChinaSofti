package com.icss.oa.assign.dao;

import java.util.List;
import java.util.Map;

import com.icss.oa.assign.pojo.Expinf;
import com.icss.oa.common.Pager;

public interface ExpinfDao {
	void insert(Expinf expinf);
	void update(Expinf expinf);
	void delete(Integer expinfId);
	Expinf queryById(Integer expinfId);
	List<Expinf> query(Pager pager);
	int getCount();
	List<Map<String,Object>> query2(Pager pager);
	Expinf queryByUsername(String username);
	List<Expinf> queryByCondition(Pager pager,String expinfName);
	int getConditionCount(String expinfName);
	int getPrimaryKey();
	void uploadImg(Expinf expinf);
	Expinf download(Integer expinfId);
}
