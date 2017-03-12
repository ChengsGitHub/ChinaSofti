package com.icss.addr.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.icss.addr.dao.AddrDao;
import com.icss.addr.pojo.Person;

/**
 * ���ݷ��ʽӿڵľ���ʵ����
 * 
 *
 */
public class AddrDaoImpl implements AddrDao {

	@Override
	public void add(Person person) throws Exception {
		
		ArrayList<Person> list = this.readAll();	
		
		for (int i = 0;i < list.size();i ++) {
			if (list.get(i).getName().equals(person.getName())) {
				throw new Exception("�����Ѿ�����");
			}
		}
		
		list.add(person);
		this.writeAll(list);
	}
	
	@Override
	public void update(Person person) throws Exception {
		
		ArrayList<Person> list = this.readAll();
		
		for (int i = 0;i < list.size();i ++) {
			if (list.get(i).getName().equals(person.getName())) {
				list.set(i, person);
				this.writeAll(list);
				return;
			}
		}
		
		throw new Exception("����������");
	}

	@Override
	public void delete(String name) throws Exception {
		
		ArrayList<Person> list = this.readAll();
		
		for (int i = 0;i < list.size();i ++) {
			if (list.get(i).getName().equals(name)) {
				list.remove(i);
				this.writeAll(list);
				return;
			}
		}
		
		throw new Exception("����������");		
	}

	@Override
	public Person query(String name) throws Exception {
		
		ArrayList<Person> list = this.readAll();
		
		for (int i = 0;i < list.size();i ++) {
			if (list.get(i).getName().equals(name)) {
				return list.get(i);
			}
		}
		
		throw new Exception("����������");
	}

	/**
	 * ��ȡ�����ļ�������һ�����ݼ���
	 */
	@Override
	public ArrayList<Person> readAll() throws Exception {
		
		ArrayList<Person> list = new ArrayList<Person>();
		
		try {
			FileReader fr = new FileReader(FILE_PATH);
			BufferedReader br = new BufferedReader(fr);
			
			String s = br.readLine();
			
			while (s != null) {
				String[] ss = s.split("\\|");
				Person p = new Person(ss[0],ss[1]);
				list.add(p);
				s = br.readLine();
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			throw new Exception("�����ļ��Ҳ�������������");			
		}
		
		return list;
	}

	/**
	 * ����һ�����ݼ���,����д�������ļ�
	 */
	@Override
	public void writeAll(ArrayList<Person> list) throws Exception {
		
		PrintWriter pw = new PrintWriter(FILE_PATH);
		
		for (Person p : list) {
			pw.println(p.toString());
		}
		
		pw.close();
	}

}