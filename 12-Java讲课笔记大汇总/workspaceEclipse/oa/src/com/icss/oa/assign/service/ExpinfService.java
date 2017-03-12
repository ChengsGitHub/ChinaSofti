package com.icss.oa.assign.service;

import java.io.IOException;
import java.util.List;

import com.icss.oa.assign.index.ExpinfQueryResult;
import com.icss.oa.assign.pojo.Expinf;
import com.icss.oa.common.Pager;

public interface ExpinfService {
	void insert(Expinf expinf) throws IOException;
	void update(Expinf expinf) throws IOException;
	void delete(Integer expinfId) throws IOException;
	ExpinfQueryResult queryByIndex(String queryStr,Pager pager) throws Exception;
	Expinf queryById(Integer expinfId);
	List<Expinf> query(Pager pager) ;
	List<Expinf> querByCondition(Pager pager, String expinfName);
	int getCount();
	int getConditionCount(String expinfName);
	void uploadImg(Expinf expinf);
	Expinf download(Integer expinfId);
}
