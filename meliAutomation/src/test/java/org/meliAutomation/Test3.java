package org.meliAutomation;

import java.util.concurrent.TimeUnit;

import org.meli.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test3 {
	
	public String path=System.getProperty("user.dir");
	TestBase base = new TestBase();
	public String baseURL="http://google.com";
	
@BeforeMethod
public void setBaseURL() {
//	System.setProperty("webdriver.chrome.driver",path+"\\chromeDriver\\chromedriver.exe");
//	base.openDriver(baseURL);
//	base.driver.get(base.url);
	System.out.print("before method");
	}
	
@Test 
public void test() 
{//algunos comentarios por aqui hacen a un nuevo comit
	WebElement textboxSearch= base.driver.findElement(By.name("q"));
	textboxSearch.sendKeys("talleres");
	textboxSearch.sendKeys(Keys.ENTER);
	base.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	String currentTitle= base.driver.getTitle();
	String expectedTitle="talleres - Buscar con Google";
	Assert.assertTrue(currentTitle.equals(expectedTitle));
	
}



@AfterMethod
public void quit()
{
	base.driver.quit();
}

}


