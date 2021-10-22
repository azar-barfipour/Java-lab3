package com.banking.app;


	import java.util.Scanner;

	public class BankAccount<s1, s2> {

		int balance;
		int previousTransaction;
		private final s1 customerName;
		private final s2 customerId;
		
		public BankAccount(s1 customerName, s2 customerId) {
			this.customerName = customerName;
			this.customerId = customerId;
		}

		public s1 getCustomerName() {
			return customerName;
		}

		public s2 getCustomerId() {
			return customerId;
		}
		
		void deposit(int amount) {
			if(amount >= 0) {
				balance = balance + amount;
				previousTransaction = amount;
			}else {
				if(amount <= 0) {
					errorMessage("Invalid amount! Please enter correct amount");
				}else {
					errorMessage("Invalid amount! Please enter correct amount");
				}
			}
		}
		
		void withdraw(int amount) {
			if(amount > 0 && balance >= 0 && amount<=balance) {
				balance = balance - amount;
				previousTransaction = -amount;
			}
			else {
				 if(amount>balance ) {
					errorMessage("Insufficient Balance");
				}else 
				{
					errorMessage("Invalid amount! Please enter correct amount");
				}
			}
		}
		
		void getPreviousTransaction() {
			if(previousTransaction > 0) {
				System.out.println("Deposited: $" + previousTransaction);
			}else if(previousTransaction < 0) {
				System.out.println("Withdraw: $" + Math.abs(previousTransaction)); // Withdraw: $10
			}else {
				System.out.println("No transaction occured");
			}
		}
		
		void errorMessage(String message) {
			System.out.println("\n");
			System.out.println("---------------------------");
			System.out.println("!!! " + message);
			System.out.println("---------------------------");
			System.out.println("\n");
		}
		
		void showMenu() {
			
			char option;
			Scanner scanner = new Scanner(System.in);
			
			do {
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				System.out.println("Welcome to Unchi Bank");
				System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
				System.out.println("A : Check Your Balance");
				System.out.println("B : Deposit");
				System.out.println("C : Withdraw");
				System.out.println("D : Previous Transaction");
				System.out.println("E : Quit");
				option = scanner.next().charAt(0); //[a]sdasdasfas
				System.out.println("\n");
				
				switch (Character.toLowerCase(option)) {
					case 'a': 
						System.out.println("--------------------------------");
						System.out.println("Balance = $" + balance);
						System.out.println("--------------------------------");
						System.out.println("\n");
						break;
						
					case 'b':
						System.out.println("--------------------------------");
						System.out.println("Enter an amount to deposit");
						System.out.println("--------------------------------");
						
						try {
							int amount = scanner.nextInt();	
							deposit(amount);
						}catch (Exception e) {
							errorMessage("Wrong Input! Only integer numbers please...");
//							scanner.nextLine();
						}
						
						
						break;
					
					case 'c':
						System.out.println("--------------------------------");
						System.out.println("Enter an amount to withdraw");
						System.out.println("--------------------------------");
						
						try {
							int amount2 = scanner.nextInt();
							withdraw(amount2);
						}catch (Exception e) {
							errorMessage("Wrong Input! Only integer numbers please...");
//							scanner.nextLine();
						}
						
						break;
						
					case 'd':
						System.out.println("--------------------------------");
						getPreviousTransaction();
						System.out.println("--------------------------------");
						
						break;
					
					case 'e':
						System.out.println("================================");
						break;
					default:
						System.out.println("Invalid Option. Please try again.");
						break;
				}
				
				
			}while(Character.toLowerCase(option) != 'e');
			System.out.println("Thank you for banking with us...");
			scanner.close();
			
		}
		
		
	}

