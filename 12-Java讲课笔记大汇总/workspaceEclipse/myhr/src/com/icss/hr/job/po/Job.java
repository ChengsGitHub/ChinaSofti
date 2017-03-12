package com.icss.hr.job.po;

public class Job {
	
	private String jobId;
	
	private String jobName;
	
	private int jobMinSalary;
	
	private int jobMaxSalary;

	public Job() {
		super();
	}

	public Job(String jobId, String jobName, int jobMinSalary, int jobMaxSalary) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobMinSalary = jobMinSalary;
		this.jobMaxSalary = jobMaxSalary;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public int getJobMinSalary() {
		return jobMinSalary;
	}

	public void setJobMinSalary(int jobMinSalary) {
		this.jobMinSalary = jobMinSalary;
	}

	public int getJobMaxSalary() {
		return jobMaxSalary;
	}

	public void setJobMaxSalary(int jobMaxSalary) {
		this.jobMaxSalary = jobMaxSalary;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName
				+ ", jobMinSalary=" + jobMinSalary + ", jobMaxSalary="
				+ jobMaxSalary + "]";
	}
	
}