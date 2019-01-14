package com.nt.test;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.nt.domain.EmpDetails;

public class ClientApp2 {
	public static void main(String[] args) {
		//Activate HB framework
		Configuration cfg=new Configuration();
		//Read both HB cfg file and mapping file
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Build SessionFactory
		SessionFactory factory=cfg.buildSessionFactory();
		//Open Session with DB s/w
		Session ses=factory.openSession();
		
		//Load obj (Select a record)
		EmpDetails ed=(EmpDetails)ses.load(EmpDetails.class,101);
		if(ed==null)
			System.out.println("Record not found");
		else{
			System.out.println("Record found");
			System.out.println(ed);
		}
		
		
		
		//close objs
		ses.close();
		factory.close(); 
	}//main
}//class

