package com.worldbank.models;

public class Transfers {

	private int account_id;
	private String account_name;
	private double amount;
	private String pass;
	private double balance;
	
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public String getAccount_name() {
		return account_name;
	}
	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Transfers(int account_id, String account_name, double amount, String pass, double balance) {
		super();
		this.account_id = account_id;
		this.account_name = account_name;
		this.amount = amount;
		this.pass = pass;
		this.balance = balance;
	}
	
	
	
	
	
	
	
}
