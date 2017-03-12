package com.icss.hb.test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.icss.hb.po.Emp;

public class TestUpdate2 {

	public static void main(String[] args) {
		
		//配置对象Configuration，代表配置文件
		Configuration config = new Configuration().configure();

		//session工厂对象SessionFactory，代表数据库连接池
		SessionFactory factory = config.buildSessionFactory();
		
		//数据库连接对象session，代表一个数据库连接
		Session session = factory.openSession();
		
		//开始事务
		Transaction tx = session.beginTransaction();
		
		//更新数据的第二种方式（对象必须是持久化状态才可以）
		Emp emp = (Emp) session.get(Emp.class, 101);
		emp.setEmpSalary(3910);		
		emp.setEmpName("jack111");
		
		//提交事务
		tx.commit();
		
		//关闭session
		session.close();
	}

}