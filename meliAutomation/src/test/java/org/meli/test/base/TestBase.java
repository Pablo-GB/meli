package org.meli.test.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	public static WebDriver driver;
	String path=System.getProperty("user.dir");
	
		
	public WebDriver getURL(String url) {
		System.setProperty("webdriver.chrome.driver",path+"\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		return driver;
	}
	



}
