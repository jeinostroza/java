package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class QueriesCustomer {
	
	Scanner scanner = new Scanner(System.in);
	String first_name, last_name = null, street = null, city = null, zip_code = null, state = null, username = null;
	
	
	public void open(String username) {
		String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="java";
		String pass= "java";
		
		String usernameC=username;
	
		
		System.out.println("OPEN ACCOUNT");
		System.out.println(" ");
		System.out.println("Do you want to apply to a checking account(y/n)");
		String optionApply = scanner.nextLine();
		
		try {
			Connection connection = DriverManager.getConnection(myDB, user, pass);
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
	}
	public void viewBal(String username) {
		
		String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="java";
		String pass= "java";
		
		String usernameDB = username;
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
				Connection connection = DriverManager.getConnection(myDB, user, pass);
				String sql7 = "SELECT ch_acc FROM Client WHERE username = '"+usernameDB+"'";	
				
				Statement statement = connection.createStatement();
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
				Connection connection = DriverManager.getConnection(myDB, user, pass);
				String sql7 = "SELECT sv_acc FROM Client WHERE username = '"+usernameDB+"'";	
				
				Statement statement = connection.createStatement();
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
	}
	public void Deposit(String username) {
		
		String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="java";
		String pass= "java";
		
		String usernameDB = username;
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
				Connection connection = DriverManager.getConnection(myDB, user, pass);
				String sql7 = "SELECT ch_acc FROM Client WHERE username = '"+usernameDB+"'";
				
				Statement statement = connection.createStatement();
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
				Connection connection = DriverManager.getConnection(myDB, user, pass);
				String sql8 = "SELECT sv_acc FROM Client WHERE username = '"+usernameDB+"'";
				
				Statement statement = connection.createStatement();
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
		

		try {	
			Connection connection = DriverManager.getConnection(myDB, user, pass);		
			
			String sql5 = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
			
			PreparedStatement statement1 = connection.prepareStatement(sql5);
			statement1.setDouble(1, dep);
			statement1.setString(2, accForDep);
			
			
			int rows = statement1.executeUpdate();
			
			if (rows >0 ) {
				System.out.println("Successful transaction");
			}
			
				connection.close();
					
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}

	}
	
	public void withdraw(String username) {
		
		String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="java";
		String pass= "java";
		
		String usernameC = username;
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
		
											
		String typeAcc = scanner.nextLine();
		
		switch (typeAcc) {
		case "1":										
			try {
			Connection connection = DriverManager.getConnection(myDB, user, pass);											
			Statement statement = connection.createStatement();
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
			
	
			System.out.println("Enter withdraw account: ");
			with = Double.parseDouble(scanner.nextLine());
			bal = Double.parseDouble(sum_ch);

			if (with>bal) {
			System.out.println("Insufficient funds");
			}else {
				double amWith=-with;
				try {	
				Connection connection = DriverManager.getConnection(myDB, user, pass);		
				
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
													
		case "2": 						
			try {												
				Connection connection = DriverManager.getConnection(myDB, user, pass);
				String sql8 = "SELECT sv_acc FROM Client WHERE username = '"+usernameC+"'";												
				Statement statement = connection.createStatement();
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

		if (with>bal) {
		System.out.println("Insufficient funds");
		}else {
			
			try {	
			Connection connection = DriverManager.getConnection(myDB, user, pass);		
			
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
		
	}
	public void transfer(String username) {
		
		String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="java";
		String pass= "java";
		
		
		System.out.println("TRANSFER");
		System.out.println(" ");
		System.out.println("1.- From saving to checking");
		System.out.println("2.- From checking to saving");
											
		String typetrans = scanner.nextLine();
		String check = null;
		String save = null;
		String usernameDB = username;
		double dep;
			try {
				System.out.println(usernameDB);
				Connection connection = DriverManager.getConnection(myDB, user, pass);
				String sqlacc = "SELECT ch_acc, sv_acc FROM Client WHERE username = '"+usernameDB+"'";
									
				Statement statement = connection.createStatement();
				ResultSet result7 = statement.executeQuery(sqlacc);
				while(result7.next()) {

					check = result7.getString("ch_acc");
					save = result7.getString("sv_acc");
	
								}	connection.close();
								}catch(SQLException ex) {
									ex.printStackTrace();
								}
			
			System.out.println("Enter deposit account: ");
			dep = Double.parseDouble(scanner.nextLine());
		switch (typetrans) {
		case "1":	
			
			try {	
			Connection connection = DriverManager.getConnection(myDB, user, pass);		
			
			String sql8 = "SELECT SUM (amount_trans) FROM transaction WHERE acc_num = '"+check+"'";
			Statement statement = connection.createStatement();
			ResultSet result8 = statement.executeQuery(sql8);
			while(result8.next()) {
				double sum = result8.getDouble(1);
		
			if (dep <= sum)	{
			String sqlcheck = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
			String sqlsave = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
			
			PreparedStatement statement1 = connection.prepareStatement(sqlcheck);
			PreparedStatement statement2 = connection.prepareStatement(sqlsave);
			statement1.setDouble(1, -dep);
			statement1.setString(2, save);
			statement2.setDouble(1, dep);
			statement2.setString(2, check);
			
			int rows = statement1.executeUpdate();
			int rows2 = statement2.executeUpdate();
			
			if (rows >0 && rows2 >0) {
				System.out.println("Successful transaction");
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
				Connection connection = DriverManager.getConnection(myDB, user, pass);				
				
				String sqlcheck = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
				String sqlsave = "INSERT INTO transaction (amount_trans, acc_num) VALUES (?,?)";
				
				PreparedStatement statement1 = connection.prepareStatement(sqlcheck);
				PreparedStatement statement2 = connection.prepareStatement(sqlsave);
				statement1.setDouble(1, dep);
				statement1.setString(2, save);
				statement2.setDouble(1, -dep);
				statement2.setString(2, check);
			
				int rows = statement1.executeUpdate();
				int rows2 = statement2.executeUpdate();
				
				if (rows >0 && rows2 >0) {
					System.out.println("Succesful transaction");
				}
				
					connection.close();
						
				}catch(SQLException ex) {
				System.out.println(ex.getMessage());
				}
		}
		
	}
	}


