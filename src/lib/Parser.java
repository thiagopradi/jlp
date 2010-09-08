package lib;


import java.io.IOException;
import java.util.StringTokenizer;

import controller.Control;

import model.ApacheLog;

public class Parser extends Thread {
	private LogPartQueue lp;
	private Control c;

	public Parser(LogPartQueue lp, Control c) {
		this.lp = lp;
		this.c = c;
	}

	@Override
	public void run() {
		String str = null;
		try {
			str = lp.getLine();
			c.insertObject(this.parse(str));
		} catch (Exception e) {}
	}


	public ApacheLog parse(String str) throws IOException {
		StringTokenizer matcher = new StringTokenizer(str);
		ApacheLog ap = new ApacheLog();
		try {
			ap.setIpAddress(matcher.nextToken());	
			matcher.nextToken();
			matcher.nextToken(); 
			ap.setDateTime(matcher.nextToken("\""));
			ap.setRequest(matcher.nextToken("\""));
			matcher.nextToken(" ");
			ap.setResponse(matcher.nextToken());
			ap.setBytesSent(matcher.nextToken());
			matcher.nextToken("\"");
			ap.setReferer(matcher.nextToken("\""));
			matcher.nextToken("\"");
			matcher.nextToken(" ");
			ap.setBrowser(matcher.nextToken("\""));	
		} catch(Exception e) {}

		return ap;		
	}
}
