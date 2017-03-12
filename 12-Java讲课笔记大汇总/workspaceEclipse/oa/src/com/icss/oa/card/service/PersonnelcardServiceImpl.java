package com.icss.oa.card.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.card.dao.PersonnelcardDao;
import com.icss.oa.card.pojo.Personnelcard;


@Service
@Transactional(rollbackFor = Exception.class)
public class PersonnelcardServiceImpl implements PersonnelcardService{

	@Autowired
	private PersonnelcardDao dao;

	public void insert(Personnelcard personnelcard) {
		dao.insert(personnelcard);
	}

	public void update(Personnelcard personnelcard) {
		dao.update(personnelcard);
	}

	public void delete(Integer cardId) {
		dao.delete(cardId);
	}

	public Personnelcard queryById(Integer cardId) {

		return dao.queryById(cardId);
	}

	public int getCount(Integer groupId) {

		return dao.getCount(groupId);
	}
	
	public Personnelcard queryByEmpId(Integer empId){
		return dao.queryByEmpID(empId);
	}
	
	public List<Map<String,Object>> query(Pager pager,Integer groupId) {
		return dao.query(pager,groupId);
	}

	public List<Personnelcard> querByCondition(Pager pager, String cardName,Integer empId) {

		return dao.queryByCondition(pager, cardName,empId);
	}
	
	public int getConditionCount(String cardName,Integer empId) {

		return dao.getConditionCount(cardName,empId);
	}
}
