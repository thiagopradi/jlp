package lib;

import java.io.IOException;

import javax.swing.text.html.HTMLDocument.Iterator;

import controller.Control;

public class mainClass {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		LogReader log = new LogReader("/Users/tchandy/Documents/workspace/log_threads/logs.txt");
		Control c = new Control();
		
		for(int i =0; i < 100; i++) {
			Parser p = new Parser(log, c);
			p.start();
			LogResultsWriter lo = new LogResultsWriter(c);
			lo.start();
			
			p.join();
			lo.join();
		}
		
		System.out.println(c.getResults().getBrowsers());
		System.out.println(c.getResults().getCountriesCode());
		System.out.println(c.getResults().getCountriesName());
		System.out.println(c.getResults().getResponseCount());
	}

}
