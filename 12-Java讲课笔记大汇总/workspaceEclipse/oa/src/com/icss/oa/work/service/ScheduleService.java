package com.icss.oa.work.service;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.util.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.oa.common.Pager;
import com.icss.oa.work.dao.ScheduleDao;
import com.icss.oa.work.index.ScheduleIndexDao;
import com.icss.oa.work.index.ScheduleQueryResult;
import com.icss.oa.work.pojo.Schedule;

@Service
@Transactional(rollbackFor = Exception.class)
public class ScheduleService {

	@Autowired
	private ScheduleDao dao;

	private ScheduleIndexDao indexDao = new ScheduleIndexDao();

	public void insert(Schedule schedule) throws IOException {

		dao.insert(schedule);
	
		// 创建索引
		Document document = new Document();
		document.add(new TextField("scheduleId", String.valueOf(dao.getPrimaryKey()),Store.YES));
		document.add(new TextField("scheduleSch", schedule.getScheduleSch(), Store.YES));
		indexDao.create(document);
	}

	public void update(Schedule schedule) throws IOException {
		dao.update(schedule);

		// 更新索引
		Document document = new Document();

		Term term = new Term("scheduleId", String.valueOf(schedule.getScheduleId()));

		document.add(new TextField("scheduleId", String.valueOf(schedule.getScheduleId()),
				Store.YES));
		document.add(new TextField("scheduleSch", schedule.getScheduleSch(), Store.YES));

		indexDao.update(term, document);
	}

	public void delete(Integer scheduleId) throws IOException {
		dao.delete(scheduleId);

		// 删除索引
		Term term = new Term("scheduleId", String.valueOf(scheduleId));
		indexDao.delete(term);

		// 级联删除员工照片
	}

	/**
	 * 全文检索
	 * @param queryStr
	 * @return
	 * @throws Exception 
	 */
	public ScheduleQueryResult queryByIndex(String queryStr,Pager pager) throws Exception {
		// 中文分词器
		Analyzer analyzer = new SmartChineseAnalyzer(Version.LUCENE_47);
		
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_47,
				new String[] { "scheduleId", "scheduleSch" }, analyzer);

		Query query = queryParser.parse(queryStr);

		ScheduleQueryResult queryResult = indexDao.search(query, pager.getStart(), pager.getPageSize());
		
		return queryResult;
	}

	public Schedule queryById(Integer scheduleId) {

		return dao.queryById(scheduleId);
	}

	public List<Schedule> query(Pager pager, Integer scheduleEmpid) {

		return dao.query(pager, scheduleEmpid);
	}

	public List<Schedule> querByCondition(Pager pager, String scheduleName) {

		return dao.queryByCondition(pager, scheduleName);
	}

	public int getCount(Integer scheduleempid) {

		return dao.getCount(scheduleempid);
	}

	public int getConditionCount(String scheduleName) {

		return dao.getConditionCount(scheduleName);
	}

}