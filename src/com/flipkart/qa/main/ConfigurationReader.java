package com.flipkart.qa.main;

import java.io.InputStream;
import java.util.Properties;

//create global variables
class ConfigurationReader {
	Properties prop;
	public ConfigurationReader() {
		prop = new Properties();
		try(InputStream inputStream = FlipkartAutomation.class.getResourceAsStream("configuration.properties")) {
			prop.load(inputStream);
	    }catch(Exception e) {
	        System.out.println("Unable to find the specified properties file");
	        e.printStackTrace();
	        return;
	    }
	}
	
	//Method to get url from property file
	public String gerUrl() {
		return prop.getProperty("url");
	}
	
	//Method to get url from property file
	public String getDriverPath() {
		return prop.getProperty("chromeDriverPath");
	}
	
	//Method to get url from property file
	public String getUsername(){
		return prop.getProperty("USER");
	}
	
	//Method to get url from property file
	public String getPassword(){
		return prop.getProperty("PASS");
	}
			
}