package com.icss.test;
import java.sql.Date;
import java.text.DateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.system.dao.BbsDao;
import com.icss.oa.system.pojo.Bbs;

public class TestBbsDao {
	private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	private BbsDao dao = (BbsDao) context.getBean(BbsDao.class);
	
   
    @Test
	public void testGetCount() {
		int count = dao.getCount();
		System.out.println("count=" + count);
	}
    @Test
	public void testGetConCount() {
		int count = dao.getConditionCount("员工");
		System.out.println("count=" + count);
	}
    @Test
    public void testInsert(){
    	Bbs bbs=new Bbs("测试",(short)1,"ff");
    	dao.insert(bbs);   	
    }
  
    
    @Test
    public void testQueryById(){
    
    	Bbs bbs=dao.queryById(1);
    	System.out.println(bbs);
    }
    
    @Test
    public void testSetTop()
    {
    	dao.setTop(3332);
    }
    
    @Test
    public void testCancelTop()
    {
    	dao.cancelTop(3584);
    }
    @Test
	public void testQuery() {
		Pager pager = new Pager(dao.getCount(), 1);
		List<Bbs> list = dao.query(pager);
		for (Bbs bbs : list) {
			System.out.println(bbs);
		}
    }

    @Test
  	public void testConQuery() {
  		Pager pager = new Pager(dao.getCount(), 1);
  		List<Bbs> list = dao.queryByCondition(pager, "员工");
  		for (Bbs bbs : list) {
  			System.out.println(bbs);
  		}
      }
    @Test
    public void testDelete(){
    	dao.delete(8);
    }

	@Test
	public void testUpdate() {
		Bbs bbs = new Bbs(3348,"123456788",(short)0,"FASF");
		dao.update(bbs);
	}

	@Test
	public void test(){
		System.out.println(new Date(1));
	}
	
    @Test
    public void testQueryByTime(){
		Pager pager = new Pager(dao.getCount(), 1);
		List<Bbs> list = dao.queryByTime(pager);
    	
		for (Bbs bbs : list) {
			System.out.println(bbs);
		}
    }
    

    @Test
    public void testByte(){
    	byte[] b={'f'};
    	System.out.println(b);
    }
  

}
