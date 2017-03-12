package com.icss.oa.asserts.dao;

import java.util.List;
import com.icss.oa.asserts.pojo.Warehouse;
import com.icss.oa.common.Pager;

public interface WarehouseDao {
	void insert(Warehouse warehouse);
	void update(Warehouse warehouse);
	void delete(Integer id);
	Warehouse queryById(Integer id);
	List<Warehouse> query(Pager pager) ;
	int getContentCount();
	
}
