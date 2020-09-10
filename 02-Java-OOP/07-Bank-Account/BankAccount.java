package com.franka.bank;

import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance, savingsBalance;
	private static double numberOfAccounts = 0;
	private static double totalBalance = 0;
	
	public BankAccount() {
		this.accountNumber = accountNumberGenerator();
		numberOfAccounts++;
	}
	
	private String accountNumberGenerator() {
		Random r = new Random();
		String s = "";
		for(int i = 0;i<10;i++)
			s += Integer.toString(r.nextInt(9));
		return s;
	}
	
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	
	public void depositMoney(char account, double deposit) {
		if(account == 'c') {
			this.checkingBalance += deposit;
			totalBalance += deposit;
		}
		else if(account == 's') {
			this.savingsBalance += deposit;
			totalBalance += deposit;
		}
	}
	
	public void withdrawMoney(char account, double amount) {
		if(account == 'c')
			if(this.checkingBalance >= amount) {
				this.checkingBalance -= amount;
				totalBalance -= amount;
			}
		else if(account == 's')
				if(this.savingsBalance >= amount) {
					this.savingsBalance -= amount;
					totalBalance -= amount;
				}
	}
	
	public double checkingAndSavings() {
		return this.getCheckingBalance() + this.getSavingsBalance();
	}
	
}
