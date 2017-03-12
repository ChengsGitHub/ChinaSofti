package com.icss.oa.work.index;

import java.util.List;

import com.icss.oa.work.pojo.Schedule;

/**
 * 封装总记录数和查询结果集合
 * 
 * @author Administrator
 * 
 */
public class ScheduleQueryResult {

	private int recordCount;// 满足条件的总记录数
	private List<Schedule> recordList;// 数据集合

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