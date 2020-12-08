package com.bank.services;

public interface ModifyingFundProcess {
	
	
	/**
	 * Select an account either checking or savings
	 * Add or remove funds
	 * !remember to implement rules for negative deposit and withdrawal
	 * @return
	 * 			double - Total amount of money after modification has been done
	 */
	
	public double withdrawal(double amount);
	
	public double deposit(double amount);
	

}
