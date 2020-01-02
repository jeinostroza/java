package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Signin {
	
	public void SignIn() {
		String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
		String user="java";
		String pass= "java";
		
		Scanner scanner = new Scanner(System.in);
		String first_name, last_name = null, street = null, city = null, zip_code = null, state = null, username = null, password = null;
		
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
			Connection connection = DriverManager.getConnection(myDB, user, pass);		
	
			
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
	}


