package com.nt.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.nt.domain.EmpDetails;

public class ClientApp3 {
	public static void main(String[] args) {
		//Activate HB framework
		Configuration cfg=new Configuration();
		//Read both HB cfg file and mapping file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build SessionFactory
		SessionFactory factory=cfg.buildSessionFactory();
		//Open Session with DB s/w
		Session ses=factory.openSession();
		
/*		 //Update obj (Apporach1)
		 EmpDetails ed=new EmpDetails();
	       ed.setNo(101); //old value
	       ed.setFname("new raja1");
	       ed.setLname("chari");
	       ed.setMail("x@y.com"); 
	     Transaction tx=null;
	     try{
	       tx=ses.beginTransaction();
	         ses.update(ed);
	       tx.commit();
	       }
	      catch(Exception e){
	         tx.rollback();
	        } */
		 EmpDetails ed=(EmpDetails)ses.get(EmpDetails.class,101);
		    if(ed!=null){
		        Transaction tx=null;
		        try{
		         tx=ses.beginTransaction();
		           ed.setMail("x1@gmail.com");
		           ses.update(ed);
		        tx.commit();
		        System.out.println("object updated");
		        }
		       catch(Exception e){
		        tx.rollback();
		        }
		      }//if
		     else{
              System.out.println("Object not found");
		      }	
		
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class

