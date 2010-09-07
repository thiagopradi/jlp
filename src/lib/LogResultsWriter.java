package lib;

import java.io.IOException;

import model.ApacheLog;

import controller.Control;

public class LogResultsWriter extends Thread {
	private Control c;
	
	public LogResultsWriter(Control c) {
		this.c = c;
	}
	
	@Override
	public void run() {
		ApacheLog ap = null;
		try {
			ap = c.getObject();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
