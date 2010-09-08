package lib;

import java.net.InetAddress;
import java.net.UnknownHostException;

import controller.Control;

public class DNSResolver extends Thread {
	private IpAddressQueue ip;
	private Results rs;
	
	public DNSResolver(IpAddressQueue ip, Results rs) {
		this.ip = ip;
		this.rs = rs;
	}
	
	@Override
	public void run() {
	    InetAddress addr = null;
	    String ipAddr = ip.getIpAddress();
	    
	    if(ipAddr != null && !rs.hasHost(ipAddr)) {
	    	try { addr = InetAddress.getByName(ipAddr); } catch (Exception e) {}
	    	rs.AddHost(ipAddr, addr.getHostName());
	    }
	}
	
}
