package Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Primary_Classes.Client;

public class ClientDB {
	//List of client DB
	public ArrayList<Client> ListClient(){
	ArrayList<Client> Cliente=new ArrayList<Client>();
	
	try {
		Connection cnx = Connectiondb.getConnection();
		Statement st = cnx.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM CLIENT ORDER BY 2 ");
		while (rs.next()) {
			Client cl = new Client();
			cl.setID_CLIENT(rs.getInt("ID_CLIENT"));
			cl.setFIRST_NAME(rs.getString("FIRST_NAME"));
			cl.setLAST_NAME(rs.getString("LAST_NAME"));
			cl.setSTREET(rs.getString("STREET"));
			cl.setCITY(rs.getString("CITY"));
			cl.setZIP_CODE(rs.getInt("ZIP_CODE"));
			cl.setSTATE(rs.getString("STATE"));
			cl.setUSERNAME(rs.getString("USERNAME"));
			cl.setPASSWORD(rs.getString("PASSWORD"));
			
		}
	
	}catch(SQLException ex) {
		System.out.println(ex.getMessage());
		System.out.println("List error");
	}
	
	return Cliente;
	}

}
