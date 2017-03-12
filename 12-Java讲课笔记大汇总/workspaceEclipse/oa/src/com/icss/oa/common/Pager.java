package com.icss.oa.common;

public class Pager {
	
	private int recordCount;//�ܼ�¼��
	
	private int pageSize = 7;//ÿҳ������
	
	private int pageCount;//����ҳ
	
	private int pageNum;//��ǰҳ��
	
	private int start;//��ǰҳ�ļ�¼��ʼλ��
	public Pager(int pageNum) {

		this.pageNum = pageNum;

		// ��ǰҳ��
		if (this.pageNum < 1)
			this.pageNum = 1;

		// ��ʼλ��
		this.start = (this.pageNum - 1) * this.pageSize + 1;
	}
	public Pager(int recordCount,int pageNum) {
		this.recordCount = recordCount;
		this.pageNum = pageNum;
		
		//���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0) {
			this.pageCount ++;
		}
		
		//���㵱ǰҳ��
		if (this.pageNum < 1)
			this.pageNum = 1;
		if (this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;
		
		//������ʼλ��
		this.start = (this.pageNum - 1) * this.pageSize + 1;		
	}
	
	public Pager(int recordCount,int pageNum,int pageSize) {
		this.recordCount = recordCount;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		
		//���㹲��ҳ
		this.pageCount = this.recordCount / this.pageSize;
		if (this.recordCount % this.pageSize != 0) {
			this.pageCount ++;
		}
		
		//���㵱ǰҳ��
		if (this.pageNum < 1)
			this.pageNum = 1;
		if (this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;
		
		//������ʼλ��
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



	public static void main(String[] args) {
		Pager pager = new Pager(20,-5);
		System.out.println(pager.start);
	}

}