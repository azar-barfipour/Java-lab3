package com.banking.app;

public class Main {

	public static void main(String[] args) {
		BankAccount<String, String> account = new BankAccount<>("dummy","user001");
		System.out.println("Welcome " + account.getCustomerName());
		System.out.println("Your ID is: " + account.getCustomerId());
		System.out.println("\n");
		
		account.showMenu();

	}

	}

