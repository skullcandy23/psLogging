package pslogging.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;

import pslogging.internal.beans.Record;
import pslogging.internal.utils.Severity;

public class PSLoggingOperations {

	@MediaType(value = ANY, strict = false)
	public String Logger(
			@Config PSLoggingConfiguration configuration, 
			@Connection PSLoggingConnection connection,
			String host, 
			String source, 
			String eventName, 
			Severity severity, 
			String time, 
			String transactionId,
			String sourceSystem, 
			String targetSystem, 
			String metas) {
			
		String message="";
		Record record=new Record(host, source, eventName, severity, time, transactionId, sourceSystem, targetSystem, metas);
		
		if (connection.connect()) {
			if (connection.insertRecord(record)) {
				connection.disconnect();
				message=record.toString();
				System.out.println(message);
			} else {
				message="There was a problem trying to save " + record.toString();
				System.out.println(message);
			}
		} else {
			message="There was a problem trying to connect to " + connection.toString();
			System.out.println(message);
		}
		return message;
	}
}
