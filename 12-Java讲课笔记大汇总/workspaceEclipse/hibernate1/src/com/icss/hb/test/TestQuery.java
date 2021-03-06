package com.icss.hb.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.icss.hb.po.Emp;

public class TestQuery {

	public static void main(String[] args) {

		// 配置对象Configuration，代表配置文件
		Configuration config = new Configuration().configure();

		// session工厂对象SessionFactory，代表数据库连接池
		SessionFactory factory = config.buildSessionFactory();

		// 数据库连接对象session，代表一个数据库连接
		Session session = factory.openSession();

		//查询Emp的所有数据（注意Emp不是表名，是类名！）
		String hql = "from Emp e order by e.empId desc";
		
		//Query对象
		Query query = session.createQuery(hql);
		
		//直接返回数据集合
		List<Emp> list = query.list();
		
		for (Emp e : list) {
			System.out.println(e);
		}

		// 关闭session
		session.close();
	}

}