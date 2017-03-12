package com.icss.oa.system.service;

import java.util.List;

import com.icss.oa.common.Pager;
import com.icss.oa.system.pojo.Bbs;

public interface BbsService {
	 void insert(Bbs bbs);
	 void update(Bbs bbs);
	 void setTop(Integer setTopId);
	 void cancelTop(Integer setTopId);
	 int getCount();
	 Bbs queryById(Integer deptId);
	 List<Bbs> query(Pager pager);
	 List<Bbs> queryByTime(Pager pager);
	 List<Bbs> queryByTime1(Pager pager);
	 void delete(Integer bbsId);
	 int getConditionCount(String bbsCont);
	 List<Bbs> querByCondition(Pager pager,String bbsCont);
}
