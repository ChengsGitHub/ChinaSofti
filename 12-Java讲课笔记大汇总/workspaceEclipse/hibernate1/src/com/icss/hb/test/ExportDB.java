package com.icss.hb.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * 正向工程
 * 
 * @author Administrator
 * 
 */
public class ExportDB {

	public static void main(String[] args) {

		// 配置对象Configuration，代表配置文件
		Configuration config = new Configuration().configure();
		
		//导出方案对象
		SchemaExport export = new SchemaExport(config);
		
		//导出对象
		export.create(true, true);

	}

}
