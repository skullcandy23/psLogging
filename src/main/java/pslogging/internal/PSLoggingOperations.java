package pslogging.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;

import pslogging.internal.beans.Logs;
import pslogging.internal.implementation.WebServiceImplementation;

/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class PSLoggingOperations {

	
  private WebServiceImplementation wsi;
  
  
  @MediaType(value = ANY, strict = false)
  public Logs getLogs() {
	return wsi.getLogs();
	  
  }
  
  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
  @MediaType(value = ANY, strict = false)
  public String retrieveInfo(@Config PSLoggingConfiguration configuration, @Connection PSLoggingConnection connection){
    return "Using Configuration [" + configuration.getConfigId() + "] with Connection Host [" + connection.getHost() + "]";
  }

  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
//  @MediaType(value = ANY, strict = false)
//  public String sayHi(String person) {
//    return buildHelloMessage(person);
//  }

  /**
   * Private Methods are not exposed as operations
   */
//  private String buildHelloMessage(String person) {
//    return "Hello " + person + "!!!";
//  }
  
  	@MediaType(value = ANY, strict = false)
  	public String log(int id, String host, String source, String event_name, String severity, String time, String transaction_id, String source_system, String target_system, String metas) {
  		return buildLogMessage(id, host, source, event_name, severity, 
  			time, transaction_id, source_system, target_system, metas);
  	}
  
  	private String buildLogMessage(int id, String host, String source, String event_name, String severity, 
  			String time, String transaction_id, String source_system, String target_system, String metas) {
  		return "ID: " + id + " Host: " + host + " Source: " + source + " Event Name: " +  event_name 
  				+ " Severity: " + severity + " Time: " + time + " Transactiond Id: " + transaction_id + 
  				" Source System: " + source_system + " Target System: " + target_system + " Metas: " + metas;
  	}
  
  	
}
