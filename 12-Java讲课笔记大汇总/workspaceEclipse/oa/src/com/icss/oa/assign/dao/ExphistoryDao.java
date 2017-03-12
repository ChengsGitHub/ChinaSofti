package com.icss.oa.assign.dao;

import java.util.List;

import com.icss.oa.assign.pojo.Exphistory;

public interface ExphistoryDao {
	void insert(Exphistory exphistory);
	void update(Exphistory exphistory);
	void delete(Integer exphistoryId2);
	Exphistory queryById(Integer exphistoryId1);
	List<Exphistory> query(Integer expinfId);
	int getCount();
}
