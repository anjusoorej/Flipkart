package com.flipkart.qa.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class Authenication{
	WebDriver driver;
		
	public Authenication(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() {
		ConfigurationReader conf = new ConfigurationReader();
		
		driver.findElement(By.xpath("//input[@type='text' and @class='_2zrpKA']")).sendKeys(conf.getUsername());
		driver.findElement(By.xpath("//input[@type='password' and @class='_2zrpKA _3v41xv']")).sendKeys(conf.getPassword());
		driver.findElement(By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]")).click();	
	}
}





