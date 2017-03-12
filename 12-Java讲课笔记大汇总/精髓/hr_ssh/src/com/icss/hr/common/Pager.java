package com.icss.hr.common;

/**
 * 分页工具类
 * @author Administrator
 *
 */
public class Pager {
	
	private int recordCount;//总记录数
	
	private int pageSize = 10;//每页XX条
	
	private int pageCount;//共XX页
	
	private int pageNum;//当前页码
	
	private int start;//本页起始位置
	
	/**
	 * 构造器：传入总记录数和当前页码
	 * @param recordCount
	 * @param pageNum
	 */
	public Pager(int recordCount,int pageNum) {
		
		this.recordCount = recordCount;
		this.pageNum = pageNum;
		
		//计算总页数 
		pageCount = (this.recordCount - 1) / this.pageSize + 1;
		
		//判断页码
		if (this.pageNum < 1)
			this.pageNum = 1;
		if (this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;
		
		//计算本页起始位置
		this.start = (this.pageNum - 1) * this.pageSize + 1;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	
}