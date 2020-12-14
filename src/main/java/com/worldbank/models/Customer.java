package com.worldbank.models;

public class Customer {

	private String fname;
	private String lname;
	private  String username;
	private String pass;
	private int user_id;
	private String userType;
	private String account;
	
	
	
	//CONSTRUCTORS
	
	

	
	
	//METHODS
	
	public void createNewAccount() {};
	
	public Customer(String fname, String lname, String username, String pass, int user_id, String userType,
			String account) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.username = username;
		this.pass = pass;
		this.user_id = user_id;
		this.userType = userType;
		this.account = account;
	}

	public void withdraw() {};
	
	public void deposit() {};
	
	public void viewBalance() {};
	
	public void transfer() {};
	
	public void acceptTransfer() {};

	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	
	
	

	
	
	
	
	
	
	
	
	
	
}
