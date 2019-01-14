package com.nt.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.nt.domain.EmpDetails;

public class ClientApp5 {
	public static void main(String[] args) {
		  //Create Session obj
		
		Session ses=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory().openSession();
		
		
	/*	// Save or update obj
		 EmpDetails ed=new EmpDetails();
		  ed.setNo(9002);
		  ed.setFname("ramesh");
		  ed.setLname("rao1");
		  ed.setMail("x2@y.com");
		  Transaction tx=null;
		  try{
			  tx=ses.beginTransaction();
			    ses.saveOrUpdate(ed);
			  tx.commit();
		  }
		  catch(Exception e){
			  tx.rollback();
		  } */
		
		// Performing save or update operation by using ses.merge(-)
		EmpDetails ed=new EmpDetails();
		ed.setNo(1032);
		ed.setFname("raja");
		ed.setLname("rao");
		ed.setMail("rao@x.com");
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
			 EmpDetails ed1=(EmpDetails)ses.merge(ed);
			 System.out.println(ed1);
			 tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		}
		
		
		
		//close objs
		ses.close();
		
	}//main
}//class

