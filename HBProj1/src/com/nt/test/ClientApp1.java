package com.nt.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.nt.domain.EmpDetails;

public class ClientApp1 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		//Activate HB framework
		Configuration cfg=new Configuration();
		//Read both HB cfg file and mapping file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build SessionFactory
		SessionFactory factory=cfg.buildSessionFactory();
		//Open Session with DB s/w
		Session ses=factory.openSession();
		
		
		 //Create Domain class obj
		EmpDetails ed=new EmpDetails();
		ed.setNo(1017); ed.setFname("raja");
		ed.setLname("rao"); ed.setMail("x@y.com");
		
		// Save object using ses.persist(-)
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
			  ses.persist(ed);
			  tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		
	
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class

