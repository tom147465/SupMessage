package com.supinfo.supmessage.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supinfo.supmessage.dao.ContactDao;
import com.supinfo.supmessage.entity.Contact;
import com.supinfo.supmessage.entity.User;

public class JpaContactDao implements ContactDao{
	
	private EntityManagerFactory myEntityManagerFactory;
	
	public JpaContactDao(EntityManagerFactory entityManagerFactory) {
		this.myEntityManagerFactory = entityManagerFactory;
	}

	@Override
	
	
	public Contact finContact( String s_user, String c_user) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Contact contact;
		try{
			Query query = em.createQuery("SELECT c from Contact AS c WHERE S_user = :s_user AND C_user = :c_user");
			query.setParameter("s_user", s_user);
			query.setParameter("c_user", c_user);
			contact = (Contact) query.getSingleResult();
		}catch(Exception e){
			contact = null;
		}
		return contact;
	}

	@Override
	public Contact addContact(Contact contact) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	em.persist(contact);
        	t.commit();
        }catch(Exception e){
        	t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
		
		return null;
	}

	@Override
	public List<Contact> listContact(String s_user) {
		System.out.println(s_user);
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT c from Contact AS c WHERE S_user = :user ");
		query.setParameter("user", s_user);
        List<Contact> contact = query.getResultList();
        em.close();
		return contact;
	}

}
