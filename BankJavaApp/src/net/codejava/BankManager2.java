package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
//import org.apache.log4j.Logger;
import java.util.Random;

public class BankManager2 {

//	private static final Logger log = Logger.getLogger(BankManager.class);
	
	public static void main(String[] args) {
		
		
		//Database Connection
			String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
			String user="java";
			String pass= "java";
			Queries appr = new Queries();
			String first_name, last_name = null, street = null, city = null, zip_code = null, state = null, username = null;
	
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
					
					System.out.println("APPROVE / REJECT ACCOUNT");
					appr.approve();
//					try {
//						Connection connection = DriverManager.getConnection(myDB, user, pass);
//						String sql = "SELECT ID_CLIENT, FIRST_NAME, LAST_NAME, STREET, CITY, ZIP_CODE, STATE, USERNAME FROM Client WHERE APPLY = 'y' AND CH_ACC IS NULL";
//						Statement statement = connection.createStatement();
//						ResultSet result = statement.executeQuery(sql);
//						while(result.next()) {
//							int id_client = result.getInt("ID_CLIENT");
//							first_name = result.getString("first_name");
//							last_name = result.getString("last_name");
//							street = result.getString("street");
//							city = result.getString("city");
//							zip_code = result.getString("zip_code");
//							state = result.getString("state");
//							username = result.getString("username");
//									
//	
//							System.out.println("Id Client: " + id_client);
//							System.out.println("First name: " + first_name);
//							System.out.println("Last name: " + last_name);
//							System.out.println("Street: " + street);
//							System.out.println("City: " + city);
//							System.out.println("Zip Code: " + zip_code);
//							System.out.println("State: " + state);
//							System.out.println("Username: " + username);
//							System.out.println("=================================");
//							System.out.println(" ");
//							
//						}
//						Random Num1 = new Random();
//						Random Num2 = new Random();
//						String ch_acc = "CH" + (Integer.toString(1 + Num1.nextInt(10000000))); 
//						String sv_acc = "SV" + (Integer.toString(1 + Num2.nextInt(10000000)));
//						System.out.println("Please select account that you want to approve: ");
//						String appOpt = scanner.nextLine();
//						
//						String sql1 = "UPDATE Client SET CH_ACC = '"+ch_acc+"' WHERE username = '"+appOpt+"'";
//						String sql4 = "UPDATE Client SET SV_ACC = '"+sv_acc+"' WHERE username = '"+appOpt+"'";
//						
//						Statement statement1 = connection.createStatement();
//						int rows = statement1.executeUpdate(sql1);
//						Statement statement2 = connection.createStatement();
//						int rows1 = statement2.executeUpdate(sql4);
//						if (rows >0 || rows1 >0) {
//							System.out.println("Thank you. Information has been updated.");
//												
//							
//						}
//
//						
//						connection.close();
//						}catch(SQLException ex) {
//							ex.printStackTrace();
//						}
					break;
				
				case "2":
					System.out.println("ACCOUNTS");
					System.out.println("");
					System.out.println("Enter First name: ");
					first_name = scanner.nextLine();
					System.out.println("Enter Last name: ");
					last_name = scanner.nextLine();
					String ch_acc = null;
					String sv_acc = null;
					String balance_ch = null;
					String balance_sv = null;
					int id_client = 0;
					String sum_ch = null;
					String sum_sv = null;
						//+++++++++++++++++++++++++++++++++++++++++
						try {
							Connection connection = DriverManager.getConnection(myDB, user, pass);
							String sql = "SELECT ID_CLIENT, FIRST_NAME, LAST_NAME, STREET, CITY, ZIP_CODE, STATE, USERNAME, CH_ACC, SV_ACC FROM Client WHERE FIRST_NAME = '"+first_name+"' AND LAST_NAME = '"+last_name+"'" ;
							Statement statement = connection.createStatement();
							ResultSet result = statement.executeQuery(sql);
							while(result.next()) {
								id_client = result.getInt("ID_CLIENT");
								first_name = result.getString("first_name");
								last_name = result.getString("last_name");
								street = result.getString("street");
								city = result.getString("city");
								zip_code = result.getString("zip_code");
								state = result.getString("state");
								username = result.getString("username");
								ch_acc = result.getString("ch_acc");
								sv_acc = result.getString("sv_acc");
							}	
							
							String sql8 = "SELECT SUM (amount_trans) FROM transaction WHERE acc_num = '"+ch_acc+"'";
							ResultSet result1 = statement.executeQuery(sql8);
							while(result1.next()) {
								sum_ch = result1.getString(1);
							}
						
							
							String sql9= "SELECT SUM (amount_trans) FROM transaction WHERE acc_num = '"+sv_acc+"'";
							ResultSet result2 = statement.executeQuery(sql9);
							while(result2.next()) {
								sum_sv = result2.getString(1);
							}
		
								System.out.println("Id Client: " + id_client);
								System.out.println("First name: " + first_name);
								System.out.println("Last name: " + last_name);
								System.out.println("Street: " + street);
								System.out.println("City: " + city);
								System.out.println("Zip Code: " + zip_code);
								System.out.println("State: " + state);
								System.out.println("Username: " + username);
								System.out.println("Checking Account: " + ch_acc);
								System.out.println("Balance: " + sum_ch );
								System.out.println("Saving Account: " + sv_acc);
								System.out.println("Balance: " + sum_sv);
								System.out.println("=================================");
								System.out.println(" ");
								
							
																				
							connection.close();
							}catch(SQLException ex) {
								ex.printStackTrace();
							}
						
					


					
					break;
				case "3":
					System.out.println("TRANSACTIONS");
					
					try {
						Connection connection = DriverManager.getConnection(myDB, user, pass);
						String sql = "SELECT id_trans, amount_trans, acc_num FROM transaction ORDER BY acc_num";
						
						Statement statement = connection.createStatement();
						ResultSet result = statement.executeQuery(sql);
						while(result.next()) {
							
								String id_trans = result.getString("id_trans");
								String amount_trans = result.getString("amount_trans");
								String acc_num = result.getString("acc_num");
								System.out.println("Transaction ID: " +id_trans + "    " +" Amount transaction: " + amount_trans + "    " +" Account number: " + acc_num);
								
								
								}
											
						connection.close();
						}catch(SQLException ex) {
						ex.printStackTrace();
						}
					//+++++++++++++++++++++++++++++++++++++++++++
					break;
				case "4":
					System.out.println("HAVE A NICE DAY. SEE YOU TOMORROW :)");
					return;
				}
				}
			case "2":
				username = "";
				String password = "";
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
										System.out.println("OPEN ACCOUNT");
										System.out.println(" ");
										System.out.println("Do you want to apply to a checking account(y/n)");
										String optionApply = scanner.nextLine();
										
										try {
											connection = DriverManager.getConnection(myDB, user, pass);
											String sql1 = "UPDATE Client SET APPLY = '"+optionApply+"' WHERE username = '"+usernameC+"'";
											Statement statement1 = connection.createStatement();
											int rows = statement1.executeUpdate(sql1);
											if (rows >0) {
												System.out.println("Thank you. Information has been updated.");
											}
											
											connection.close();
										}catch(SQLException ex) {
											ex.printStackTrace();
										}
									break;
									case "2":
										System.out.println("BALANCE");
										System.out.println(" ");
										System.out.println("1.- Checking account");
										System.out.println("2.- Saving account");
										String balance = scanner.nextLine();
										switch(balance) {
										case "1":
											try {
												String ch_acc = null;
												System.out.println(usernameDB);
												connection = DriverManager.getConnection(myDB, user, pass);
												String sql7 = "SELECT ch_acc FROM Client WHERE username = '"+usernameDB+"'";	
												
												statement = connection.createStatement();
												ResultSet result7 = statement.executeQuery(sql7);
												while(result7.next()) {													
														ch_acc = result7.getString("CH_ACC");									
																
														
												}	
												String sql8 = "SELECT SUM (amount_trans) FROM transaction WHERE acc_num = '"+ch_acc+"'";
												statement = connection.createStatement();
												ResultSet result8 = statement.executeQuery(sql8);
												while(result8.next()) {
													String sum = result8.getString(1);
													System.out.println("The balance of your checking account is " + sum);
													System.out.println(" ");
													System.out.println(" ");
												}
												connection.close();
											}catch(SQLException ex) {
												ex.printStackTrace();
												}
											break;
										case "2":
											try {
												String sv_acc = null;
												System.out.println(usernameDB);
												connection = DriverManager.getConnection(myDB, user, pass);
												String sql7 = "SELECT sv_acc FROM Client WHERE username = '"+usernameDB+"'";	
												
												statement = connection.createStatement();
												ResultSet result7 = statement.executeQuery(sql7);
												while(result7.next()) {													
														sv_acc = result7.getString("SV_ACC");									
																
														
												}	
												String sql8 = "SELECT SUM (amount_trans) FROM transaction WHERE acc_num = '"+sv_acc+"'";
												statement = connection.createStatement();
												ResultSet result8 = statement.executeQuery(sql8);
												while(result8.next()) {
													String sum = result8.getString(1);
													System.out.println("The balance of your saving account is " + sum);
													System.out.println(" ");
													System.out.println(" ");
												
												}
												connection.close();
											}catch(SQLException ex) {
												ex.printStackTrace();
												}
											break;
										}
									break;
									case "3":
										String accForDep = null;
										System.out.println("DEPOSIT");
										System.out.println(" ");
										System.out.println("1.- Checking account");
										System.out.println("2.- Saving account");
																			
										String typeAcc = scanner.nextLine();
										
										switch (typeAcc) {
										case "1":																				
											try {
												System.out.println(username);
												connection = DriverManager.getConnection(myDB, user, pass);
												String sql7 = "SELECT ch_acc FROM Client WHERE username = '"+usernameDB+"'";
												
												statement = connection.createStatement();
												ResultSet result7 = statement.executeQuery(sql7);
												while(result7.next()) {
													
														accForDep = result7.getString("CH_ACC");									
														//System.out.println(accForDep);
														
																}	connection.close();
																}catch(SQLException ex) {
																	ex.printStackTrace();
																}
											break;
										case "2": 
											try {
												connection = DriverManager.getConnection(myDB, user, pass);
												String sql8 = "SELECT sv_acc FROM Client WHERE username = '"+usernameDB+"'";
												
												statement = connection.createStatement();
												ResultSet result8 = statement.executeQuery(sql8);
												while(result8.next()) {
													
														accForDep = result8.getString("SV_ACC");
														//System.out.println(accForDep);
														
														
																}	connection.close();
																}catch(SQLException ex) {
																	ex.printStackTrace();
																}
											break;
										}
										System.out.println("Enter deposit account: ");
										double dep = Double.parseDouble(scanner.nextLine());
										
