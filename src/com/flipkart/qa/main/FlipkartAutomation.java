package com.flipkart.qa.main;

import java.io.IOException;
public class FlipkartAutomation {
	/* Main 
	 * Logger 
	 * Authentication class 
	 * CoreEngine 
	 * Screenshot
	 * Remove product 
	 * Exit procedures if any.
	 */
	public static void main(String[] args) throws IOException {
			
			//Logger log = new Logger();
			//log.Info("This is my name");
			
			ConfigurationReader conf = new ConfigurationReader();
			//System.out.println(conf.getPassword());
			//System.out.println(conf.getDriverPath());
			System.setProperty("webdriver.chrome.driver",conf.getDriverPath());
			CoreEngine coreEngine = new CoreEngine();
			coreEngine.authenticateUser();
			coreEngine.searchAndSelectElement("iPhone7");
			coreEngine.addToCart();
			coreEngine.takeScreenShot("C:\\Users\\Go4Games\\Downloads\\cartShot.jpeg");
			coreEngine.cleanupCart();
			coreEngine.logoutUser();	
			//Log.printLogs("C:\\Users\\Go4Games\\Downloads\\LogFile.txt");
		
			
			
	}
}
