package com.supinfo.supmessage.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supinfo.supmessage.dao.MessageDao;
import com.supinfo.supmessage.entity.Contact;
import com.supinfo.supmessage.entity.Message;

public class JpaMessageDao implements MessageDao {
	
	private EntityManagerFactory myEntityManagerFactory;
	
	public JpaMessageDao(EntityManagerFactory entityManagerFactory) {
		// TODO Auto-generated constructor stub
		this.myEntityManagerFactory = entityManagerFactory;
	}

	@Override
	public void addMessage(Message message) {
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
        EntityTransaction t = em.getTransaction();
        try{
        	t.begin();
        	em.persist(message);
        	t.commit();
        }catch(Exception e){
        	t.rollback();
        	System.out.println("something went wrong");
        }finally{
        	em.close();
        }
		
	}


	@Override
	public List<Message> showhistroy(String sname, String dname) {
		System.out.println(sname + "111" + dname );
		
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT m from Message AS m WHERE Sname IN( :sname, :dname ) AND Dname IN( :sname, :dname ) ");
		query.setParameter("sname", sname);
		query.setParameter("dname", dname);
        List<Message> listmes = query.getResultList();
		return listmes;
	}

	public Long CountMessage() {
		
		EntityManager em = this.myEntityManagerFactory.createEntityManager();
		Query query = em.createQuery("SELECT COUNT(m) from Message AS m");
		Long _count = (Long) query.getSingleResult();
		
		return _count;
	}



}
