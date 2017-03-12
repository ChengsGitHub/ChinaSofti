package com.icss.oa.asserts.dao;

import java.util.List;

import com.icss.oa.asserts.pojo.Offsup;
import com.icss.oa.common.Pager;

public interface OffsupDao {
	void insert(Offsup offsup);
	void update(Offsup offsup);
	void delete(Integer id);
	Offsup queryById(Integer id);
	List<Offsup> query(Pager pager) ;
	int getContentCount();
	
}
