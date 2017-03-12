package com.icss.addr.test;

import java.util.ArrayList;

import org.junit.Test;

import com.icss.addr.dao.impl.AddrDaoImpl;
import com.icss.addr.pojo.Person;

/**
 * ������
 * @author Administrator
 *
 */
public class TestAddrDao {
	
	private AddrDaoImpl dao = new AddrDaoImpl();
	
	@Test
	public void testReadAll() throws Exception {
		ArrayList<Person> list = dao.readAll();
		
		for (Person p : list) {
			System.out.println(p);
		}
	}
	
	@Test
	public void testWriteAll() throws Exception {
		//�������
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("aaa","1111"));
		list.add(new Person("bbb","2222"));
		list.add(new Person("ccc","3333"));
		
		dao.writeAll(list);
	}
	
	@Test
	public void testAdd() throws Exception {
		Person p = new Person("eee","5555");
		dao.add(p);
	}

	@Test
	public void testUpdate() throws Exception {
		Person p = new Person("������","5555");
		dao.update(p);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete("jack");
	}
	
	@Test
	public void testQuery() throws Exception {
		Person p = dao.query("rose");
		System.out.println(p);
	}
}