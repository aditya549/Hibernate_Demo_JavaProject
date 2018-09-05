package com.cubic.hibernatePro;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;

public class Crud {

	public static void insert() {
		Configuration cfg = new Configuration();
        cfg.configure("school.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
     School s=new School();
     s.setSname("reddy");
     s.setSdomain("java");
     s.setSemail("reddy@gmail.com");
     session.save(s);  
     t.commit();  
     System.out.println("successfully saved");    
     factory.close();  
     session.close();     
		
	}

	public static void fetch() {
		Configuration cfg = new Configuration();
        cfg.configure("school.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
		Query<School> query = session.createQuery("from School");
        java.util.List<School> li= query.list();
        Iterator<School> itr=li.iterator();
        while(itr.hasNext()) {
        	School s=(School)itr.next();
        	System.out.print(s.getSname()+"    ");
        	System.out.print(s.getSdomain()+"    ");
        	System.out.print(s.getSemail()+"    ");
        	System.out.println();
        }
        t.commit();
        session.close();
		
	}

	public static void update() {
		Configuration cfg = new Configuration();
        cfg.configure("school.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        int sid=1;
        
        School s = (School)session.get(School.class,sid); 
        s.setSdomain("Testing");
        session.update(s); 
        t.commit();
        session.close();
	}

	public static void delete() {
		Configuration cfg = new Configuration();
        cfg.configure("school.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Transaction t = session.beginTransaction();
        /*int sid=1;
        School s = (School)session.get(School.class,sid);*/
        Query<School> query = session.createQuery("Delete from School");
        query.executeUpdate(); 
        t.commit();
        session.close();
		
	}

}
