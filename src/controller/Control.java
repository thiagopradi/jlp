package controller;

import java.util.ArrayList;

import model.ApacheLog;

public class Control {
	private ArrayList<ApacheLog> apacheLog = new ArrayList<ApacheLog>();

	public ArrayList<ApacheLog> getApacheLog() {
		return apacheLog;
	}

	public void setApacheLog(ArrayList<ApacheLog> apacheLog) {
		this.apacheLog = apacheLog;
	}
	
}
