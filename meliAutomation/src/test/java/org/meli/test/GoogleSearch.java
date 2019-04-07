package org.meli.test;

import java.util.concurrent.TimeUnit;
import org.meli.pages.GooglePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleSearch {
	
	public String path=System.getProperty("user.dir");
	public WebDriver driver;
	public String baseURL="http://google.com";
	
	
@BeforeMethod
public void setBaseURL() {
	System.setProperty("webdriver.chrome.driver",path+"\\chromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(baseURL);
}
	
@Test 
public void test()
{ 
	GooglePage gp = PageFactory.initElements(driver, GooglePage.class);
	gp.search("talleres");
	gp.searchEnter();
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	String currentTitle= driver.getTitle();
	String expectedTitle="talleres - Buscar con Google";
	Assert.assertTrue(currentTitle.equals(expectedTitle));	
}
@AfterMethod
public void quit()
{
	driver.quit();
}

}


