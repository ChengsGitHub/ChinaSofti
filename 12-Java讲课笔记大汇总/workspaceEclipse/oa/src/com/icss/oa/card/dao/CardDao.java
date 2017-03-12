package com.icss.oa.card.dao;

import java.util.List;

import com.icss.oa.card.pojo.Card;
import com.icss.oa.common.Pager;

public interface CardDao {
	void insert(Card card);
	 void update(Card card);
	 void delete(Integer GROUP_ID);
	 Card queryById(Integer GROUP_ID);
	 List<Card> query(Pager pager,Integer empId);
	 int getCount(Integer empId) ;
}
