package com.icss.oa.card.dao;

import java.util.List;
import java.util.Map;

import com.icss.oa.card.pojo.Personnelcard;
import com.icss.oa.common.Pager;

public interface PersonnelcardDao {
	void insert(Personnelcard personnelcard);
	void update(Personnelcard personnelcard);
	 void delete(Integer cardId);
	 Personnelcard queryById(Integer cardId);
	 List<Map<String,Object>> query(Pager pager,Integer groupId);
	 int getCount(Integer groupId);
	 Personnelcard queryByEmpID(Integer empId);
	 List<Map<String,Object>> query2(Pager pager) ;
	 List<Personnelcard> queryByCondition(Pager pager,String cardName,Integer empId);
	 int getConditionCount(String cardName,Integer empId);
}
