package com.icss.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.hr.job.service.JobService;
import com.icss.hr.job.vo.JobVo;

public class TestJobService {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("application*.xml");
	
	private JobService service = (JobService) context.getBean("jobService");
	
	@Test
	public void add() {		
		JobVo vo = new JobVo("ZJL", "×Ü¾­Àí", 9999, 99999);
		service.add(vo);		
	}

}