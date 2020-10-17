package pslogging.internal.insert;

public class TEST {
	
	MySQL mysql = new MySQL();

	public static void main(String[] args) {
		TEST test = new TEST();
		
		test.testing();

	}

	private void testing() {
		mysql.insertLogs();
		
	}

}
