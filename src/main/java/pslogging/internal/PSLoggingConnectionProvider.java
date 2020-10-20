package pslogging.internal;

import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PSLoggingConnectionProvider implements PoolingConnectionProvider<PSLoggingConnection> {

	private final Logger logger = LoggerFactory.getLogger(PSLoggingConnectionProvider.class);
	

	@DisplayName("MySQL Host")
	@Parameter
	private String host;

	@DisplayName("MySQL Port")
	@Parameter
	private String port;

	@DisplayName("MySQL Username")
	@Parameter
	private String user;

	@DisplayName("MySQL Password")
	@Parameter
	private String password;

	@DisplayName("MySQL Database Name")
	@Parameter
	private String database;
	
	
	@Override
	public PSLoggingConnection connect(){
		return new PSLoggingConnection(host, port, user, password, database);
	}
	

	@Override
	public void disconnect(PSLoggingConnection connection) {
		
	}

	@Override
	public ConnectionValidationResult validate(PSLoggingConnection connection) {
		return ConnectionValidationResult.success();
	}

}
