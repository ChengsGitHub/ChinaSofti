package com.icss.oa.asserts.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.asserts.dao.WarehouseDao;
import com.icss.oa.asserts.pojo.Warehouse;

@Service
@Transactional(rollbackFor = Exception.class)
public class WarehouseServiceImpl implements WarehouseService{

	@Autowired
	private WarehouseDao dao;

	public void insert(Warehouse warehouse) {
		dao.insert(warehouse);
	}

	public void update(Warehouse warehouse) {
		dao.update(warehouse);
	}

	public void delete(Integer WarehouseId) {
		dao.delete(WarehouseId);
	}

	public Warehouse queryById(Integer warehouse) {

		return dao.queryById(warehouse);
	}

	public List<Warehouse> query(Pager pager) {

		return dao.query(pager);
	}

	public int getContentCount() {

		return dao.getContentCount();
	}

}