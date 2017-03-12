package com.icss.hr.job.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.icss.hr.common.ConnFactory;
import com.icss.hr.job.dao.JobDao;
import com.icss.hr.job.po.Job;

/**
 * 职务dao的实现类
 */
public class JobDaoImpl implements JobDao {

	@Override
	public void insert(Job job) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "insert into job values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, job.getJobId());
		pstmt.setString(2, job.getJobName());
		pstmt.setInt(3, job.getJobMinSalary());
		pstmt.setInt(4, job.getJobMaxSalary());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();

	}

	@Override
	public void update(Job job) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "update job set job_name=?,job_min_salary=?,job_max_salary=? where job_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(4, job.getJobId());
		pstmt.setString(1, job.getJobName());
		pstmt.setInt(2, job.getJobMinSalary());
		pstmt.setInt(3, job.getJobMaxSalary());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();

	}

	@Override
	public void delete(String jobId) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "delete from job where job_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, jobId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();

	}

	@Override
	public Job queryById(String jobId) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from job where job_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, jobId);
		ResultSet rs = pstmt.executeQuery();

		Job job = null;

		if (rs.next()) {
			job = new Job(rs.getString(1), rs.getString(2), rs.getInt(3),
					rs.getInt(4));
		}

		rs.close();
		pstmt.close();
		conn.close();

		return job;
	}

	@Override
	public ArrayList<Job> query() throws Exception {

		ArrayList<Job> list = new ArrayList<Job>();

		Connection conn = ConnFactory.getConnection();
		String sql = "select * from job";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			Job job = new Job(rs.getString(1), rs.getString(2), rs.getInt(3),
					rs.getInt(4));
			list.add(job);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}

}