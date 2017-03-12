package com.icss.oa.card.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.card.dao.CardDao;
import com.icss.oa.card.pojo.Card;

@Service
@Transactional(rollbackFor = Exception.class)
public class CardServiceImpl implements  CardService{

	@Autowired
	private CardDao dao;

	public void insert(Card card) {
		dao.insert(card);
	}

	public void update(Card card) {
		dao.update(card);
	}

	public void delete(Integer GROUP_ID) {
		dao.delete(GROUP_ID);
	}

	public Card queryById(Integer GROUP_ID) {

		return dao.queryById(GROUP_ID);
	}

	public List<Card> query(Pager pager,Integer empId) {

		return dao.query(pager,empId);
	}

	public int getCount(Integer empId) {

		return dao.getCount(empId);
	}

}
