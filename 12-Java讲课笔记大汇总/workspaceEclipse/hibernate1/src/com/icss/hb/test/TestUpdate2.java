package com.icss.hb.test;

import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.icss.hb.po.Emp;

public class TestUpdate2 {

	public static void main(String[] args) {
		
		//���ö���Configuration�����������ļ�
		Configuration config = new Configuration().configure();

		//session��������SessionFactory���������ݿ����ӳ�
		SessionFactory factory = config.buildSessionFactory();
		
		//���ݿ����Ӷ���session������һ�����ݿ�����
		Session session = factory.openSession();
		
		//��ʼ����
		Transaction tx = session.beginTransaction();
		
		//�������ݵĵڶ��ַ�ʽ����������ǳ־û�״̬�ſ��ԣ�
		Emp emp = (Emp) session.get(Emp.class, 101);
		emp.setEmpSalary(3910);		
		emp.setEmpName("jack111");
		
		//�ύ����
		tx.commit();
		
		//�ر�session
		session.close();
	}

}