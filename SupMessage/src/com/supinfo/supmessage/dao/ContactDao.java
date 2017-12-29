package com.supinfo.supmessage.dao;

import java.util.List;

import com.supinfo.supmessage.entity.Contact;
import com.supinfo.supmessage.entity.User;

public interface ContactDao {
	
	public Contact finContact(String s_user, String c_user);

	public Contact addContact(Contact contact);
	
	public List<Contact> listContact(String s_user);	
}
