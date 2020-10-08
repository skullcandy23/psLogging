package pslogging.internal.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import pslogging.internal.beans.Logs;

public class MySQL {

	private String host;
	private String port;
	private String user;
	private String password;
	
	
	public static void main(String[] args) {
		MySQL pro = new MySQL();
		pro.getLogs();
	}

	//Test
	public Logs getLogs() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logging", "root", "root");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM logs");
			while(rs.next()) {
				String host = rs.getString("host");
				System.out.println(host);
				String source = rs.getString("source");
				System.out.println(source);
				String event_name = rs.getString("event_name");
				System.out.println(event_name);
				String severity = rs.getString("severity");
				System.out.println(severity);
				String time = rs.getString("time");
				System.out.println(time);
				String transaction_id = rs.getString("transaction_id");
				System.out.println(transaction_id);
				String source_system = rs.getString("source_system");
				System.out.println(source_system);
				String target_system = rs.getString("target_system");
				System.out.println(target_system);
				String metas = rs.getString("metas");
				System.out.println(metas);
						
			}
			
			
			
			System.out.println("Database Connection Success");
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	
}
