package com.icss.oa.asserts.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.asserts.pojo.Warehouse;

@Repository
public class WarehouseDaoImpl implements  WarehouseDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Warehouse warehouse) {
		SqlSession session = factory.openSession();
		session.insert("WAREHOUSE.insert", warehouse);		
	}
	
	public void update(Warehouse warehouse) {
		SqlSession session = factory.openSession();
		session.update("WAREHOUSE.update", warehouse);
	}
	
	public void delete(Integer id) {
		SqlSession session = factory.openSession();
		session.delete("WAREHOUSE.delete", id);
	}
	
	public Warehouse queryById(Integer id) {
		SqlSession session = factory.openSession();
		Warehouse warehouse = session.selectOne("WAREHOUSE.queryById",id);
		return warehouse;
	}

	public List<Warehouse> query(Pager pager) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		List<Warehouse> list = session.selectList("WAREHOUSE.query",map);
		return list;
	}
	
	public int getContentCount() {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("WAREHOUSE.getContentCount");
		return count;
	}
}