package com.icss.oa.work.index;

import java.util.List;

import com.icss.oa.work.pojo.Schedule;

/**
 * ��װ�ܼ�¼���Ͳ�ѯ�������
 * 
 * @author Administrator
 * 
 */
public class ScheduleQueryResult {

	private int recordCount;// �����������ܼ�¼��
	private List<Schedule> recordList;// ���ݼ���

	public ScheduleQueryResult() {
		super();
	}

	public ScheduleQueryResult(int recordCount, List<Schedule> recordList) {
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

	public List<Schedule> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<Schedule> recordList) {
		this.recordList = recordList;
	}

}