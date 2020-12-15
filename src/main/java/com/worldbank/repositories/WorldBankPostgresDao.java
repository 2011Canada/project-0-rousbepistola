package com.worldbank.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.worldbank.models.Account;
import com.worldbank.models.Transfers;
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
		
		
//		double withdrawalAmount = this.scan.nextDouble();
//		while(withdrawalAmount <= 0) {
//			System.out.print("Please withdraw a valid amount: ");
//			withdrawalAmount = this.scan.nextDouble();
//		}
		
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
					System.out.print("withdrawal amount: ");
					double withdrawalAmount = this.scan.nextDouble();
					while(withdrawalAmount <= 0 || withdrawalAmount > accounts.get(i).getBalance()) {
						System.out.print("Please withdraw a valid amount: ");
						withdrawalAmount = this.scan.nextDouble();
					}
					
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
					
					System.out.print("deposit amount: ");
					double depositAmount = this.scan.nextDouble();
					while(depositAmount <= 0) {
						System.out.print("Please deposit a valid amount: ");
						depositAmount = this.scan.nextDouble();
					}
					
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

//-----------------------------------------------------------------------------TRANSFERS-------------------------------------------------------------------------------------------


public ArrayList<Account> customerTransfer(String[] login) {
		
		Connection conn = this.cf.getConnection();
		Account account;
		String userid = login[4];
		ArrayList<Account> accounts = new ArrayList<Account>();
		double initialBalance = 0;
		int transferToAccountNumber;
		String transferPassword;
		double transferAmount = 0;
		
		
		int accountName;
		
//		System.out.print("transfer amount: ");
//		double depositAmount = this.scan.nextDouble();
		
		try {
			String sql = "select u.user_id , fname, lname, username, pass, account_id, account_name, balance from \"user\" u \r\n"
					+ "inner join \r\n"
					+ "accounts a on u.user_id = a.user_id \r\n"
					+ "where u.user_id =" + userid;
			
			
			Statement s = conn.createStatement();
			ResultSet res = s.executeQuery(sql);
			while(res.next()) {
				accounts.add(account = new Account(res.getInt("user_id"), res.getString("account_name"), res.getDouble("balance"), res.getInt("account_id")));
				System.out.println("Account ID: " + res.getString("account_id") + " : " + res.getString("account_name") + " : " + res.getDouble("balance"));
			} 
			
			System.out.println("transfer money from which account:");
			accountName = scan.nextInt();
			
			
			for(int i = 0; i < accounts.size(); i++) {
				if (accountName == accounts.get(i).getAccount_id()){
					System.out.print("transfer amount: ");
					double transferInput = this.scan.nextDouble();
					
					while(transferInput <= 0 || transferInput > accounts.get(i).getBalance()) {
						System.out.print("Please transfer a valid amount: ");
						transferInput = this.scan.nextDouble();
					}
					transferAmount = transferInput;
					initialBalance = accounts.get(i).getBalance(); 
					initialBalance = initialBalance - transferInput;
				} 
			}
			
			try {
				sql = "update accounts set balance = "+ initialBalance + "\r\n"
						+ "where account_id = " + accountName;
				res = s.executeQuery(sql);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("\n");
			}
			
			
			System.out.println("TRANSFER TO");
			System.out.println("Account number: ");
			transferToAccountNumber = scan.nextInt();
			System.out.println("Transfer password: ");
			transferPassword = scan.next();
			
			
			try {
                //now we update another table
			sql = "insert into transfers ( account_id, transfer_pass, amount, \"isTransferred\")\r\n"
					+ "values(" + transferToAccountNumber + ", '"+ transferPassword +"', "+ transferAmount +", false) returning transfer_id";
			res = s.executeQuery(sql);
//			System.out.println("<<<<<<<<<<<<<returning");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("problem2");
			}

			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//do nothing for now
			System.out.println(e);
		}
		return accounts;
		
	}


//----------------------------------------------------------------------------- RECEIVE TRANSFERS-------------------------------------------------------------------------------------------
public ArrayList<Transfers> receiveTransfer(String[] login) {

	Connection conn = this.cf.getConnection();
	Transfers transfer;
	String userid = login[4];
	ArrayList<Transfers> transfers = new ArrayList<Transfers>();
	int transferToAccountNumber;
	String transferPassword;
	double newBalance;

	

	
	try {
		String sql = "select * from accounts a \r\n"
				+ "inner join transfers t on t.account_id = a.account_id \r\n"
				+ "where a.user_id = " + userid + " and \"isTransferred\" = 'false'";
		
		System.out.println("PENDING TRANSFERS:");
		Statement s = conn.createStatement();
		ResultSet res = s.executeQuery(sql);
		while(res.next()) {
			transfers.add(transfer = new Transfers(res.getInt("account_id"), res.getString("account_name"), res.getDouble("amount"), res.getString("transfer_pass"), res.getDouble("balance")));
			System.out.println("Account Number: " + res.getInt("account_id") + " : " + res.getString("account_name") + " :  Amount: $" + res.getDouble("amount"));
		} 
		
		if(transfers.size() == 0) {
			System.out.println("\nNo Pending Transfers\n");
		} else {
			System.out.println("\n\nEnter account number");
			transferToAccountNumber = scan.nextInt();
			System.out.println("Enter transfer password");
			transferPassword = scan.next();
			
			for(int i = 0; i < transfers.size(); i++) {
				if((transferToAccountNumber == transfers.get(i).getAccount_id()) || (transferPassword == transfers.get(i).getPass())) {
					System.out.println("\n\nAmount deposited to " + transfers.get(i).getAccount_name() + " account. Amount: $" + transfers.get(i).getAmount());
					newBalance = transfers.get(i).getBalance() + transfers.get(i).getAmount();
				
						try {
							sql =  "update accounts set balance = "+ newBalance + "\r\n"
									+ "where account_id = " + transferToAccountNumber;
							res = s.executeQuery(sql);
							System.out.println("deposit done");
							
						} catch (Exception e) {
							System.out.println("");
						}
						
						try {
							sql ="update transfers set \"isTransferred\" = true "
									+ "where account_id = " + transferToAccountNumber;
							
							res = s.executeQuery(sql);
							System.out.println("");
						} catch (Exception e) {
							System.out.println("");
						}
						
						
						
				
					
				}else {
					System.out.println("Unsuccesful Transfer. Please try again");
				}
			}
			
			
		}
		
	
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	
	
	
	return transfers;
	
	
	
	
}

	

}
