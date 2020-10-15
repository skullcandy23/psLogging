package pslogging.internal;


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
