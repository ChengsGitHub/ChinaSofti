package com.icss.oa.asserts.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import com.icss.oa.asserts.pojo.Offsup;
import com.icss.oa.common.Pager;

public interface OffsupService {
	void insert(Offsup offsup);
	void update(Offsup offsup);
	void delete(Integer offsupId);
	Offsup queryById(Integer offsupId);
	List<Offsup> query(Pager pager);
	int getContentCount();
	void exportExcel(OutputStream os) throws IOException;
}
