package lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import model.ApacheLog;
import model.LogPart;

public class Parser {
	private LogPart logPart;
	String logEntryPattern ="";// "^([\d.]+) (\S+) (\S+) \[([\w:/]+\s[+\-]\d{4})\] "(.+?)\" (\d{3}) (\d+) \"([^\"]+)" "([^\"]+)";
	private Pattern p = Pattern.compile(logEntryPattern);
	
	public LogPart getLogPart() {
		return logPart;
	}


	public void setLogPart(LogPart logPart) {
		this.logPart = logPart;
	}
	
	public Parser(LogPart logPart) {
		super();
		this.logPart = logPart;
	}


	public Parser() {
		// TODO Auto-generated constructor stub
	}


	public List<ApacheLog> parse() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("/Users/tchandy/Documents/workspace/log_threads/logs.txt"));		
		ArrayList<ApacheLog> arr = new ArrayList<ApacheLog>();
		
		String str;
        while((str = br.readLine()) != null){
        	Matcher matcher = p.matcher(str);

    		if (!matcher.matches()) {
    			System.err.println("Bad log entry (or problem with regex?):");
    			System.err.println(str);
    			return null;
    		}
    		
    		ApacheLog ap = new ApacheLog();
    		ap.setIpAddress(matcher.group(1));	
    		ap.setDateTime(matcher.group(4));
    		ap.setRequest(matcher.group(5));
    		ap.setResponse(matcher.group(6));
    		ap.setBytesSent(matcher.group(7));
    		ap.setReferer(matcher.group(8));
    		ap.setBrowser(matcher.group(9));
    		
    		arr.add(ap);
        }
       
        br.close();
		
		return arr;
	}
}
