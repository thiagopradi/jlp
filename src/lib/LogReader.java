package lib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogReader {
	private String fileName;
	private BufferedReader br;
	

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LogReader(String fileName) throws FileNotFoundException {
		super();
		this.fileName = fileName;
		br = new BufferedReader(new FileReader(this.fileName));		
	}
	
	public String getLine() throws IOException {
		return br.readLine();
	}
}
