package com.icss.hr.common;

/**
 * ��ҳ������
 * @author Administrator
 *
 */
public class Pager {
	
	private int recordCount;//�ܼ�¼��
	
	private int pageSize = 10;//ÿҳXX��
	
	private int pageCount;//��XXҳ
	
	private int pageNum;//��ǰҳ��
	
	private int start;//��ҳ��ʼλ��
	
	/**
	 * �������������ܼ�¼���͵�ǰҳ��
	 * @param recordCount
	 * @param pageNum
	 */
	public Pager(int recordCount,int pageNum) {
		
		this.recordCount = recordCount;
		this.pageNum = pageNum;
		
		//������ҳ�� 
		pageCount = (this.recordCount - 1) / this.pageSize + 1;
		
		//�ж�ҳ��
		if (this.pageNum < 1)
			this.pageNum = 1;
		if (this.pageNum > this.pageCount)
			this.pageNum = this.pageCount;
		
		//���㱾ҳ��ʼλ��
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