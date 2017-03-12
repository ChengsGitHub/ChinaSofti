package com.icss.test;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.po.Emp;
import com.icss.hr.emp.service.EmpService;
import com.icss.hr.emp.vo.EmpVo;

public class TestEmpService {

	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"application*.xml");

	private EmpService service = (EmpService) context.getBean("empService");

	@Test
	public void testAdd() throws Exception {

		EmpVo vo = new EmpVo("ÁõºúÀ¼", "liuhulan@163.com", "222.222.222",
				Date.valueOf("2004-06-09"), "FWY", 3700, 10);

		service.add(vo);
	}
	
	@Test
	public void testQuery() throws Exception {

		Pager pager = new Pager(service.getCount(),2);
		
		List<Emp> list = service.query(pager);
				
		for (Emp e : list) {
			System.out.println(e.getEmpId());
			System.out.println(e.getEmpName());
			System.out.println("---------------------");
		}
		
	}
	
}