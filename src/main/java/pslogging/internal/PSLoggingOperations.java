package pslogging.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;

//import pslogging.internal.beans.Logs;
import pslogging.internal.beans.*;
import pslogging.internal.insert.MySQL;



/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class PSLoggingOperations {

  public Logs logs;
  
//  public PSLoggingConnection connection;

  MySQL my = new MySQL();
  



/**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
//  @MediaType(value = ANY, strict = false)
//  public String retrieveInfo(@Config PSLoggingConfiguration configuration, @Connection PSLoggingConnection connection){
//    return "Using Configuration [" + configuration.getEnviroment() + "] with Connection Host [" + connection.getHost() + "]";
//  }


  		//Log de manera estatica
//  	@MediaType(value = ANY, strict = false)
//  	public String log(@Config PSLoggingConfiguration configuration, @Connection PSLoggingConnection connection, Logs logs) {
//  		my.insertLogs();
//  		return "ID: " + logs.getId() + " Host: " + logs.getHost() + " Source: " + logs.getSource() + " Event Name: " +  logs.getEvent_name() 
//  				+ " Severity: " + logs.getSeverity() + " Time: " + logs.getTime() + " Transactiond Id: " + logs.getTransaction_id() + 
//  				" Source System: " + logs.getSource_system() + " Target System: " + logs.getTarget_system() + " Metas: " + logs.getMetas(); 
//  	}
//  
  		//Log por el usuario instanciando métodos
//  	@MediaType(value = ANY, strict = false)
//  	public String logg(@Config PSLoggingConfiguration configuration, @Connection PSLoggingConnection connection, Logs logs) {
//  		my.insertLogss();
//  		return "ID: " + logs.getId() + " Host: " + logs.getHost() + " Source: " + logs.getSource() + " Event Name: " +  logs.getEvent_name() 
//  				+ " Severity: " + logs.getSeverity() + " Time: " + logs.getTime() + " Transactiond Id: " + logs.getTransaction_id() + 
//  				" Source System: " + logs.getSource_system() + " Target System: " + logs.getTarget_system() + " Metas: " + logs.getMetas(); 
//  	}
  	
  	//Log por usuario sin instancia de métodos
  	@MediaType(value = ANY, strict = false)
  	public String logging(@Config PSLoggingConfiguration configuration, @Connection PSLoggingConnection connection, 
  			String host, String source, String eventName, String severity, String time, String transactionId, String sourceSystem, String targetSystem, String metas) {
  		
  		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://"+ connection.getHost() + ":" + connection.getPort() + "/" + connection.getDatabase(), connection.getUser(), connection.getPassword());
			
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			
			
			String query = "insert into logs (host, source, event_name, severity, time, transaction_id, source_system, target_system, metas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
			
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			preparedStmt.setString(1, host);
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
  		return buildLogMessage(host, source, eventName, severity, 
  			time, transactionId, sourceSystem, targetSystem, metas);
  	}
  
  	private String buildLogMessage(String host, String source, String eventName, String severity, 
  			String time, String transactionId, String sourceSystem, String targetSystem, String metas) {
  		return " Host: " + host + " Source: " + source + " Event Name: " +  eventName 
  				+ " Severity: " + severity + " Time: " + time + " Transactiond Id: " + transactionId + 
  				" Source System: " + sourceSystem + " Target System: " + targetSystem + " Metas: " + metas;
  	}
  
  	
}
