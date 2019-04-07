package org.meli.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginHardCode {
	public String path=System.getProperty("user.dir");
	public WebDriver driver;
	public String baseURL="http://mercadolibre.com";
@BeforeMethod
public void setBaseURL() {
	System.setProperty("webdriver.chrome.driver",path+"\\chromeDriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get(baseURL);
	}
	
@Test(dataProvider="DP1")  
public void test(String usrname,String expMsg) 
{
	WebElement btnAR= driver.findElement(By.id("AR"));
	btnAR.click();
	WebElement btnIngresa=driver.findElement(By.xpath("//*[@id=\"nav-header-menu\"]/a[2]"));
	btnIngresa.click();
    //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//String expectedTitle="¡Hola! Ingresá tu e-mail o usuario";
	//String currentTitle=driver.getTitle();
	//Assert.assertTrue(expectedTitle.equals(currentTitle));
	WebElement userTbox=driver.findElement(By.id("user_id"));
	WebElement btnContinuar= driver.findElement(By.xpath("//*[@id=\"login_user_form\"]/div[2]/input"));
	userTbox.sendKeys(usrname);
	btnContinuar.click();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	WebElement msgError=driver.findElement(By.xpath("//*[@id=\"login_user_form\"]/div[1]/div/div/label/span/span/div/div"));
	String expectedTitle=expMsg;
	String currentTitle=msgError.getText();
	Assert.assertTrue(expectedTitle.contains(currentTitle));
	
	
}
@DataProvider(name="DP1")
public Object[][] passData()
{ 
	Object[][] data= new Object[2][2];
	data[0][0]="p@gmail.com";
	data[0][1]="Ingresaste un e-mail o usuario de Mercado Libre Costa Rica";
	data[1][0]="a@gmail.com";
	data[1][1]="Ingresaste un e-mail o usuario de Mercado Libre México";
	return data;
	}


@AfterMethod
public void quit()
{
	driver.quit();
}

}
