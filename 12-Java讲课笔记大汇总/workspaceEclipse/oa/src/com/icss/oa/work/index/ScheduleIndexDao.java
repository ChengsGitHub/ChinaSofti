package com.icss.oa.work.index;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.springframework.stereotype.Component;

import com.icss.oa.common.Global;
import com.icss.oa.work.pojo.Schedule;

/**
 * 增加，删除，修改，查询索引
 * 
 */
@Component
public class ScheduleIndexDao {

	// 索引目录路径
	public String indexPath = Global.INDEX_PATH;

	// 中文分词器
	public Analyzer analyzer = new SmartChineseAnalyzer(Version.LUCENE_47);

	/**
	 * 增加索引
	 */
	public void create(Document document) throws IOException {
		// 设置索引的分词器
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47,
				analyzer);
		// 索引目录
		Directory directory = FSDirectory.open(new File(indexPath));

		IndexWriter indexWriter = new IndexWriter(directory, config);
		indexWriter.addDocument(document);
		indexWriter.commit();
		indexWriter.close();

		System.out.println("项目索引被添加");
	}

	/**
	 * 根据Term条件删除索引，如果是数据库，根据ID就可以了
	 * 
	 * Term是搜索的最小单位，代表某个 Field 中的一个关键词，如：<title, lucene>
	 * 
	 * new Term( "title", "lucene" );
	 * 
	 * new Term( "id", "5" );
	 * 
	 * new Term( "id", UUID );
	 * 
	 * @param term
	 * @throws IOException
	 */
	public void delete(Term term) throws IOException {

		// 设置索引的分词器
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47,
				analyzer);
		// 索引目录
		Directory directory = FSDirectory.open(new File(indexPath));

		IndexWriter indexWriter = new IndexWriter(directory, config);
		indexWriter.deleteDocuments(term);
		indexWriter.commit();
		indexWriter.close();
		
		System.out.println("删除索引");
	}

	/**
	 * 根据Term条件更新索引
	 * 
	 * @throws IOException
	 */
	public void update(Term term, Document document) throws IOException {
		// 设置索引的分词器
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47,
				analyzer);
		// 索引目录
		Directory directory = FSDirectory.open(new File(indexPath));
		IndexWriter indexWriter = new IndexWriter(directory, config);
		indexWriter.updateDocument(term, document);
		indexWriter.commit();
		indexWriter.close();
		
		System.out.println("更新索引");
	}

	/**
	 * 分页显示查询结果
	 * 
	 * @return
	 * @throws IOException
	 * @throws InvalidTokenOffsetsException
	 */
	public ScheduleQueryResult search(Query query, int firstResult, int maxResults)
			throws IOException, InvalidTokenOffsetsException {

		// 设置索引的分词器
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47,
				analyzer);

		// 索引目录
		Directory directory = FSDirectory.open(new File(indexPath));

		// IndexSearcher是用来搜索用的
		IndexReader ir = DirectoryReader.open(directory);
		IndexSearcher indexSearcher = new IndexSearcher(ir);
	

		// 得到满足条件的前1000行
		TopDocs topDocs = indexSearcher.search(query, 1000);

		// 总记录数
		int recordCount = topDocs.totalHits;

		// 文档集合
		List<Schedule> recordList = new ArrayList<Schedule>();

		// ============高亮和截取某个字段的文本摘要设置=============
		// 设置环绕的首尾字符串
		SimpleHTMLFormatter formatter = new SimpleHTMLFormatter(
				"<span style=\"color:red\">", "</span>");
		// 语法高亮显示设置
		Highlighter highlighter = new Highlighter(formatter, new QueryScorer(
				query));
		// 100是是表示摘要的字数
		highlighter.setTextFragmenter(new SimpleFragmenter(100));
		// ===================================================

		/* 获得当前页的数据 */
		int end = Math.min(firstResult - 1 + maxResults, topDocs.totalHits);// 终止下标
				
		for (int i = firstResult - 1; i < end; i++) {
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			int docSn = scoreDoc.doc; // 文档内部编号
			Document doc = indexSearcher.doc(docSn); // 根据编号取出相应的文档

			String scheduleSch = doc.get("scheduleSch");
			TokenStream tream = analyzer.tokenStream("scheduleSch", new StringReader(
					scheduleSch));
			String searchResultScheduleSch = highlighter.getBestFragment(tream, scheduleSch);

			// 如果内容 不包含关键字，会返回null，就截取前100个字符
			if (searchResultScheduleSch == null) {
				int minLen = scheduleSch.length() >= 100 ? 100 : scheduleSch
						.length();
				searchResultScheduleSch = scheduleSch.substring(0, minLen);
			}
			
			Schedule schedule = new Schedule();
			schedule.setScheduleId(Integer.parseInt(doc.get("scheduleId")));
			schedule.setScheduleSch(searchResultScheduleSch);

			recordList.add(schedule);
		}

		ir.close();

		return new ScheduleQueryResult(recordCount, recordList);
	}

}