package com.icss.hb.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * ���򹤳�
 * 
 * @author Administrator
 * 
 */
public class ExportDB {

	public static void main(String[] args) {

		// ���ö���Configuration�����������ļ�
		Configuration config = new Configuration().configure();
		
		//������������
		SchemaExport export = new SchemaExport(config);
		
		//��������
		export.create(true, true);

	}

}
