package com.revature.repositories;

/**
 * @author rousb
 *
 */

public class User {
	
	String fname;
	String lname;
	String email;
	String pass;
	double initialDeposit;
	
	
	
	public User(String fname, String lname, String email, String pass, double initialDeposit) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.initialDeposit = initialDeposit;
	}





	@Override
	public String toString() {
		return "User [fname=" + fname + ", lname=" + lname + ", email=" + email + ", pass=" + pass + ", initialDeposit="
				+ initialDeposit + "]";
	}
	
	
	
	

}
