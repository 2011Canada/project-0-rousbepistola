package com.worldbank.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.worldbank.models.Account;
import com.worldbank.util.ConnectionFactory;

public class EmployeeServicesDao {
	
Scanner scan = new Scanner(System.in);
	
	
	private ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	
//	----------------------------------------------------------VIEW BALANCE---------------------------------------------------------------------------------
public ArrayList<Account> customerViewBalance(String[] login) {
		
		Connection conn = this.cf.getConnection();
		Account account;
		String userid;
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		System.out.println("Enter Customer's Unique User Identification");
		userid = scan.next();
		
		try {

			String sql = "select u.user_id , fname, lname, username, pass, account_id, account_name, balance from \"user\" u \r\n"
					+ "inner join\r\n"
					+ "accounts a on u.user_id = a.user_id \r\n"
					+ "where u.user_id =  "+userid+" and isactive=true";
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);

			while(res.next()) {
				accounts.add(account = new Account(res.getInt("user_id"), res.getString("account_name"), res.getDouble("balance"), res.getInt("account_id")));

			} 
			
			
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("");
		}
		return accounts;
		
	};
	
//	----------------------------------------------------------APPROVE ACCOUNT---------------------------------------------------------------------------------
	
	
public ArrayList<Account> approveAccount(String[] login) {
		
		Connection conn = this.cf.getConnection();
		Account account;
		String userid;
		ArrayList<Account> accounts = new ArrayList<Account>();
		
		System.out.println("Enter Customer's Unique User Identification");
		userid = scan.next();
		System.out.println("\n\n\n");
		
		try {

			String sql = "select * from accounts a \r\n"
					+ "where isactive = false and user_id = " + userid;
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			
			while(res.next()) {
				accounts.add(account = new Account(res.getInt("user_id"), res.getString("account_name"), res.getDouble("balance"), res.getInt("account_id")));
				System.out.println("Pending account : " + accounts.get(0).getAccount_name() + "\nAccount ID: " + accounts.get(0).getAccount_id() + "\nInitial Deposit : " + accounts.get(0).getBalance());
			} 
			
			if(accounts.size() <= 0) {
				System.out.println("");
			}else {
				
				int approve = 0;
				System.out.println("\n\n\n");
				System.out.println("Enter 1 to approve account\nOtherwise Enter 0");
				approve = scan.nextInt();
				while(approve < 0 || approve > 1){
					System.out.println("Enter a valid option");
					approve = scan.nextInt();
				}
				
				if(approve == 1) {
					System.out.println("\n\n\nACCOUNT APPROVED\n\n\n");
					
					try {
						 sql = "update accounts a set isactive = true \r\n"
								+ "where isactive = false and account_id = " + accounts.get(0).getAccount_id();
						
						s = conn.createStatement();
						res = s.executeQuery(sql);
						
						
					} catch (Exception e) {

						System.out.println("");
					}
					
					
					
					
					
				} else {
					System.out.println("\n\n\nACCOUNT NOT APPROVED\n\n\n");
				}
				
			}
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("");
		}
		return accounts;
		
	};

}
