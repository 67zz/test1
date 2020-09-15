package com.lovo.hibernate.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSession {

	public static SessionFactory getSessionFactory(){
		SessionFactory sessionFactory=null; //¹¤³§
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("resouce/hibernate.cfg2.xml") // configures settings from hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}
		return sessionFactory;
	}
	
	public static Session getSession(){
		
	   return HibernateSession.getSessionFactory().openSession();
	}
}
