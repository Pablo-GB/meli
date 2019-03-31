package org.meliAutomation;
import java.util.concurrent.TimeUnit;

import org.meliReadExcelLib.ReadExcelConfig;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class Test2 {
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
	WebElement btnARG= driver.findElement(By.id("AR"));
	btnARG.click();
	WebElement btnIngresa=driver.findElement(By.xpath("//*[@id=\"nav-header-menu\"]/a[2]"));
	btnIngresa.click();
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
	ReadExcelConfig excel=new ReadExcelConfig(path+"\\excel\\testData.xlsx");
	int rows=excel.getSheetRowNumber(0);
	
	Object[][] data= new Object[rows][2];
	
	for (int i=0;i<rows;i++)
	{
		data[i][0]= excel.getData(0, i, 0);
		data[i][1]= excel.getData(0, i, 1);
	}
	return data;
	}


@AfterMethod
public void quit()
{
	driver.quit();
}

}
