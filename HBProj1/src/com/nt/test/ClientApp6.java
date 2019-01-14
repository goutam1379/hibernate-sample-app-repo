package com.nt.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.nt.domain.EmpDetails;

public class ClientApp6 {
	public static void main(String[] args)throws Exception{
		  //Create Session obj
		
		SessionFactory factory=new Configuration().configure("/com/nt/cfgs/hibernate.cfg.xml").buildSessionFactory();
		Session ses=factory.openSession();
		
/*		//Load Object
		EmpDetails ed=(EmpDetails)ses.get(EmpDetails.class, 1010);
		//modify  Object
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
			  ed.setMail("x1@y1.com");
			  ed.setFname("raju");
			tx.commit();  
		}
		catch(Exception e){
			tx.rollback();
		} */
		
	/*	//Loads obj from DB table and keeps in First Level cache
		EmpDetails ed1=(EmpDetails)ses.get(EmpDetails.class,1010);
		System.out.println(ed1);
		
		//Loads the obj from first level cache
		EmpDetails ed2=(EmpDetails)ses.get(EmpDetails.class,1010);
		System.out.println(ed2);
       ses.clear();
		//Loads the obj from first level cache
		EmpDetails ed3=(EmpDetails)ses.get(EmpDetails.class,1010);
		System.out.println(ed3); */
	
		
	/*	EmpDetails ed=new EmpDetails();
		ed.setNo(9031);
		ed.setFname("rajesh");
		ed.setLname("rao");
		ed.setMail("x2@y6.com");
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
	 		ses.save(ed); //--> keeps ed obj in L1 cache
	 		tx.commit();
	 		Thread.sleep(10000);
		}catch(Exception e){
			tx.rollback();
			e.printStackTrace();
		} */
		
		
		EmpDetails ed=null; // transient
		ed=(EmpDetails)ses.get(EmpDetails.class,101);
		Transaction tx=null;
		try{
		tx=ses.beginTransaction();
		  ed.setMail("xxx@yyyy.com");
		tx.commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}
				
		
		
		/*EmpDetails ed=null;  //ed  is transient
		ed=(EmpDetails)ses.get(EmpDetails.class,101); //ed is persistent
		System.out.println(ed);
		ses.evict(ed); //ed is Detached.
	
		Transaction tx=null;
		try{
			tx=ses.beginTransaction();
			ed.setMail("x@y111.com");
			ses.update(ed); //ed again becomes persistent
		  tx.commit();
		}
		catch(Exception e){
			tx.rollback();
		} */
		
		
		
		
		
		
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class

