package com.icss.oa.assign.index;

import java.util.List;

import com.icss.oa.assign.pojo.Expinf;

/**
 * 封装总记录数和查询结果集合
 * 
 * @author Administrator
 * 
 */
public class ExpinfQueryResult {

	private int recordCount;// 满足条件的总记录数
	private List<Expinf> recordList;// 数据集合

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