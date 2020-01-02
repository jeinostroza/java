package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connectiondb {
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String myDB = "jdbc:oracle:thin:@localhost:1521:xe";
			String user="java";
			String pass= "java";
			
			Connection cnx = DriverManager.getConnection(myDB, user, pass);
			
			return cnx;
					
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}catch(ClassNotFoundException ex) {
			Logger.getLogger(Connectiondb.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

}
