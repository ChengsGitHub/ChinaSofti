package com.icss.oa.system.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.BbsDao;
import com.icss.oa.system.pojo.Bbs;
import com.icss.oa.system.pojo.Dept;
import com.icss.oa.system.pojo.Emp;

@Service
@Transactional(rollbackFor = Exception.class)
public class BbsServiceImpl implements  BbsService{

	@Autowired
	private BbsDao dao;
	
	public void insert(Bbs bbs) {
		dao.insert(bbs);
	}
	
	public void update(Bbs bbs) {
		dao.update(bbs);
	}
	
	public void setTop(Integer setTopId) {
		dao.setTop(setTopId);
	}
	
	public void cancelTop(Integer setTopId) {
		dao.cancelTop(setTopId);
	}
	
	public int getCount() {

		return dao.getCount();
	}
	public Bbs queryById(Integer deptId) {

		return dao.queryById(deptId);
	}

	public List<Bbs> query(Pager pager) {

		return dao.query(pager);
	}
	public List<Bbs> queryByTime(Pager pager){
		return dao.queryByTime(pager);
	}

	public List<Bbs> queryByTime1(Pager pager){
		return dao.queryByTime1(pager);
	}
	public void delete(Integer bbsId) {
		dao.delete(bbsId);
	}
	public int getConditionCount(String bbsCont) {

		return dao.getConditionCount(bbsCont);
	}
	public List<Bbs> querByCondition(Pager pager,String bbsCont) {

		return dao.queryByCondition(pager, bbsCont);
	}

}
