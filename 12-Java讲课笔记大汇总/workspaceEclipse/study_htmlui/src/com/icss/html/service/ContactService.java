package com.icss.html.service;

import java.util.ArrayList;
import java.util.List;
import com.icss.html.pojo.Contact;

public class ContactService {
	
	/**
	 * 返回数据集合
	 * @return
	 */
	public List<Contact> getContact() {		
		ArrayList<Contact> list = new ArrayList<Contact>();
		list.add(new Contact(1,"tom","110"));
		list.add(new Contact(7,"jack","114"));
		list.add(new Contact(19,"rose","120"));
		return list;
	}

}