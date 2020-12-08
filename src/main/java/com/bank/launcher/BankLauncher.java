package com.bank.launcher;

import com.bank.display.BankMenu;

public class BankLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankMenu menu = new BankMenu();
		
		while(true) {
			System.out.println(menu.display());
			break;
		}

	}

}
