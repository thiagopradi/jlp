package lib;


import java.io.IOException;
import java.util.StringTokenizer;

import controller.Control;

import model.ApacheLog;

public class Parser extends Thread {
	private LogReader log;
	private Control c;
	
	public Parser(LogReader log, Control c) {
		this.log = log;
		this.c = c;
	}
	
	@Override
	public void run() {
		String str = null;
		try {
			str = log.getLine();
			
			while(str != null) 
				c.insertObject(this.parse(str));
		} catch (IOException e) {

		} catch (InterruptedException e) {

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
