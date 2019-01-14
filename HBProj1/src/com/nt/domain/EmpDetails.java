package com.nt.domain;

public class EmpDetails {
	//bean properties
	private int no;
	private String fname,lname,mail;
	//write setXxx(-) and getXxx() methods
	public EmpDetails(){
		System.out.println("ED:0-param constructor");
	}
/*	public EmpDetails(int no, String fname, String lname, String mail) {
		System.out.println("ED:parameterized constructor");
		this.no = no;
		this.fname = fname;
		this.lname = lname;
		this.mail = mail;
	} */
	public int getNo() {
		
		return no;
	}
	public void setNo(int no) {
		
		this.no = no;
	}
	public String getFname() {
		
		return fname;
	}
	public void setFname(String fname) {
		
		this.fname = fname;
	}
	public String getLname() {
		
		return lname;
	}
	public void setLname(String lname) {
		
		this.lname = lname;
	}
	public String getMail() {
		
		return mail;
	}
	public void setMail(String mail) {
		
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "EmpDetails [no=" + no + ", fname=" + fname + ", lname=" + lname
				+ ", mail=" + mail + "]";
	}
	
	private String xyz;
	public String getXyz() {
		return xyz;
	}
	public void setXyz(String xyz) {
		this.xyz = xyz;
	}
	
	 

}
