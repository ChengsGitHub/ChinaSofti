package com.icss.oa.assign.index;

import java.util.List;

import com.icss.oa.assign.pojo.Expinf;

/**
 * ��װ�ܼ�¼���Ͳ�ѯ�������
 * 
 * @author Administrator
 * 
 */
public class ExpinfQueryResult {

	private int recordCount;// �����������ܼ�¼��
	private List<Expinf> recordList;// ���ݼ���

	public ExpinfQueryResult() {
		super();
	}

	public ExpinfQueryResult(int recordCount, List<Expinf> recordList) {
		super();
		this.recordCount = recordCount;
		this.recordList = recordList;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public List<Expinf> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<Expinf> recordList) {
		this.recordList = recordList;
	}

}