package com.icss.addr.dao;

import java.util.ArrayList;

import com.icss.addr.pojo.Person;

/**
 * ���ݷ��ʽӿ�
 * @author Administrator
 *
 */
public interface AddrDao {
	
	String FILE_PATH = "data.txt";//�����ļ�������
	
	void add(Person person) throws Exception;
	
	void update(Person person) throws Exception;
	
	void delete(String name) throws Exception;
	
	Person query(String name) throws Exception;
	
	ArrayList<Person> readAll() throws Exception;
	
	void writeAll(ArrayList<Person> list) throws Exception;

}
