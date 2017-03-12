package com.icss.oa.card.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icss.oa.common.Pager;
import com.icss.oa.card.pojo.Card;

@Repository
public class CardDaoImpl implements CardDao{
	
	@Autowired
	private SqlSessionFactory factory;
	
	public void insert(Card card) {
		SqlSession session = factory.openSession();
		session.insert("CARD.insert", card);		
	}
	
	public void update(Card card) {
		SqlSession session = factory.openSession();
		session.update("CARD.update", card);
	}
	
	public void delete(Integer GROUP_ID) {
		SqlSession session = factory.openSession();
		session.delete("CARD.delete", GROUP_ID);
	}
	
	public Card queryById(Integer GROUP_ID) {
		SqlSession session = factory.openSession();
		Card card = session.selectOne("CARD.queryById",GROUP_ID);
		return card;
	}

	public List<Card> query(Pager pager,Integer empId) {
		SqlSession session = factory.openSession();
		HashMap<String, Integer> map = new HashMap<String,Integer>();
		map.put("start", pager.getStart());
		map.put("end", pager.getStart() + pager.getPageSize() - 1);
		map.put("empId", empId);
		List<Card> list = session.selectList("CARD.query",map);
		return list;
	}
	
	public int getCount(Integer empId) {
		SqlSession session = factory.openSession();
		int count =  session.selectOne("CARD.getCount",empId);
		return count;
	}
}