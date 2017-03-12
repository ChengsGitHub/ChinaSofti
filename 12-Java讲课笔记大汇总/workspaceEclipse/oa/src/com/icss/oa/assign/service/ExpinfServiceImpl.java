package com.icss.oa.assign.service;

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
import com.icss.oa.assign.dao.ExpinfDao;
import com.icss.oa.assign.index.ExpinfIndexDao;
import com.icss.oa.assign.index.ExpinfQueryResult;
import com.icss.oa.assign.pojo.Expinf;

@Service
@Transactional(rollbackFor = Exception.class)
public class ExpinfServiceImpl implements ExpinfService {

	@Autowired
	private ExpinfDao dao;

	private ExpinfIndexDao indexDao = new ExpinfIndexDao();

	public void insert(Expinf expinf) throws IOException {

		dao.insert(expinf);

		// 创建索引
		Document document = new Document();
		document.add(new TextField("expinfId", String.valueOf(dao.getPrimaryKey()),Store.YES));
		document.add(new TextField("expinfName", expinf.getExpinfName(), Store.YES));
		document.add(new TextField("expinfSki", expinf.getExpinfSki(), Store.YES));
		document.add(new TextField("expinfExp", expinf.getExpinfExp(), Store.YES));
		indexDao.create(document);
	}

	public void update(Expinf expinf) throws IOException {
		dao.update(expinf);

		// 更新索引
		Document document = new Document();

		Term term = new Term("expinfId", String.valueOf(expinf.getExpinfId()));

		document.add(new TextField("expinfId", String.valueOf(expinf.getExpinfId()),
				Store.YES));
		document.add(new TextField("expinfName", expinf.getExpinfName(), Store.YES));
		document.add(new TextField("expinfSk", expinf.getExpinfSki(), Store.YES));
		document.add(new TextField("expinfExp", expinf.getExpinfExp(), Store.YES));

		indexDao.update(term, document);
	}

	public void delete(Integer expinfId) throws IOException {
		dao.delete(expinfId);

		// 删除索引
		Term term = new Term("expinfId", String.valueOf(expinfId));
		indexDao.delete(term);

		// 级联删除员工照片
	}

	/**
	 * 全文检索
	 * @param queryStr
	 * @return
	 * @throws Exception 
	 */
	public ExpinfQueryResult queryByIndex(String queryStr,Pager pager) throws Exception {
		// 中文分词器
		Analyzer analyzer = new SmartChineseAnalyzer(Version.LUCENE_47);
		
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_47,
				new String[] { "expinfName", "expinfSki", "expinfExp" }, analyzer);

		Query query = queryParser.parse(queryStr);

		ExpinfQueryResult queryResult = indexDao.search(query, pager.getStart(), pager.getPageSize());
		
		return queryResult;
	}

	public Expinf queryById(Integer expinfId) {

		return dao.queryById(expinfId);
	}

	public List<Expinf> query(Pager pager) {

		return dao.query(pager);
	}

	public List<Expinf> querByCondition(Pager pager, String expinfName) {

		return dao.queryByCondition(pager, expinfName);
	}

	public int getCount() {

		return dao.getCount();
	}

	public int getConditionCount(String expinfName) {

		return dao.getConditionCount(expinfName);
	}
	
	public void uploadImg(Expinf expinf){
		
		dao.uploadImg(expinf);
	}
	
	public Expinf download(Integer expinfId){
		
		return dao.download(expinfId);
	}


}