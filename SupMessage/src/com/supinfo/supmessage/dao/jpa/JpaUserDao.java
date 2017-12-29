package com.supinfo.supmessage.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supinfo.supmessage.dao.UserDao;
import com.supinfo.supmessage.entity.Contact;
import com.supinfo.supmessage.entity.User;

public class JpaUserDao implements UserDao {
	
	private EntityManagerFactory myEntityManagerFactory;
	
	public JpaUserDao(EntityManagerFactory entityManagerFactory) {
		this.myEntityManagerFactory = entityManagerFactory;
	}

	@Override
	public User addUser(User user) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	em.persist(user);
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
	public User finUser(String username) {
		
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		User user;
		user = em.find(User.class, username);
		em.close();
		return user;
	}

	@Override

	public User UpdateUser(User user) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	em.merge(user);
        	t.commit();
        }catch(Exception e){
        	t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
		
		return null;
	}

	public Long Countuser() {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT COUNT(u) from User AS u");
		Long _count = (Long) query.getSingleResult();
		
		return _count;
	}
	
}
