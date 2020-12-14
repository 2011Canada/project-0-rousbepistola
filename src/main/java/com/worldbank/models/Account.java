package com.worldbank.models;


public class Account {

	private int user_id;
	private String account_name;
	private double balance;
	private int account_id;
	
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	
	
	public Account(int user_id, String account_name, double balance, int account_id) {
		super();
		this.user_id = user_id;
		this.account_name = account_name;
		this.balance = balance;
		this.account_id = account_id;
	}
	
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Account [user_id=" + user_id + ", account_name=" + account_name + ", balance=" + balance
				+ ", account_id=" + account_id + "]";
	}
	
	
	
	
	
	
	

}
