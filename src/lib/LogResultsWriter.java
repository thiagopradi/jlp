package lib;

import com.maxmind.geoip.LookupService;
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
			String dbfile = "/usr/local/share/GeoIP/GeoIP.dat";
		    LookupService cl = new LookupService(dbfile,LookupService.GEOIP_MEMORY_CACHE);

		    String code = cl.getCountry(ap.getIpAddress()).getCode();
		    String name = cl.getCountry(ap.getIpAddress()).getName();
		    cl.close();
		    
		    c.getResults().addCountryName(name);
		    c.getResults().addCountryCode(code);
		    c.getResults().addBrowserCount(ap.getBrowser());
		    c.getResults().addResponseCount(ap.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
	}
}
