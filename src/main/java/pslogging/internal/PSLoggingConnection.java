package pslogging.internal;


/**
 * This class represents an extension connection just as example (there is no real connection with anything here c:).
 */
public final class PSLoggingConnection {

 // private final String id;
  private final String host;
  private final String port;
  private final String user;
  private final String password;

/*  public PsloggingConnection(String id) {
    this.id = id;
  } */
  public PSLoggingConnection(String host, String port, String user, String password) {
	super();
	this.host = host;
	this.port = port;
	this.user = user;
	this.password = password;
  }

/*  public String getId() {
    return id;
  }*/
  
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

  public void invalidate() {
    // do something to invalidate this connection!
  }


}
