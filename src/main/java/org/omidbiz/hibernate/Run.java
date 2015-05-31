package org.omidbiz.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class Run {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Session session = HibernateSessionManager.getSessionFactory().openSession();
		 
		session.beginTransaction();
		List list = session.createQuery("select w from Wbs w").list();
		System.out.println("&&&&&&&&&&&&&&&&&&&");
		System.out.println(list.size());
		session.getTransaction().commit();

	}

}
