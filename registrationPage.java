package com.qa.noukri;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;

public class registrationPage {
	public static void timeDelay(long t) {
	    try {
	        Thread.sleep(t);
	    } catch (InterruptedException e) {}
	}

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Go4Games\\Downloads\\selenium\\chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		
		timeDelay(1000);
		
		
		//Logging in
		driver.findElement(By.xpath("//input[@type='text' and @class='_2zrpKA']")).sendKeys("9880570552");
		WebElement contButton = driver.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]"));
		WebElement password = driver.findElement(By.xpath("//input[@type='password' and @class='_2zrpKA _3v41xv']"));
		if(password.isDisplayed())
		{
			password.sendKeys("lovelinux");
			driver.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]")).click();
		}
		//Assumption: Every time username and password will be asked
		//Have to write rest of the test steps if continue button clicks
		else
		{
			contButton.click();
			//driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > div > div > div.Km0IJL.col.col-3-5 > div > form > div._1avdGP > button > span")).click();
			//button[@class='_2AkmmA _1LctnI _7UHT_c']//button[@class="_2AkmmA _1LctnI _7UHT_c"]
			//
		}
		
		timeDelay(1000);
		//Searching for iphone7 results:
		driver.findElement(By.name("q")).sendKeys("iPhone7");
		timeDelay(500);
		//autoSelection
		driver.findElement(By.className("_2ja22P")).click();
		timeDelay(1000);
		//clicked the item and navigated to new page
		driver.findElement(By.xpath("//div[@class='_3wU53n'][1]")).click();
		timeDelay(1000);
		
		//Add to cart
		//String origHandle = driver.getWindowHandle(); 
		for(String handle1: driver.getWindowHandles()) {
			driver.switchTo().window(handle1);
			
		}
		System.out.println(driver.getTitle());
		WebElement cart = driver.findElement(By.xpath("//button[contains(.,'ADD TO CART')]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(cart);
		cart.click();
		timeDelay(1000);
		
		// Taking Screen Shot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(SrcFile,new File("C:\\Users\\Go4Games\\Desktop\\screen.jpeg"));
		timeDelay(500);
		//Remove from cart
		driver.findElement(By.cssSelector("#container > div > div._4dkTmQ > div > div.riAgLt > div > div:nth-child(2) > div > div._3cto0P > div._3IO2ev._2K02N8._2x63a8 > div:nth-child(2) > span")).click();
		
		//Logout
		WebElement element = driver.findElement(By.xpath("//div[@class='_2aUbKa']"));
		timeDelay(500);
		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();
		timeDelay(500);
		driver.findElement(By.xpath("//li[9]//a[1]")).click();
		timeDelay(500);
		
		
	}

}
