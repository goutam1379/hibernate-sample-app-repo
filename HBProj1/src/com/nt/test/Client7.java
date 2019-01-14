package com.nt.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.domain.EmpDetails;

public class Client7 {
	public static void main(String[] args) {
		
		//Get SessionFactory obj
		SessionFactory factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		//get Session obj1
		Session ses1=factory.openSession();
		EmpDetails ed1=null ; //ed1 is Transient
		ed1=(EmpDetails)ses1.get(EmpDetails.class,101); //ed1 is persistent
		System.out.println(ed1);
		ses1.close();  //ed1 is Detached
		  ed1.setMail("1111@xyz.com"); //modification will not reflect
		 
		 // get Session obj2
		 Session ses2=factory.openSession();
		  EmpDetails ed2=null; //ed2 is Transient
		  ed2=(EmpDetails)ses2.get(EmpDetails.class,101); //ed2 is persistent
		                                                                                                  // ed2 in L1 cache of Ses2
		  System.out.println(ed2);
		  Transaction tx=null;
		  try{ 
		   tx=ses2.beginTransaction();
		      ses2.merge(ed1);
		   tx.commit();
		  }
		  catch(Exception e){
			  e.printStackTrace();
			  tx.rollback();
			  
		  }
		  
		   
		  
		  
		  
		 
		  
		
		
	}

}
