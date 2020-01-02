package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Queries {
	String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
	String user="java";
	String pass= "java";
	String first_name=null, last_name = null, street = null, city = null, zip_code = null, state = null, username = null;
	Scanner scanner = new Scanner(System.in);
	
	public void approve() {
		System.out.println("APPROVE / REJECT ACCOUNT");
		try {
			Connection connection = DriverManager.getConnection(myDB, user, pass);
			String sql = "SELECT ID_CLIENT, FIRST_NAME, LAST_NAME, STREET, CITY, ZIP_CODE, STATE, USERNAME FROM Client WHERE APPLY = 'y' AND CH_ACC IS NULL";
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while(result.next()) {
				int id_client = result.getInt("ID_CLIENT");
				first_name = result.getString("first_name");
				last_name = result.getString("last_name");
				street = result.getString("street");
				city = result.getString("city");
				zip_code = result.getString("zip_code");
				state = result.getString("state");
				username = result.getString("username");
						

				System.out.println("Id Client: " + id_client);
				System.out.println("First name: " + first_name);
				System.out.println("Last name: " + last_name);
				System.out.println("Street: " + street);
				System.out.println("City: " + city);
				System.out.println("Zip Code: " + zip_code);
				System.out.println("State: " + state);
				System.out.println("Username: " + username);
				System.out.println("=================================");
				System.out.println(" ");
				
			}
			Random Num1 = new Random();
			Random Num2 = new Random();
			String ch_acc = "CH" + (Integer.toString(1 + Num1.nextInt(10000000))); 
			String sv_acc = "SV" + (Integer.toString(1 + Num2.nextInt(10000000)));
			System.out.println("Please select account that you want to approve: ");
			String appOpt = scanner.nextLine();
			
			String sql1 = "UPDATE Client SET CH_ACC = '"+ch_acc+"' WHERE username = '"+appOpt+"'";
			String sql4 = "UPDATE Client SET SV_ACC = '"+sv_acc+"' WHERE username = '"+appOpt+"'";
			
			Statement statement1 = connection.createStatement();
			int rows = statement1.executeUpdate(sql1);
			Statement statement2 = connection.createStatement();
			int rows1 = statement2.executeUpdate(sql4);
			if (rows >0 || rows1 >0) {
				System.out.println("Thank you. Information has been updated.");
									
				
			}

			
			connection.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		
	}
	public void listAccount(){
		String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="java";
		String pass= "java";
		String ch_acc = null;
		String sv_acc = null;
//		String balance_ch = null;
//		String balance_sv = null;
		int id_client = 0;
		String sum_ch = null;
		String sum_sv = null;
		System.out.println("ACCOUNTS");
		System.out.println("");
		System.out.println("Enter First name: ");
		first_name = scanner.nextLine();
		System.out.println("Enter Last name: ");
		last_name = scanner.nextLine();
		
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
		}
	public void Transactions() {
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
	}
}
