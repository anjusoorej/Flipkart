package com.flipkart.qa.main;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class CoreEngine {
	WebDriver driver;
	ConfigurationReader conf;
	Authenication auth;
	
	public CoreEngine(){
		conf = new ConfigurationReader();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(conf.gerUrl());
	}
	//For wait
	void timeDelay(long t) {
	    try {
	        Thread.sleep(t);
	    } catch (InterruptedException e) {}
	}
	
	//Calling Authentication Method
	public void authenticateUser() {
		auth = new Authenication(driver);
		auth.login();
	}
	
	//Searching and Selecting iPhone7
	public void searchAndSelectElement(String element) {
		timeDelay(1000);
		driver.findElement(By.name("q")).sendKeys(element);
		timeDelay(500);
		//autoSelection
		driver.findElement(By.className("_2ja22P")).click();
		timeDelay(1000);
		//clicked the item and navigated to new page
		driver.findElement(By.xpath("//div[@class='_3wU53n'][1]")).click();
		timeDelay(1000);
	}
	
	//Adding the Selected Iphone7 to cart
	public void addToCart() {
		for(String handle1: driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
			}
		System.out.println(driver.getTitle());
		WebElement cart = driver.findElement(By.xpath("//button[contains(.,'ADD TO CART')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(cart);
		cart.click();
		timeDelay(1000);
	}
	
	//Taking Screenshot
	public void takeScreenShot(String fname) throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SrcFile,new File(fname));
		timeDelay(500);
	}
	
	//Removing the item from cart
	public void cleanupCart(){
		driver.findElement(By.cssSelector("#container > div > div._4dkTmQ > div > div.riAgLt > div > div:nth-child(2) > div > div._3cto0P > div._3IO2ev._2K02N8._2x63a8 > div:nth-child(2) > span")).click();
	}
	
	//Logging out user
	public void logoutUser() {
		WebElement element = driver.findElement(By.xpath("//div[@class='_2aUbKa']"));
				timeDelay(500);
				Actions action = new Actions(driver);

				action.moveToElement(element).build().perform();
				timeDelay(500);
				driver.findElement(By.xpath("//li[9]//a[1]")).click();
				timeDelay(500);
				
				
				
	}
}
