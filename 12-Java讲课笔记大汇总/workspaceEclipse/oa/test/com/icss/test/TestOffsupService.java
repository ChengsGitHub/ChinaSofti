package com.icss.test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.asserts.service.OffsupService;

public class TestOffsupService {
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");

	private OffsupService service = (OffsupService) context.getBean(OffsupService.class);

	@Test
	public void testExportExcel() throws IOException {
		FileOutputStream fos = new FileOutputStream("e:\\123.xls");
		service.exportExcel(fos);
	}
	
}