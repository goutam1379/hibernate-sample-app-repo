package com.nt.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.nt.domain.EmpDetails;

public class ClientApp {
	public static void main(String[] args) {
		//Activate HB framework
		Configuration cfg=new Configuration();
		//Read both HB cfg file and mapping file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//create Service Registry
		
		ServiceRegistry registry=new ServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		System.out.println(registry.getClass());
		//Build SessionFactory
		SessionFactory factory=cfg.buildSessionFactory(registry);
		//Open Session with DB s/w
		Session ses=factory.openSession();
		
		
		 //Create Domain class obj
		EmpDetails ed=new EmpDetails();
		ed.setNo(1033); ed.setFname("raja");
		ed.setLname("rao"); ed.setMail("x@y.com");
		
		// Save object (insert record)
		Transaction tx=null;
		try{
			tx=ses.beginTransaction(); //Begin Tx
			   int idval=(Integer)ses.save(ed);
			   System.out.println("Generated Id value"+idval);
			tx.commit(); // Commit Tx
		}
		catch(Exception e){
			tx.rollback(); // Rollback Tx
		}
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class

