package com.icss.hr.common;

/**
 * 分页工具类
 *
 */
public class Pager {
	
	private int recordCount;//总记录数
	
	private int pageSize = 6;//每页多少条
	
	private int totalPage;//共几页
	
	private int pageNum;//当前是第几页
	
	private int start;//起始位置
	
	public Pager(int recordCount,int pageNum) {
		this.recordCount = recordCount;
		this.pageNum = pageNum;
		
		this.totalPage = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0)
			this.totalPage ++;
		
		if (this.pageNum < 1)
			this.pageNum = 1;
		if (this.pageNum > this.totalPage)
			this.pageNum = this.totalPage;
		
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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