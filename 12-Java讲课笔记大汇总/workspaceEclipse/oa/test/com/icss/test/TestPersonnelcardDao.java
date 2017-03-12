package com.icss.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.icss.oa.common.Pager;
import com.icss.oa.card.dao.PersonnelcardDao;
import com.icss.oa.card.pojo.Personnelcard;
import com.icss.oa.card.service.PersonnelcardService;

public class TestPersonnelcardDao {

	
	private ApplicationContext context = new ClassPathXmlApplicationContext(
			"applicationContext.xml");
	private PersonnelcardDao dao = (PersonnelcardDao) context.getBean(PersonnelcardDao.class);
	private PersonnelcardService service = (PersonnelcardService) context.getBean(PersonnelcardService.class);
	
	@Test
	public void getCount(){
		int count = dao.getCount(102);
		System.out.println(count);
	}
	@Test
	public void testInsert(){
		Personnelcard personnelcard = new Personnelcard("王小",2,"男","开发部","经理","12332111123",
				"32112333211","123@qq.com","开发区",14,2,3);
		dao.insert(personnelcard);
	}
	@Test
	public void testUpdate(){
		Personnelcard personnelcard = new Personnelcard(1,"李四",2,"女","开发部","经理","12332111123",
				"32112333211","123@qq.com","开发区",20,5,6);
		dao.update(personnelcard);
	}
	@Test
	public void testDelete(){
		dao.delete(1);
	}
	@Test
	public void testQuerybyId(){
		Personnelcard personnelcard = dao.queryById(3);
		System.out.println(personnelcard);
	}
	
	@Test
	public void testQuery(){
		Pager pager = new Pager(dao.getCount(102),1);
		List<Map<String,Object>> list = dao.query(pager,4);
		for(Map<String,Object> personnelcard : list){
			System.out.println(personnelcard);
		}
	}
	@Test
	public void testQuery3Service(){
		Personnelcard personnelCard = service.queryByEmpId(2);
		System.out.println(personnelCard);
	}
	
	@Test
	public void testQueryByCondition(){
		Pager pager = new Pager(dao.getCount(102),1);
		List<Personnelcard> list = dao.queryByCondition(pager,"党课",2);
		for(Personnelcard p : list){
			System.out.println(p);
		}
	}
}