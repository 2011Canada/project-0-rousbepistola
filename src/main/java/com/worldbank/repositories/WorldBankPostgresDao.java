package com.worldbank.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.worldbank.util.ConnectionFactory;

public class WorldBankPostgresDao {
	
	
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
	
	
	

}
