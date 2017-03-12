package com.icss.test;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.assign.index.ExpinfIndexDao;
import com.icss.oa.assign.index.ExpinfQueryResult;
import com.icss.oa.assign.pojo.Expinf;
import com.icss.oa.assign.service.ExpinfService;

public class TestExpinfIndexDao {

	private ExpinfIndexDao dao = new ExpinfIndexDao();

	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	private ExpinfService service = (ExpinfService) context.getBean(ExpinfService.class);

	/**
	 * 把当前员工数据全部生成索引
	 * 
	 * @throws IOException
	 */
	@Test
	public void testCreate() throws IOException {
		Pager pager = new Pager(service.getCount(), 1, service.getCount());
		List<Expinf> list = service.query(pager);

		for (Expinf e : list) {
			Document document = new Document();
			document.add(new TextField("expinfId", String.valueOf(e.getExpinfId()),
					Store.YES));
			document.add(new TextField("expinfName", e.getExpinfName(), Store.YES));
			document.add(new TextField("expinfSki", e.getExpinfSki(), Store.YES));
			document.add(new TextField("expinfExp", e.getExpinfExp(), Store.YES));

			dao.create(document);
		}

	}

	/**
	 * 查询测试
	 * 
	 * @throws IOException
	 * @throws ParseException 
	 * @throws InvalidTokenOffsetsException 
	 */
	@Test
	public void testSearch() throws IOException, ParseException, InvalidTokenOffsetsException {
		
		// 中文分词器
		Analyzer analyzer = new SmartChineseAnalyzer(Version.LUCENE_47);

		String queryStr = "这家伙很懒";
		QueryParser queryParser = new MultiFieldQueryParser(Version.LUCENE_47,
				new String[] { "expinfName", "expinfSki" , "expinfExp"}, analyzer);
		
		Query query = queryParser.parse(queryStr);
		
		ExpinfQueryResult queryResult = dao.search(query, 11, 10);
		
		int recordCount = queryResult.getRecordCount();
		System.out.println("总记录数：" + recordCount);
		
		List<Expinf> list = queryResult.getRecordList();
		
		for (Expinf e : list) {
			System.out.println(e);
		}
	}

}
