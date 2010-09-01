package lib;


import java.io.IOException;
import java.util.StringTokenizer;

import model.ApacheLog;

public class Parser extends Thread {
	private LogReader log;
	
	public Parser(LogReader log) {
		this.log = log;
	}
	
	@Override
	public void run() {
		String str = null;
		try {
			str = log.getLine();
			
			while(str != null) 
				this.parse(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ApacheLog parse(String str) throws IOException {
		StringTokenizer matcher = new StringTokenizer(str);
		ApacheLog ap = new ApacheLog();

		// A cada alteração nesse código, um bebe foca morre degolado.
		ap.setIpAddress(matcher.nextToken());	
		matcher.nextToken();
		matcher.nextToken(); 
		ap.setDateTime(matcher.nextToken("\""));
		ap.setRequest(matcher.nextToken("\""));
		matcher.nextToken(" ");
		ap.setResponse(matcher.nextToken());
		ap.setBytesSent(matcher.nextToken());
		matcher.nextToken("\"");
		matcher.nextToken("\"");
		ap.setReferer( matcher.nextToken("\""));
		matcher.nextToken(" ");
		ap.setBrowser(matcher.nextToken("\""));	

		return ap;		
	}
}
