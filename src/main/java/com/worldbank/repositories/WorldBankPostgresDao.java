package com.worldbank.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.worldbank.models.Account;
import com.worldbank.util.ConnectionFactory;

public class WorldBankPostgresDao {
	Scanner scan = new Scanner(System.in);
	
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	
	
	public void findAll() {
		
		Connection conn = this.cf.getConnection();
		
		try {
			String sql = "select * from \"user\"";
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			while(res.next()) {
				System.out.println(res.getString("fname"));
				System.out.println(res.getString("lname"));
				System.out.println(res.getString("username"));
				System.out.println(res.getString("pass"));
				System.out.println(res.getString("user_id"));
				System.out.println("------------------------------------");
			};
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	};
	
//------------------------------------------------------------------------LOGIN------------------------------------------------------------------------------------------------
	
public String[] customerLogin(String[] login) {
		
		Connection conn = this.cf.getConnection();
		String[] customerCred = new String[5];
		
		try {
//			String sql = "select * from \"user\"";
			String sql = "select * from \"user\" where username = '" + login[0] + "' and pass = '" + login[1] + "'";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			if(res.next()) {
				customerCred[0] = res.getString("fname");
				customerCred[1] = res.getString("lname");
				customerCred[2] = res.getString("username");
				customerCred[3] = res.getString("pass");
				customerCred[4] = res.getString("user_id");
			} else {
				customerCred[0] = "false";
				return customerCred;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerCred;
		
	};
	
	
//-----------------------------------------------------------------------------VIEW BALANCE-------------------------------------------------------------------------------------------
public ArrayList<Account> customerViewBalance(String[] login) {
		
		Connection conn = this.cf.getConnection();
		Account account;
		String userid = login[4];
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		try {

			String sql = "select u.user_id , fname, lname, username, pass, account_id, account_name, balance from \"user\" u \r\n"
					+ "inner join \r\n"
					+ "accounts a on u.user_id = a.user_id \r\n"
					+ "where u.user_id =" + userid;
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			while(res.next()) {
				accounts.add(account = new Account(res.getInt("user_id"), res.getString("account_name"), res.getDouble("balance"), res.getInt("account_id")));
			} 
			
//			if(!res.next()){
//				System.out.println("No other active account");
//			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
		
	};
	
	
	//-----------------------------------------------------------------------------WITHDRAWAL-------------------------------------------------------------------------------------------
	
	
public ArrayList<Account> customerWithdrawal(String[] login) {
		
		Connection conn = this.cf.getConnection();
		Account account;
		String userid = login[4];
		ArrayList<Account> accounts = new ArrayList<Account>();
		double initialBalance = 0;
		
		
		int accountName;
		
		System.out.print("withdrawal amount: ");
		double withdrawalAmount = this.scan.nextDouble();
		
		try {
			String sql = "select u.user_id , fname, lname, username, pass, account_id, account_name, balance from \"user\" u \r\n"
					+ "inner join \r\n"
					+ "accounts a on u.user_id = a.user_id \r\n"
					+ "where u.user_id =" + userid;
			
			System.out.println("withdraw money from which account:");
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			while(res.next()) {
				accounts.add(account = new Account(res.getInt("user_id"), res.getString("account_name"), res.getDouble("balance"), res.getInt("account_id")));
				System.out.println("Account ID: " + res.getString("account_id") + " : " + res.getString("account_name") + " : " + res.getDouble("balance"));
			} 
			
			accountName = scan.nextInt();
			
			for(int i = 0; i < accounts.size(); i++) {
				if (accountName == accounts.get(i).getAccount_id()){
					initialBalance = accounts.get(i).getBalance(); 
					initialBalance = initialBalance - withdrawalAmount;
					
					
				}
			}
			
			sql = "update accounts set balance = "+ initialBalance + "\r\n"
					+ "where account_id = " + accountName;
			res = s.executeQuery(sql);
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//do nothing for now
		}
		return accounts;
		
	};
	
	
	//-----------------------------------------------------------------------------DEPOSIT-------------------------------------------------------------------------------------------
	
	
public ArrayList<Account> customerDeposit(String[] login) {
		
		Connection conn = this.cf.getConnection();
		Account account;
		String userid = login[4];
		ArrayList<Account> accounts = new ArrayList<Account>();
		double initialBalance = 0;
		
		
		int accountName;
		
		System.out.print("deposit amount: ");
		double depositAmount = this.scan.nextDouble();
		
		try {
			String sql = "select u.user_id , fname, lname, username, pass, account_id, account_name, balance from \"user\" u \r\n"
					+ "inner join \r\n"
					+ "accounts a on u.user_id = a.user_id \r\n"
					+ "where u.user_id =" + userid;
			
			System.out.println("deposit money to which account:");
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			while(res.next()) {
				accounts.add(account = new Account(res.getInt("user_id"), res.getString("account_name"), res.getDouble("balance"), res.getInt("account_id")));
				System.out.println("Account ID: " + res.getString("account_id") + " : " + res.getString("account_name") + " : " + res.getDouble("balance"));
			} 
			
			accountName = scan.nextInt();
			
			for(int i = 0; i < accounts.size(); i++) {
				if (accountName == accounts.get(i).getAccount_id()){
					initialBalance = accounts.get(i).getBalance(); 
					initialBalance = initialBalance + depositAmount;
					
					
				}
			}
			
			sql = "update accounts set balance = "+ initialBalance + "\r\n"
					+ "where account_id = " + accountName;
			res = s.executeQuery(sql);
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//do nothing for now
		}
		return accounts;
		
	}


	

}
