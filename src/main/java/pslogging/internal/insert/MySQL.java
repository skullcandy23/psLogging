package pslogging.internal.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;

import pslogging.internal.PSLoggingConnection;
//import pslogging.internal.PSLoggingConnection;
import pslogging.internal.PSLoggingConnectionProvider;
import pslogging.internal.PSLoggingOperations;
import pslogging.internal.beans.Logs;


public class MySQL {

	
	public PSLoggingConnection psLoggingConnection;
	public PSLoggingConnectionProvider psLoggingConnectionProvider;
	public PSLoggingOperations psLoggingOperation;
	
	public Logs logs;
	
	
//	public String host;
//	public String port;
//	public String user;
//	public String password;
//	public String database;
	
	public static void main(String[] args) {
		MySQL pro = new MySQL();
		pro.insertLogs();
		
	}


	
	
	public  Connection connect() throws SQLException {
//		Connection con = DriverManager.getConnection("jdbc:mysql://"+ psLoggingConnection.getHost() + ":" + psLoggingConnection.getPort() + "/" + psLoggingConnection.getDatabase(), psLoggingConnection.getUser(), psLoggingConnection.getPassword());
//		Connection con = DriverManager.getConnection("jdbc:mysql://"+ connection.getHost() + ":" + connection.getPort() + "/" + connection.getDatabase(), connection.getUser(), connection.getPassword());
		
//		System.out.print("jdbc:mysql://"+ psLoggingConnection.getHost() + ":" + psLoggingConnection.getPort() + "/" + psLoggingConnection.getDatabase() + ","  +  psLoggingConnection.getUser() + "," + psLoggingConnection.getPassword());
//		System.out.print("jdbc:mysql://"+ psLoggingConnectionProvider.getHost() + ":" + psLoggingConnectionProvider.getPort() + "/" + psLoggingConnectionProvider.getDatabase() + ","  +  psLoggingConnectionProvider.getUser() + "," + psLoggingConnectionProvider.getPassword());
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
		
//	public  Connection connectt() throws SQLException {
//		Connection con = DriverManager.getConnection("jdbc:mysql://"+ psLoggingConnection.getHost() + ":" + psLoggingConnection.getPort() + "/" + psLoggingConnection.getDatabase(), psLoggingConnection.getUser(), psLoggingConnection.getPassword());
////		Connection con = DriverManager.getConnection("jdbc:mysql://"+ psLoggingconnection.getHost() + ":" + psLoggingOperation.connection.getPort() + "/" + psLoggingOperation.connection.getDatabase(), psLoggingOperation.connection.getUser(), psLoggingOperation.connection.getPassword());
//		
////		System.out.print("jdbc:mysql://"+ psLoggingConnection.getHost() + ":" + psLoggingConnection.getPort() + "/" + psLoggingConnection.getDatabase() + ","  +  psLoggingConnection.getUser() + "," + psLoggingConnection.getPassword());
////		System.out.print("jdbc:mysql://"+ psLoggingConnectionProvider.getHost() + ":" + psLoggingConnectionProvider.getPort() + "/" + psLoggingConnectionProvider.getDatabase() + ","  +  psLoggingConnectionProvider.getUser() + "," + psLoggingConnectionProvider.getPassword());
////		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logging", "root", "root");
//
//		
//		return con;
//	}
//	
//	public void insertLogss() {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
////			Connection con = DriverManager.getConnection("jdbc:mysql://"+ psLoggingConnection.getHost() + ":" + psLoggingConnection.getPort() + "/" + psLoggingConnection.getDatabase(), psLoggingConnection.getUser(), psLoggingConnection.getPassword());
//			Connection con = connectt();
//			
//			Calendar calendar = Calendar.getInstance();
//			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
//			
//			
//			String query = "insert into logs (host, source, event_name, severity, time, transaction_id, source_system, target_system, metas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
//			
//			
//			PreparedStatement preparedStmt = con.prepareStatement(query);
//			preparedStmt.setString(1, logs.getHost());
//			preparedStmt.setString(2, logs.getSource());
//			preparedStmt.setString(3, logs.getEvent_name());
//			preparedStmt.setString(4, logs.getSeverity());
//			preparedStmt.setDate(5, startDate);
//			preparedStmt.setString(6, logs.getTransaction_id());
//			preparedStmt.setString(7, logs.getSource_system());
//			preparedStmt.setString(8, logs.getTarget_system());
//			preparedStmt.setString(9, logs.getMetas());
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
//		
//	}
	
//	public insertLog() {
//		connect()
//	}
}
