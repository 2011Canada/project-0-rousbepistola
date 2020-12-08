package com.revature.repositories;

import java.util.ArrayList;
import java.util.List;



public class BankUserDatabase {
	
	static List<User> userList = new ArrayList<User>();

	// static code block is a block of code that will execute when the program
	// before the main method
	static {
		User user1 = new User("Rous","Epistola","rousbepistola@yahoo.com","1234", 500);
		User user2 = new User("Rous1","Apistola","Aousbepistola@yahoo.com","1234", 500);
		User user3 = new User("Rous2","Bpistola","Bousbepistola@yahoo.com","1234", 500);
		User user4 = new User("Rous3","Cpistola","Cousbepistola@yahoo.com","1234", 500);
		User user5 = new User("Rous4","Dpistola","Dousbepistola@yahoo.com","1234", 500);
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
	}


}
