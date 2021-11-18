import java.util.Scanner;

public class Account {
	//Class Variables
	int balance;
	int previousTransaction;
	String customerName; 
	String customerID;
	//defines 4 variables that can be used throughout the class
	
	//class constructor
	Account(String cname, String cid){
		customerName = cname;
		customerID = cid; 
	//constructor initialize the variables, now the objects are usable as variables.
	}
	
	//Function for withdrawing money
	void deposit(int amount){ // void is used so we don't need a return type
		if(amount != 0){
			balance = balance + amount; // balance equals last known balance + amount
			previousTransaction = amount; // amount is defined as the previous transaction that was made.
		}
	}
	
	//Function for withdrawing money
	void withdraw(int amount) { // void is used so we don't need a return type
		if (amount != 0){
			balance = balance - amount; // balance is equal to the previous balance subtracted by the amount that was withdraw
			previousTransaction = -amount; // previous transaction equals the negative of what the user input as amount.
		}
	}
	
	//Function showing the previous transaction
	void getPreviousTransaction(){
		if (previousTransaction > 0){ //if previous transaction was positive number then it was deposited, if it was negative it was withdrawn.
			System.out.println("Deposited: " + previousTransaction);
		} else if (previousTransaction < 0){
			System.out.println("Withdrawn: " + Math.abs(previousTransaction)); //prints out the absolute value of "amount" to display how much was withdrawn
		}
				
	}
	
	//Function calculating interest of current funds after a number of years
	void calculateInterest(int years){
		double interestRate = .0185; //setting a default value of interest rate in this case it is 1.85%
		double newBalance = (balance * interestRate * years) + balance; // basic math to get new balance after letting the money collect interest for a given time period, "years"
		System.out.println("The current interest rate is " + (100 * interestRate) + "%");
		System.out.println("After " + years + " years, your balance will be: $" + newBalance);
		
	}
	
	//Function showing the main menu and options the user has to input.
	void showMenu(){
		char option = '\0';
		System.out.println("Welcome to The Great Bank of Abbad!");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome, " + customerName + "!");
		System.out.println("Your ID is: " + customerID);
		System.out.println();
		System.out.println("What would you like to do?");
		System.out.println();
		System.out.println("A. Check your balance");
		System.out.println("B. Make a deposit");
		System.out.println("C. Make a withdrawl");
		System.out.println("D. view previous transaction");
		System.out.println("E. Calculate interest");
		System.out.println("F. Exit");
		
		do {
			System.out.println();
			System.out.println("Enter an option: ");
			char option1 = scanner.next().charAt(0); // charAt only considers character given in the parameter, if the word apple is printed only the 0th value would be considered in this case it would be 'a'
			option = Character.toUpperCase(option1); // converts user input to upper case so it can be used in switch statements later on. using option1 and option allows users to input either uppr or lower case.
			System.out.println();
			
			switch(option) {
			//case 'A' allows the user to check their account balance
			case 'A' :
				System.out.println("====================");
				System.out.println("Balance = $" + balance);
				System.out.println("====================");
				System.out.println();
				break;
			//Case 'B' allows the user to deposit money into their account using 
			case 'B':
				System.out.println("Enter an amount to deposit: ");
				int amount = scanner.nextInt();
				deposit(amount);
				System.out.println();
				break;
				//Case 'C' allows the user to withdraw money from their account using the 'withdraw' function
			case 'C':
				System.out.println("Enter an amount to withdraw: ");
				int amount2 = scanner.nextInt(); //creates another amount variable so user can do multiple things in one session, withdraw or deposit
				withdraw(amount2);
				System.out.println();
				break;
			//Case 'D' allows the user to view their most recent transaction using the 'getPreviousTransaction' function
			case 'D':
				System.out.println("====================================");
				getPreviousTransaction();//calls the getPreviousTransaction function
				System.out.println("====================================");
				System.out.println();
				break;
			//Case 'E' calculates the accrued interest on the account after a number of years specified by the user
			case 'E':
				System.out.println("Enter how many years of accrued interest: ");
				int years = scanner.nextInt();//gets the years the user wants their money to be collecting interest for.
				calculateInterest(years);
				break;
			//Case 'F' exits the user from their account
			case 'F':
				System.out.println("====================================");
				break;
			//The default case let's the user know that they entered an invalid character and how to enter a valid one
			default:
				System.out.println("Error: invalid option. Please enter A, B, C, D, or E or access services.");
				break;
			}
		} while(option != 'F');//does the do loop until the user inputs F to break the loop and exit.
		System.out.println("Thank you " + customerName + " for banking with us!");
	}
}
