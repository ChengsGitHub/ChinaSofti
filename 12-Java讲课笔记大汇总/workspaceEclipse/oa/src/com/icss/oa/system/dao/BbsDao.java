package com.icss.oa.system.dao;

import java.util.List;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Bbs;

public interface BbsDao {
	void insert(Bbs bbs);
	int getCount();
	Bbs queryById(Integer bbsId);
	 void delete(Integer bbsId);
	 void update(Bbs bbs);
	 void setTop(Integer setTopId);
	 void cancelTop(Integer setTopId);
	 List<Bbs> query(Pager pager);
	 List<Bbs> queryByTime(Pager pager);
	 List<Bbs> queryByTime1(Pager pager);
	 int getConditionCount(String bbsCont) ;
	 List<Bbs> queryByCondition(Pager pager,String bbsCont); 
}
