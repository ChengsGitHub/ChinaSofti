package com.icss.oa.assign.service;

import java.util.List;

import com.icss.oa.assign.pojo.Exphistory;

public interface ExphistoryService {
	void insert(Exphistory exphistory);
	void update(Exphistory exphistory);
	 void delete(Integer exphistoryId2);
	 Exphistory queryById(Integer exphistoryId1);
	 List<Exphistory> query(Integer expinfId);
	 int getCount();
}
