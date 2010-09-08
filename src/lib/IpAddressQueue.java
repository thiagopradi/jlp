package lib;

import java.util.concurrent.Semaphore;

import model.ApacheLog;

public class IpAddressQueue {
	private int size = 10;
	private String[] ipAddressQueue = new String[size];
	private int begin;
	private int end;
	private int qtd;
	private Semaphore sem = new Semaphore(size);
	
	
	public IpAddressQueue() {
		begin = end = 0;
		this.qtd = 0;
	}
	
	public void AddIpAddress(String ipAddress) {
		try { sem.acquire(); } catch (Exception e) {}
		ipAddressQueue[end] = ipAddress;
		end = (end + 1) % size;
		qtd++;
	}
	
	public String getIpAddress() {
		String ip = ipAddressQueue[begin];
		begin = (begin + 1) % size;
		qtd--;
		sem.release();
		
		return ip;
	}
	
	
}
