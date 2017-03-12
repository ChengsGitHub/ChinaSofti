package com.icss.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.card.dao.CardDao;
import com.icss.oa.card.pojo.Card;

public class TestCardDao {

	
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	private CardDao dao = (CardDao) context.getBean(CardDao.class);
	
	
	@Test
	public void getCount(){
		int count = dao.getCount(2);
		System.out.println(count);
	}
	

	@Test
	public void testInsert() {
		Card card  = new Card("Í¬°àµÄ",2);
		dao.insert(card);
	}
	
	@Test
	public void testUpdate(){
		Card card = new Card(4,"555",2);
		dao.update(card);
	}
	
	@Test
	public void testDelete(){
		dao.delete(3);
	}
	
	@Test
	public void testInsertMany() {
		for (int i = 1;i <= 20;i ++) {
		Card card = new Card("Í¬×À",2);
			dao.insert(card);
		}
	}
	
	@Test
	public void testQuerybyID(){
		Card card = dao.queryById(8);
		System.out.println(card);
	}
	
	@Test
	public void testQuery(){
		Pager pager = new Pager(dao.getCount(1),1);
		List<Card> list = dao.query(pager,2);
		for(Card card : list){
			System.out.println(card);	
		}
	}
}
