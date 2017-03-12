package com.icss.oa.assign.service;

import java.util.List;

import com.icss.oa.assign.pojo.Assigncom;
import com.icss.oa.common.Pager;

public interface AssigncomService {
	void insert(Assigncom assigncom);
	void update(Assigncom assigncom);
	void delete(Integer assigncomId);
	Assigncom queryById(Integer assigncomId);
	List<Assigncom> query(Pager pager);
	int getCount();
}
