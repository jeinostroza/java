package net.codejava;


import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//import org.apache.log4j.Logger;


public class BankManager {

//	private static final Logger log = Logger.getLogger(BankManager.class);
	
	public static void main(String[] args) {
		
		
		//Database Connection
			String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
			String user="java";
			String pass= "java";
			Queries options = new Queries();
			QueriesCustomer custOpt = new QueriesCustomer();
			Signin signin = new Signin();
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("JAVA BANK APP");
			System.out.println("");
			System.out.println("Please Select and option");
			System.out.println("1.- Employee");
			System.out.println("2.- Client");
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				String usernameEmp = "employee";
		        String passwordEmp = "123456";
		        String usernameE=" ";
		        String passwordE="";
		        
		        while(usernameE.equals(usernameEmp) == false || passwordE.equals(passwordEmp) == false) {
		        	System.out.println("====================================================");
		        	System.out.println("EMPLOYEE LOGIN");
		        	System.out.println(" ");
		        	System.out.println("Username: ");
		        	usernameE = scanner.nextLine();
		        	System.out.println(" ");
		        	System.out.println("Password: ");
		        	passwordE = scanner.nextLine();
		        	System.out.println(" ");
		        }
				
				while (option != "4") {
				System.out.println("EMPLOYEE MENU");
				System.out.println("1.- Approve/reject account");
				System.out.println("2.- View Accounts");
				System.out.println("3.- Log of all transaccions");
				System.out.println("4.- Exit");
				String empOpt = scanner.nextLine();
				switch(empOpt) {
				case "1":
					options.approve();
				
				break;
				
				case "2":
					options.listAccount();				
				break;
				
				case "3":
					options.Transactions();
				break;
				
				case "4":
					System.out.println("HAVE A NICE DAY. SEE YOU TOMORROW :)");
					return;
				}
				}
			case "2":
				Connection connection;
				Statement statement;
				System.out.println("CUSTOMER MENU");
				System.out.println("1.- Log in");
				System.out.println("2.- Sign in ");
				System.out.println("Select an option");
				String optuser = scanner.nextLine();
				switch(optuser) {
				case "1":
					
			        String usernameC="";
			        String passwordC="";
			        String usernameDB = null;
			        String passwordDB = null;
		        
			        while(usernameC.equals(usernameDB) == false || passwordC.equals(passwordDB) == false) {
			        	System.out.println("====================================================");
			        	System.out.println("CUSTOMER LOGIN");
			        	System.out.println(" ");
			        	System.out.println("Username: ");
			        	usernameC = scanner.nextLine();
			        	System.out.println(" ");
			        	System.out.println("Password: ");
			        	passwordC = scanner.nextLine();
			        	System.out.println(" ");
			  
			        	try {
						connection = DriverManager.getConnection(myDB, user, pass);
						String sql = "SELECT username,password FROM Client WHERE username = '"+usernameC+"'";
						statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sql);
						while(result.next()) {
							
								usernameDB = result.getString("username");
								passwordDB = result.getString("password");	

						
					}
			        	connection.close();
						}catch(SQLException ex) {
						ex.printStackTrace();
			        }
			        }
			        				String optionClient = null;
			        				while(optionClient != "6") {
									System.out.println("");
									System.out.println("CLIENT MENU");
									System.out.println(" ");
									System.out.println("1.- Open a Checking Account");
									System.out.println("2.- View Balance");
									System.out.println("3.- Deposit");
									System.out.println("4.- Withdraw");
									System.out.println("5.- Tranfer");
									System.out.println("6.- Exit");
									optionClient = scanner.nextLine();
									switch(optionClient){
									case "1":
										custOpt.open(usernameDB);
									break;
									
									case "2":
										custOpt.viewBal(usernameDB);
									break;
									
									case "3":
										custOpt.Deposit(usernameDB);
									break;
										
									case "4":
										custOpt.withdraw(usernameDB);
									break;
									
									case "5":	
										custOpt.transfer(usernameDB);
									break;
									
									case "6":
										System.out.println("GOOD BYE");
										return;
								}
			        				}
				break;
											
				case "2":
					signin.SignIn();
				break;
			}
	}
	
}
}


