package org.meli.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public  class TestBase {
	
	public String path=System.getProperty("user.dir");
	public WebDriver driver;
	public String baseURL="http://google.com";
	
	public  TestBase()
	{
		System.setProperty("webdriver.chrome.driver",path+"\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseURL);
		
	}
	
	public void quit()
	{
		driver.quit();
	}
	

}
