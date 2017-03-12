package com.icss.oa.asserts.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import com.icss.oa.asserts.pojo.Warehouse;
import com.icss.oa.common.Pager;

public interface WarehouseService {
	void insert(Warehouse offsup);
	void update(Warehouse offsup);
	void delete(Integer offsupId);
	Warehouse queryById(Integer warehouse);
	List<Warehouse> query(Pager pager);
	int getContentCount();
}
