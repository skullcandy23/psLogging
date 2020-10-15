package pslogging.internal;

import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.extension.api.annotation.param.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.api.connection.ConnectionValidationResult;
import org.mule.runtime.api.connection.PoolingConnectionProvider;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.CachedConnectionProvider;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class (as it's name implies) provides connection instances and the funcionality to disconnect and validate those
 * connections.
 * <p>
 * All connection related parameters (values required in order to create a connection) must be
 * declared in the connection providers.
 * <p>
 * This particular example is a {@link PoolingConnectionProvider} which declares that connections resolved by this provider
 * will be pooled and reused. There are other implementations like {@link CachedConnectionProvider} which lazily creates and
 * caches connections or simply {@link ConnectionProvider} if you want a new connection each time something requires one.
 */
public class PSLoggingConnectionProvider implements PoolingConnectionProvider<PSLoggingConnection> {

  private final Logger LOGGER = LoggerFactory.getLogger(PSLoggingConnectionProvider.class);

 /**
  * A parameter that is always required to be configured.
  */
//  @Parameter
//  private String requiredParameter;

 /**
  * A parameter that is not required to be configured by the user.
  */
//  @DisplayName("Friendly Name")
//  @Parameter
//  @Optional(defaultValue = "100")
//  private int optionalParameter;

  
//  @Override
//  public PsloggingConnection connect() throws ConnectionException {
//    return new PsloggingConnection(requiredParameter + ":" + optionalParameter);
//  }
//
//  @Override
//  public void disconnect(PsloggingConnection connection) {
//    try {
//      connection.invalidate();
//    } catch (Exception e) {
//      LOGGER.error("Error while disconnecting [" + connection.getId() + "]: " + e.getMessage(), e);
//    }
//  }

  @DisplayName("Service Host")
  @Parameter
  private String host;
  
  @DisplayName("Service Port")
  @Parameter
  private String port;
  
  @DisplayName("Username")
  @Parameter
  private String user;
  
  @DisplayName("Password")
  @Parameter
  private String password;
  
  @DisplayName("Database")
  @Parameter
  private String database;
  
  
//  @DisplayName("Service Host")
//  @Parameter
//  private String host_mysql;
//  
//  @DisplayName("Service Port")
//  @Parameter
//  private String port_mysql;
//  
//  @DisplayName("Username")
//  @Parameter
//  private String user_mysql;
//  
//  @DisplayName("Password")
//  @Parameter
//  private String password_mysql;
//  
//  @DisplayName("Database")
//  @Parameter
//  private String database_mysql;
  
//  @DisplayName("Service Host")
//  @Parameter
//  private String host_mongo;
//  
//  @DisplayName("Service Port")
//  @Parameter
//  private String port_mongo;
//  
//  @DisplayName("Username")
//  @Parameter
//  private String user_mongo;
//  
//  @DisplayName("Password")
//  @Parameter
//  private String password_mongo;
//  
//  @DisplayName("Database")
//  @Parameter
//  private String collection_mongo;
  
//  @Override
//  public PSLoggingConnection connect() throws ConnectionException {
//	  return new PSLoggingConnection(host_mysql, port_mysql, user_mysql, password_mysql, database_mysql, host_mongo, port_mongo, user_mongo, password_mongo, collection_mongo);
//  }
  
  public String getHost() {
	return host;
  }

	public void setHost(String host) {
		this.host = host;
	}
	
	public String getPort() {
		return port;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDatabase() {
		return database;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
	public Logger getLOGGER() {
		return LOGGER;
	}

  @Override
  public PSLoggingConnection connect() throws ConnectionException {
	  return new PSLoggingConnection(host, port, user, password, database);
  }
  
  @Override
  public void disconnect(PSLoggingConnection psLoggingConnection) {
	  try {
		  psLoggingConnection.invalidate();
	  } catch (Exception e) {
		  LOGGER.error("Error while disconnecting [ host: " +  psLoggingConnection.getHost() + " port: " + psLoggingConnection.getPort() + " user: " + psLoggingConnection.getUser());
	  }
  }
  
  
  @Override
  public ConnectionValidationResult validate(PSLoggingConnection connection) {
    return ConnectionValidationResult.success();
  }
}