//										username = result.getString("username");
										try {	
											connection = DriverManager.getConnection(myDB, user, pass);		
											
											String sql5 = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
											
											PreparedStatement statement1 = connection.prepareStatement(sql5);
											statement1.setDouble(1, dep);
											statement1.setString(2, accForDep);
											
											
											int rows = statement1.executeUpdate();
											
											if (rows >0 ) {
												System.out.println("Your information has been insert successfully");
											}
											
												connection.close();
													
										}catch(SQLException ex) {
											System.out.println(ex.getMessage());
										}

										break;
									case "4":
										//++++++++++++++++++++++++++++++++++++++++++++++++++++++++
										String sv_acc = null;
										String sum_ch = null;
										String ch_acc = null;
										String sum_sv = null;
										Double bal;
										Double with;
										System.out.println("WITHDRAW");
										System.out.println(" ");
										System.out.println("1.- Checking account");
										System.out.println("2.- Saving account");
										
																			
										typeAcc = scanner.nextLine();
										
										switch (typeAcc) {
										case "1":										
											//+++++++++++++++++++++++++++++++++++++++++
											try {
											connection = DriverManager.getConnection(myDB, user, pass);											
											statement = connection.createStatement();
											String sql9 = "SELECT ch_acc from Client where username = '"+usernameC+"'";
											ResultSet result2 = statement.executeQuery(sql9);
											while(result2.next()) {
												ch_acc = result2.getString("ch_acc");
											}
											String sql8 = "SELECT SUM (amount_trans) FROM transaction WHERE acc_num = '"+ch_acc+"'";
											ResultSet result22 = statement.executeQuery(sql8);
											while(result22.next()) {
												sum_ch = result22.getString(1);
											}
											connection.close();
											}catch(SQLException ex) {
												ex.printStackTrace();
											}
											
											System.out.println(ch_acc);
											System.out.println(sum_ch);
											System.out.println("Enter withdraw account: ");
											with = Double.parseDouble(scanner.nextLine());
											bal = Double.parseDouble(sum_ch);
											//double withdraw = -dep;
											System.out.println(with);
											System.out.println(bal);
											if (with>bal) {
											System.out.println("Insufficient funds");
											}else {
												double amWith=-with;
												try {	
												connection = DriverManager.getConnection(myDB, user, pass);		
												
												String sqlch = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
												
												PreparedStatement statement18 = connection.prepareStatement(sqlch);
												statement18.setDouble(1, amWith);
												statement18.setString(2, ch_acc);											
												
												int rows = statement18.executeUpdate();
												
												if (rows >0 ) {
													System.out.println("Your information has been insert successfully");
												}
												
													connection.close();
													
														
											}catch(SQLException ex) {
												System.out.println(ex.getMessage());
											
											}
											}
											break;
								
//											try {
//												
//												connection = DriverManager.getConnection(myDB, user, pass);
//												String sql7 = "SELECT ch_acc FROM Client WHERE username = '"+usernameC+"'";
//												
//												statement = connection.createStatement();
//												ResultSet result7 = statement.executeQuery(sql7);
//												while(result7.next()) {
//													
//														accForDep = result7.getString("CH_ACC");									
//														System.out.println(accForDep);
//												}
//										
//																connection.close();
//																}catch(SQLException ex) {
//																	ex.printStackTrace();
//																}
										
																						
										case "2": 						
											try {												
												connection = DriverManager.getConnection(myDB, user, pass);
												String sql8 = "SELECT sv_acc FROM Client WHERE username = '"+usernameC+"'";												
												statement = connection.createStatement();
												ResultSet result8 = statement.executeQuery(sql8);
												while(result8.next()) {													
														sv_acc = result8.getString("SV_ACC");
														//System.out.println(accForDep);
														
												}
												String sql12 = "SELECT SUM (amount_trans) FROM transaction WHERE acc_num = '"+sv_acc+"'";
												ResultSet result12 = statement.executeQuery(sql12);
												while(result12.next()) {
													sum_sv = result12.getString(1);
												}
												
												connection.close();
																}catch(SQLException ex) {
																	ex.printStackTrace();
																}
																				
										
										System.out.println("Enter withdraw account: ");
										with = Double.parseDouble(scanner.nextLine());
										bal = Double.parseDouble(sum_sv);
										double withsv = -with;
										System.out.println(withsv);
										System.out.println(bal);
										if (with>bal) {
										System.out.println("Insufficient funds");
										}else {
											
											try {	
											connection = DriverManager.getConnection(myDB, user, pass);		
											
											String sql5 = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
											
											PreparedStatement statement1 = connection.prepareStatement(sql5);
											statement1.setDouble(1, withsv);
											statement1.setString(2, sv_acc);											
											
											int rows = statement1.executeUpdate();
											
											if (rows >0 ) {
												System.out.println("Your information has been insert successfully");
											}
											
												connection.close();
												
													
										}catch(SQLException ex) {
											System.out.println(ex.getMessage());
										
										}
											
										break;
										}
										}
									break;
									case "5":										
										System.out.println("TRANSFER");
										System.out.println(" ");
										System.out.println("1.- From checking to saving");
										System.out.println("2.- From saving to checking");
																			
										String typetrans = scanner.nextLine();
										String check = null;
										String save = null;
											try {
												System.out.println(usernameDB);
												connection = DriverManager.getConnection(myDB, user, pass);
												String sqlacc = "SELECT ch_acc, sv_acc FROM Client WHERE username = '"+usernameDB+"'";
																	
												statement = connection.createStatement();
												ResultSet result7 = statement.executeQuery(sqlacc);
												while(result7.next()) {
								
													check = result7.getString("ch_acc");
													save = result7.getString("sv_acc");
													System.out.println(check);
													System.out.println(save);
													System.out.println(username);
													
										
																}	connection.close();
																}catch(SQLException ex) {
																	ex.printStackTrace();
																}
											
											System.out.println("Enter deposit account: ");
											dep = Double.parseDouble(scanner.nextLine());
										switch (typetrans) {
										case "1":															
											try {	
											connection = DriverManager.getConnection(myDB, user, pass);		
											//++++++++++++++++++++++++++++++++++++
											String sql8 = "SELECT SUM (amount_trans) FROM transaction WHERE acc_num = '"+check+"'";
											statement = connection.createStatement();
											ResultSet result8 = statement.executeQuery(sql8);
											while(result8.next()) {
												double sum = result8.getDouble(1);
												System.out.println(sum);
											//+++++++++++++++++++++++++++++++++++++
											if (dep <= sum)	{
											String sqlcheck = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
											String sqlsave = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
											
											PreparedStatement statement1 = connection.prepareStatement(sqlcheck);
											PreparedStatement statement2 = connection.prepareStatement(sqlsave);
											statement1.setDouble(1, -dep);
											statement1.setString(2, save);
											statement2.setDouble(1, dep);
											statement2.setString(2, check);
											//statement1.setString(2, accForDep);
											
											
											int rows = statement1.executeUpdate();
											int rows2 = statement2.executeUpdate();
											
											if (rows >0 && rows2 >0) {
												System.out.println("Your information has been insert successfully");
											}
											}else {
												System.out.println("Insufficient balance");
											}
												
											}	connection.close();
											
											}catch(SQLException ex) {
											System.out.println(ex.getMessage());
											}
											break;
																		
										case "2": 
											try {	
												connection = DriverManager.getConnection(myDB, user, pass);
												
												
												String sqlcheck = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
												String sqlsave = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
												
												PreparedStatement statement1 = connection.prepareStatement(sqlcheck);
												PreparedStatement statement2 = connection.prepareStatement(sqlsave);
												statement1.setDouble(1, dep);
												statement1.setString(2, save);
												statement2.setDouble(1, -dep);
												statement2.setString(2, check);
												//statement1.setString(2, accForDep);
												
												
												int rows = statement1.executeUpdate();
												int rows2 = statement2.executeUpdate();
												
												if (rows >0 && rows2 >0) {
													System.out.println("Your information has been insert successfully");
												}
												
													connection.close();
														
												}catch(SQLException ex) {
												System.out.println(ex.getMessage());
												}
										}
									break;
									
									case "6":
										System.out.println("GOOD BYE");
										return;
								}
			        				}
				break;
						
						
				case "2":
					System.out.println("Please enter the following information.");
					System.out.println("First name: ");
					first_name = scanner.nextLine();
					System.out.println("Last name: ");
					last_name = scanner.nextLine();
					System.out.println("Street: ");
					street = scanner.nextLine();
					System.out.println("City: ");
					city = scanner.nextLine();
					System.out.println("State: ");
					state = scanner.nextLine();
					System.out.println("Zip code: ");
					zip_code = scanner.nextLine();
					System.out.println("Username: ");
					username = scanner.nextLine();
					System.out.println("Password: ");
					password = scanner.nextLine();
					try {	
						connection = DriverManager.getConnection(myDB, user, pass);		
				
						
						String sql = "INSERT INTO client (first_name,last_name,street,city,state,zip_code,username,password) VALUES (?,?,?,?,?,?,?,?)";
						
						PreparedStatement statement1 = connection.prepareStatement(sql);
						statement1.setString(1, first_name);
						statement1.setString(2, last_name);
						statement1.setString(3, street);
						statement1.setString(4, city);
						statement1.setString(5, state);
						statement1.setString(6, zip_code);
						statement1.setString(7, username);
						statement1.setString(8, password);
						
						int rows = statement1.executeUpdate();
						
						if (rows >0 ) {
							System.out.println("Your information has been insert successfully");
						}
						
							connection.close();
								
					}catch(SQLException ex) {
						System.out.println(ex.getMessage());
					}
							}
				break;
			}
		

	}
	
}


