package com.nt.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.nt.domain.EmpDetails;

public class ClientApp4 {
	public static void main(String[] args) {
		//Activate HB framework
		Configuration cfg=new Configuration();
		//Read both HB cfg file and mapping file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build SessionFactory
		SessionFactory factory=cfg.buildSessionFactory();
		//Open Session with DB s/w
		Session ses=factory.openSession();
/*		// Approach1 (Delete object)
		 EmpDetails ed=new EmpDetails();
	       ed.setNo(1001);
	      Transaction tx=null;
	      try{
	        tx=ses.beginTransaction();
	         ses.delete(ed);
	        tx.commit();
	         }
	       catch(Exception e){
	         tx.rollback();
	        } */
		//Approach2 (Deleting object)
		// Load obj
		EmpDetails ed=(EmpDetails)ses.get(EmpDetails.class,1002);
		if(ed!=null){
			Transaction tx=null;
			try{
				tx=ses.beginTransaction();
				  //Delete obj
				  ses.delete(ed);
				 tx.commit();
				 System.out.println("Object deleted");
			}
			catch(Exception e){
				tx.rollback();
			}
		}//if
		else{
			System.out.println("Object not deleted");
		}
		
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class

