package lib;

import java.util.concurrent.ConcurrentHashMap;

public class Results {
	private int brazilIps;
	private int otherCountriesIps;
	private ConcurrentHashMap<String, Integer> browsers = new ConcurrentHashMap<String, Integer>();
	private ConcurrentHashMap<String, Integer> hourCount = new ConcurrentHashMap<String, Integer>();
	
	
	public Results() {
		this.brazilIps = 0;
		this.otherCountriesIps = 0;
	}
	
	public void addBrowserCount(String browser) {
		Integer value = browsers.get(browser);
		if(value == null) {
			browsers.put(browser, 0);
		} else {
			browsers.put(browser, value+1);
		}
	}
	
	public void addHourCount(String hour) {
		Integer value = browsers.get(hour);
		if(value == null) {
			browsers.put(hour, 0);
		} else {
			browsers.put(hour, value+1);
		}
	}
	
	public void addBrazilIp() {
		brazilIps++;
	}
	
	public void addOtherCountriesIp() {
		otherCountriesIps++;
	}
	

}
