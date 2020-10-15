package pslogging.internal;

import org.mule.runtime.extension.api.annotation.Operations;
import org.mule.runtime.extension.api.annotation.connectivity.ConnectionProviders;
import org.mule.runtime.extension.api.annotation.param.Parameter;

import pslogging.internal.utils.Enviroment;

/**
 * This class represents an extension configuration, values set in this class are commonly used across multiple
 * operations since they represent something core from the extension.
 */
@Operations(PSLoggingOperations.class)
@ConnectionProviders(PSLoggingConnectionProvider.class)
public class PSLoggingConfiguration {

  @Parameter
  private Enviroment enviroment;

  public Enviroment getEnviroment() {
	  return enviroment;
  }

  public void setEnviroment(Enviroment enviroment) {
	  this.enviroment = enviroment;
  }

  
}
