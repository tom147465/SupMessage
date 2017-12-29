package com.supinfo.supmessage.dao;

import com.supinfo.supmessage.dao.jpa.JpaContactDao;
import com.supinfo.supmessage.dao.jpa.JpaUserDao;
import com.supinfo.supmessage.dao.jpa.JpaMessageDao;
import com.supinfo.supmessage.util.PersistenceManager;

public class DaoFactory {

	private DaoFactory(){
	}
	
	
	public static UserDao retrieveUserDao() {
		JpaUserDao userDao = new JpaUserDao(PersistenceManager.retrieveEntityManagerFactory());
	    return userDao;
   }

	public static MessageDao retrieveMessageDao() {
		JpaMessageDao messageDao = new JpaMessageDao(PersistenceManager.retrieveEntityManagerFactory());
	    return messageDao;
   }
	
	public static ContactDao retrieveContactDao() {
		JpaContactDao contactDao = new JpaContactDao(PersistenceManager.retrieveEntityManagerFactory());
	    return contactDao;
   }
	
}
