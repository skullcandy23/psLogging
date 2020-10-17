package pslogging.internal.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;

import pslogging.internal.PSLoggingConnection;
import pslogging.internal.PSLoggingConnectionProvider;
import pslogging.internal.PSLoggingOperations;
import pslogging.internal.beans.Logs;

public class MySQL {

	public PSLoggingConnection psLoggingConnection;
	public PSLoggingConnectionProvider psLoggingConnectionProvider;
	public PSLoggingOperations psLoggingOperation;
	
	
	private String host;
	private String port;
	private String user;
	private String password;
	private String database;
	
	public static void main(String[] args) {
		MySQL pro = new MySQL();
//		pro.getLogs();
		pro.insertLogs();
		
	}

	//Test
//	public Logs getLogs() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logging", "root", "root");
//			
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT * FROM logs");
//			while(rs.next()) {
//				String host = rs.getString("host");
//				System.out.println(host);
//				String source = rs.getString("source");
//				System.out.println(source);
//				String event_name = rs.getString("event_name");
//				System.out.println(event_name);
//				String severity = rs.getString("severity");
//				System.out.println(severity);
//				String time = rs.getString("time");
//				System.out.println(time);
//				String transaction_id = rs.getString("transaction_id");
//				System.out.println(transaction_id);
//				String source_system = rs.getString("source_system");
//				System.out.println(source_system);
//				String target_system = rs.getString("target_system");
//				System.out.println(target_system);
//				String metas = rs.getString("metas");
//				System.out.println(metas);
//						
//			}
//			
//			
//			
//			System.out.println("Database Connection Success");
//		} catch (ClassNotFoundException ex) {
//			// TODO Auto-generated catch block
//			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (SQLException ex) {
//			// TODO Auto-generated catch block
//			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return null;
//	}
	
////	//Test
//		public Logs getLogs() {
//			try {
//				Class.forName("com.mysql.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc:mysql://"+ psLoggingConnectionProvider.getHost() + ":" + psLoggingConnectionProvider.getPort() + "/" + psLoggingConnectionProvider.getDatabase(), psLoggingConnectionProvider.getUser(), psLoggingConnectionProvider.getPassword());
//				
//				Statement stmt = con.createStatement();
//				ResultSet rs = stmt.executeQuery("SELECT * FROM logs");
//				while(rs.next()) {
//					String host = rs.getString("host");
//					System.out.println(host);
//					String source = rs.getString("source");
//					System.out.println(source);
//					String event_name = rs.getString("event_name");
//					System.out.println(event_name);
//					String severity = rs.getString("severity");
//					System.out.println(severity);
//					String time = rs.getString("time");
//					System.out.println(time);
//					String transaction_id = rs.getString("transaction_id");
//					System.out.println(transaction_id);
//					String source_system = rs.getString("source_system");
//					System.out.println(source_system);
//					String target_system = rs.getString("target_system");
//					System.out.println(target_system);
//					String metas = rs.getString("metas");
//					System.out.println(metas);
//							
//				}
//				
//				
//				
//				System.out.println("Database Connection Success");
//			} catch (ClassNotFoundException ex) {
//				// TODO Auto-generated catch block
//				Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
//			} catch (SQLException ex) {
//				// TODO Auto-generated catch block
//				Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
//			}
//			return null;
//		}
//	
	
	public Connection connect() throws SQLException {
//		Connection con = DriverManager.getConnection("jdbc:mysql://"+ psLoggingConnection.getHost() + ":" + psLoggingConnection.getPort() + "/" + psLoggingConnection.getDatabase(), psLoggingConnection.getUser(), psLoggingConnection.getPassword());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logging", "root", "root");

		
		return con;
	}
	
	
	public void insertLogs() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logging", "root", "root");
			
			Connection con = connect();
			
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			
			
			String query = "insert into logs (host, source, event_name, severity, time, transaction_id, source_system, target_system, metas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, "test");
			preparedStmt.setString(2, "app test");
			preparedStmt.setString(3, "Health Check");
			preparedStmt.setString(4, "INFO");
			preparedStmt.setDate(5, startDate);
			preparedStmt.setString(6, "ff55a400-cd3a-11a8-9a22-06be2c1ae4ar");
			preparedStmt.setString(7, "Smith");
			preparedStmt.setString(8, "DCR");
			preparedStmt.setString(9, "status : p('healthCheck.message')");
			
			preparedStmt.execute();
			
			con.close();
			
			System.out.println("Database Insert Success");
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}
		
	
	
//	public Logs insertLogs() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://"+ psLoggingConnection.getHost() + ":" + psLoggingConnection.getPort() + "/" + psLoggingConnection.getDatabase(), psLoggingConnection.getUser(), psLoggingConnection.getPassword());
//			
//			Calendar calendar = Calendar.getInstance();
//			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
//			
//			
//			String query = "insert into logs (host, source, event_name, severity, time, transaction_id, source_system, target_system, metas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
//			
//			
//			PreparedStatement preparedStmt = con.prepareStatement(query);
//			preparedStmt.setString(1, psLoggingOperation.logs.getHost());
//			preparedStmt.setString(2, psLoggingOperation.logs.getSource());
//			preparedStmt.setString(3, psLoggingOperation.logs.getEvent_name());
//			preparedStmt.setString(4, psLoggingOperation.logs.getSeverity());
//			preparedStmt.setDate(5, startDate);
//			preparedStmt.setString(6, psLoggingOperation.logs.getTransaction_id());
//			preparedStmt.setString(7, psLoggingOperation.logs.getSource_system());
//			preparedStmt.setString(8, psLoggingOperation.logs.getTarget_system());
//			preparedStmt.setString(9, psLoggingOperation.logs.getMetas());
//			
//			preparedStmt.execute();
//			
//			con.close();
//			
//			System.out.println("Database Insert Success");
//		} catch (ClassNotFoundException ex) {
//			// TODO Auto-generated catch block
//			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
//		} catch (SQLException ex) {
//			// TODO Auto-generated catch block
//			Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		return null;
//	}
	
//	public insertLog() {
//		connect()
//	}
}
