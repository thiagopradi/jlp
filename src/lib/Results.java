package lib;

import java.util.concurrent.ConcurrentHashMap;

public class Results {
	private ConcurrentHashMap<String, Integer> countriesCode = new ConcurrentHashMap<String, Integer>();
	private ConcurrentHashMap<String, Integer> countriesName = new ConcurrentHashMap<String, Integer>();
	private ConcurrentHashMap<String, Integer> browsers = new ConcurrentHashMap<String, Integer>();
	private ConcurrentHashMap<String, Integer> responseCount = new ConcurrentHashMap<String, Integer>();
	private ConcurrentHashMap<String, Integer> referers = new ConcurrentHashMap<String, Integer>();
	private ConcurrentHashMap<String, String> dns = new ConcurrentHashMap<String, String>();

	public void addBrowserCount(String browser) {
		if (browser != null) {
			Integer value = browsers.get(browser);
			if(value == null) {
				browsers.put(browser, 1);
			} else {
				browsers.put(browser, value+1);
			}
		}
	}

	public ConcurrentHashMap<String, String> getDns() {
		return dns;
	}

	public void addResponseCount(String response) {
		Integer value = responseCount.get(response);
		if(value == null) {
			responseCount.put(response, 1);
		} else {
			responseCount.put(response, value+1);
		}
	}

	public void addCountryCode(String countryCode) {
		Integer value = countriesCode.get(countryCode);
		if(value == null) {
			countriesCode.put(countryCode, 1);
		} else {
			countriesCode.put(countryCode, value+1);
		}
	}

	public void addCountryName(String countryName) {
		Integer value = countriesName.get(countryName);
		if(value == null) {
			countriesName.put(countryName, 1);
		} else {
			countriesName.put(countryName, value+1);
		}
	}
	
	public void addReferer(String referer) {
		Integer value = referers.get(referer);
		if(value == null) {
			referers.put(referer, 1);
		} else {
			referers.put(referer, value+1);
		}
	}
	
	public void AddHost(String ipAddr, String host) {
		dns.put(ipAddr, host);
	}
	
	boolean hasHost(String ipaddress) {
		return dns.containsKey(ipaddress);
	}

	public ConcurrentHashMap<String, Integer> getCountriesCode() {
		return countriesCode;
	}

	public ConcurrentHashMap<String, Integer> getCountriesName() {
		return countriesName;
	}

	public ConcurrentHashMap<String, Integer> getBrowsers() {
		return browsers;
	}

	public ConcurrentHashMap<String, Integer> getResponseCount() {
		return responseCount;
	}
	
	public ConcurrentHashMap<String, Integer> getReferers() {
		return referers;
	}
}
