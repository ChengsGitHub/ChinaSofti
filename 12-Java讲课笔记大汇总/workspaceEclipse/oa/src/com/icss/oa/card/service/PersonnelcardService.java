package com.icss.oa.card.service;

import java.util.List;
import java.util.Map;

import com.icss.oa.card.pojo.Personnelcard;
import com.icss.oa.common.Pager;

public interface PersonnelcardService {
	void insert(Personnelcard personnelcard);
	void update(Personnelcard personnelcard);
	void delete(Integer cardId);
	Personnelcard queryById(Integer cardId);
	int getCount(Integer groupId);
	Personnelcard queryByEmpId(Integer empId);
	List<Map<String,Object>> query(Pager pager,Integer groupId);
	List<Personnelcard> querByCondition(Pager pager, String cardName,Integer empId);
	int getConditionCount(String cardName,Integer empId);
}
