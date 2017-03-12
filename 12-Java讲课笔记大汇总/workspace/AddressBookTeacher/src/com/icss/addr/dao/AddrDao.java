package com.icss.addr.dao;

import java.util.ArrayList;

import com.icss.addr.pojo.Person;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface AddrDao {
	
	String FILE_PATH = "data.txt";//数据文件的名称
	
	void add(Person person) throws Exception;
	
	void update(Person person) throws Exception;
	
	void delete(String name) throws Exception;
	
	Person query(String name) throws Exception;
	
	ArrayList<Person> readAll() throws Exception;
	
	void writeAll(ArrayList<Person> list) throws Exception;

}
