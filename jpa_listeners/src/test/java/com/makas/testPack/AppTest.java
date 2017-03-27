package com.makas.testPack;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.makas.bean.Person;

/**
 * Unit test for simple App.
 */
public class AppTest {
	

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("personUnit");
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction tx = em.getTransaction();

	public static void main(String...args){
		
		Person p1 = new Person("Brahima Traore",34, new Date());
		       tx.begin();
		       em.persist(p1);
		       tx.commit();
		       
		// find p1 and update
		       tx.begin();
		Person found =em.find(Person.class,p1.getId());
		       if(found != null){
		    	   found.setFullName("Brahima Zanga");
		    	   em.persist(found);
		    	   tx.commit();
		       }
		       
		// create a second intance with age = 18 and persit
		Person p2 = new Person("Allassane", 18, new Date());
		       tx.begin();
		       em.persist(p2);
		       tx.commit();
		       
	   //try to delete p2
		       tx.begin();
		       em.remove(p2);// this will throw an Exception
		       tx.commit();
		       
	}
   
}
