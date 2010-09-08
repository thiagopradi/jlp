package lib;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LogReader extends Thread {
	private String fileName;
	private BufferedReader br;
	private LogPartQueue lp;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public LogReader(String fileName, LogPartQueue lp ) throws IOException {
		super();
		this.fileName = fileName;
		this.lp = lp;
		br = new BufferedReader(new FileReader(this.fileName));	
		this.start();
	}
	
	@Override
	public void run() {
		String readline = null;
		try {
			while((readline = br.readLine()) != null) {
				try {
					lp.AddLine(readline);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
