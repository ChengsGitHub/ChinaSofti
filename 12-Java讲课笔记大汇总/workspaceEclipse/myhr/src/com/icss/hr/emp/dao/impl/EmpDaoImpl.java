package com.icss.hr.emp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.icss.hr.common.ConnFactory;
import com.icss.hr.common.Pager;
import com.icss.hr.dept.po.Dept;
import com.icss.hr.emp.dao.EmpDao;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.job.po.Job;

public class EmpDaoImpl implements EmpDao {

	@Override
	public void insert(Emp emp) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "insert into emp values (emp_seq.nextval,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpEmail());
		pstmt.setString(3, emp.getEmpPhone());
		pstmt.setDate(4, emp.getEmpHiredate());
		pstmt.setString(5, emp.getJob().getJobId());
		pstmt.setInt(6, emp.getEmpSalary());
		pstmt.setInt(7, emp.getDept().getDeptId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	@Override
	public void update(Emp emp) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "update emp set emp_name=?,emp_email=?,emp_phone=?,";
		sql += "emp_hiredate=?,job_id=?,emp_salary=?, dept_id=? ";
		sql += "where emp_id=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, emp.getEmpName());
		pstmt.setString(2, emp.getEmpEmail());
		pstmt.setString(3, emp.getEmpPhone());
		pstmt.setDate(4, emp.getEmpHiredate());
		pstmt.setString(5, emp.getJob().getJobId());
		pstmt.setInt(6, emp.getEmpSalary());
		pstmt.setInt(7, emp.getDept().getDeptId());
		pstmt.setInt(8, emp.getEmpId());
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	@Override
	public void delete(int empId) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "delete from emp where emp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	@Override
	public Emp queryById(int empId) throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "select * from emp where emp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		Emp emp = null;
		if (rs.next()) {
			Job job = new Job();
			job.setJobId(rs.getString(6));

			Dept dept = new Dept();
			dept.setDeptId(rs.getInt(8));

			emp = new Emp(rs.getInt(1), rs.getString(2), rs.getString(3),
					rs.getString(4), rs.getDate(5), job, rs.getInt(7), dept);

		}
		
		rs.close();
		pstmt.close();
		conn.close();

		return emp;
	}

	@Override
	public ArrayList<Emp> query(Pager pager) throws Exception {

		ArrayList<Emp> list = new ArrayList<Emp>();

		Connection conn = ConnFactory.getConnection();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM   (SELECT rownum rnum, ");
		sb.append("               e.emp_id, ");
		sb.append("               e.emp_name, ");
		sb.append("               e.emp_email, ");
		sb.append("               e.emp_phone, ");
		sb.append("               e.emp_hiredate, ");
		sb.append("               j.job_name, ");
		sb.append("               e.emp_salary, ");
		sb.append("               d.dept_name ");
		sb.append("        FROM   emp e ");
		sb.append("        LEFT   OUTER JOIN dept d ON e.dept_id = d.dept_id ");
		sb.append("        LEFT   OUTER JOIN job j ON e.job_id = j.job_id) ");
		sb.append("WHERE  rnum BETWEEN ? AND ?");

		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		pstmt.setInt(1, pager.getStart());
		pstmt.setInt(2, pager.getStart() + pager.getPageSize() - 1);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			Job job = new Job();
			job.setJobName(rs.getString(7));

			Dept dept = new Dept();
			dept.setDeptName(rs.getString(9));

			Emp emp = new Emp(rs.getInt(2), rs.getString(3), rs.getString(4),
					rs.getString(5), rs.getDate(6), job, rs.getInt(8), dept);

			list.add(emp);
		}

		rs.close();
		pstmt.close();
		conn.close();

		return list;
	}

	@Override
	public int getCount() throws Exception {
		Connection conn = ConnFactory.getConnection();
		String sql = "select count(*) from emp";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int count = rs.getInt(1);
		rs.close();
		pstmt.close();
		conn.close();
		return count;
	}

}