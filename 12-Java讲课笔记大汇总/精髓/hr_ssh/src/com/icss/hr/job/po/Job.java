package com.icss.hr.job.po;

// Generated 2014-3-17 9:17:03 by Hibernate Tools 3.4.0.CR1

/**
 * Job generated by hbm2java
 */
public class Job implements java.io.Serializable {

	private String jobId;
	private String jobName;
	private Integer jobMinSalary;
	private Integer jobMaxSalary;

	public Job() {
	}

	public Job(String jobId) {
		this.jobId = jobId;
	}

	public Job(String jobId, String jobName, Integer jobMinSalary,
			Integer jobMaxSalary) {
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobMinSalary = jobMinSalary;
		this.jobMaxSalary = jobMaxSalary;
	}

	public String getJobId() {
		return this.jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getJobMinSalary() {
		return this.jobMinSalary;
	}

	public void setJobMinSalary(Integer jobMinSalary) {
		this.jobMinSalary = jobMinSalary;
	}

	public Integer getJobMaxSalary() {
		return this.jobMaxSalary;
	}

	public void setJobMaxSalary(Integer jobMaxSalary) {
		this.jobMaxSalary = jobMaxSalary;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobName=" + jobName
				+ ", jobMinSalary=" + jobMinSalary + ", jobMaxSalary="
				+ jobMaxSalary + "]";
	}
	
}
