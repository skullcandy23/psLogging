package pslogging.internal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import pslogging.internal.insert.MySQL;

/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class PSLoggingConnection {

// //MySQL
//  private final String host_mysql;
//  private final String port_mysql;
//  private final String user_mysql;
//  private final String password_mysql;
//  private final String database_mysql;
//  
//  //Mongo
//  private final String host_mongo;
//  private final String port_mongo;
//  private final String user_mongo;
//  private final String password_mongo;
//  private final String collection_mongo;
//
///*  public PsloggingConnection(String id) {
//    this.id = id;
//  } */
//  public PSLoggingConnection(String host_mysql, String port_mysql, String user_mysql, String password_mysql, String database_mysql,
//		  String host_mongo, String port_mongo, String user_mongo, String password_mongo, String collection_mongo) {
//	super();
//	this.host_mysql = host_mysql;
//	this.port_mysql = port_mysql;
//	this.user_mysql = user_mysql;
//	this.password_mysql = password_mysql;
//	this.database_mysql = database_mysql;
//	this.host_mongo = host_mongo;
//	this.port_mongo = port_mongo;
//	this.user_mongo = user_mongo;
//	this.password_mongo = password_mongo;
//	this.collection_mongo = collection_mongo;
//  }

/*  public String getId() {
    return id;
  }*/
  
	 private final String host;
	 private final String port;
	 private final String user;
	 private final String password;
	 private final String database;
	  

	/*  public PsloggingConnection(String id) {
	    this.id = id;
	  } */
	  public PSLoggingConnection(String host, String port, String user, String password, String database) {
		super();
		this.host = host;
		this.port = port;
		this.user = user;
		this.password = password;
		this.database = database;
		
	  }

	  public  Connection connect(String host, String port, String user, String password, String database) throws SQLException {
//			Connection con = DriverManager.getConnection("jdbc:mysql://"+ psLoggingConnection.getHost() + ":" + psLoggingConnection.getPort() + "/" + psLoggingConnection.getDatabase(), psLoggingConnection.getUser(), psLoggingConnection.getPassword());
//			Connection con = DriverManager.getConnection("jdbc:mysql://"+ connection.getHost() + ":" + connection.getPort() + "/" + connection.getDatabase(), connection.getUser(), connection.getPassword());
			
//			System.out.print("jdbc:mysql://"+ psLoggingConnection.getHost() + ":" + psLoggingConnection.getPort() + "/" + psLoggingConnection.getDatabase() + ","  +  psLoggingConnection.getUser() + "," + psLoggingConnection.getPassword());
//			System.out.print("jdbc:mysql://"+ psLoggingConnectionProvider.getHost() + ":" + psLoggingConnectionProvider.getPort() + "/" + psLoggingConnectionProvider.getDatabase() + ","  +  psLoggingConnectionProvider.getUser() + "," + psLoggingConnectionProvider.getPassword());
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logging", "root", "root");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://"+ host + ":" + port + "/" + database, user, password);
			
			return con;
		}
	  
		public void insertLogs(String host, String port, String user, String password, String database,
				String databaseHost, String source, String eventName, String severity, String time, String transactionId, String sourceSystem, String targetSystem, String metas) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
//				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logging", "root", "root");
				
				Connection con = connect(host, port, user, password, database);
				
				Calendar calendar = Calendar.getInstance();
				java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
				
				
				String query = "insert into logs (host, source, event_name, severity, time, transaction_id, source_system, target_system, metas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
				
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
				preparedStmt.setString(1, databaseHost);
				preparedStmt.setString(2, source);
				preparedStmt.setString(3, eventName);
				preparedStmt.setString(4, severity);
				preparedStmt.setDate(5, startDate);
				preparedStmt.setString(6, transactionId);
				preparedStmt.setString(7, sourceSystem);
				preparedStmt.setString(8, targetSystem);
				preparedStmt.setString(9, metas);
				
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
	  
	  
	  public void invalidate() {
	    // do something to invalidate this connection!
	  }


	public String getHost() {
		return host;
	}
	
	
	public String getPort() {
		return port;
	}
	
	
	public String getUser() {
		return user;
	}
	
	
	public String getPassword() {
		return password;
	}
	
	
	public String getDatabase() {
		return database;
	}

  


}
