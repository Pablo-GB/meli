package org.meliAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test3 {
	
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
{//algunos comentarios por aqui hacen a un nuevo comit
	WebElement textboxSearch= driver.findElement(By.name("q"));
	textboxSearch.sendKeys("talleres");
	textboxSearch.sendKeys(Keys.ENTER);
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


