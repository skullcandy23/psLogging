package pslogging.internal.beans;

public class Logs {

	private int id;
	private String host;
	private String source;
	private String event_name;
	private String severity;
	private String time;
	private String transaction_id;
	private String source_system;
	private String target_system;
	private String metas;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getHost() {
		return host;
	}
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	public String getSource_system() {
		return source_system;
	}
	public void setSource_system(String source_system) {
		this.source_system = source_system;
	}
	public String getTarget_system() {
		return target_system;
	}
	public void setTarget_system(String target_system) {
		this.target_system = target_system;
	}
	public String getMetas() {
		return metas;
	}
	public void setMetas(String metas) {
		this.metas = metas;
	}
	
	
}
