package pslogging.internal.implementation;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;

import pslogging.internal.PSLoggingConfiguration;
import pslogging.internal.PSLoggingConnection;
import pslogging.internal.beans.Logs;
import pslogging.internal.rest.WebService;
import pslogging.internal.rest.MySQL;


public class WebServiceImplementation implements WebService {

	private String host;
	private String port;
	private String user;
	private String password;
	
	private MySQL getLogs = new MySQL(); 
//	private RestTemplate restTemplate;
//	private HttpHeaders headers;
	
	
	public WebServiceImplementation(@Connection PSLoggingConnection connection,
		@Config PSLoggingConfiguration configuration) {
		
		super();
		this.host = connection.getHost();
		this.port = connection.getPort();
		this.user = connection.getUser();
		this.password = connection.getPassword();
		
//		restTemplate = new RestTemplate();
		
	}
	
	
//	@Override
//	public logs postLogs(logs logs) throws IllegalArgumentException, IllegalStateException, NullPointerException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public Logs postLogs(Logs logs) throws IllegalArgumentException, IllegalStateException, NullPointerException {
		
		return null;
	}
	
	//Test
	@Override
	public Logs getLogs()
			throws IllegalArgumentException, IllegalStateException, NullPointerException {
		getLogs.getLogs();
		return getLogs.getLogs();
	}

	@Override
	public Logs getLogByTransaction(String transaction_id)
			throws IllegalArgumentException, IllegalStateException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Logs getLogByApp(String source)
			throws IllegalArgumentException, IllegalStateException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Logs getLog(String source, String transaction_id)
			throws IllegalArgumentException, IllegalStateException, NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

}
