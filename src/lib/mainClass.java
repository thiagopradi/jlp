package lib;

import java.io.IOException;

public class mainClass {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		LogReader log = new LogReader("/Users/tchandy/Documents/workspace/log_threads/logs.txt");
		
		for(int i =0; i < 100; i++) {
			Parser p = new Parser(log);
			p.start();
		}
	}

}
