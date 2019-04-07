package org.meli.test;
import java.util.concurrent.TimeUnit;
import org.meli.pages.MeliLoginPage;
import org.meli.test.base.TestBase;
import org.meli.utilities.ReadExcel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginParameters {
public String path=System.getProperty("user.dir");
public WebDriver driver;
public String baseURL="http://mercadolibre.com";
public TestBase tb;

@BeforeMethod
public void setBaseURL() {
	tb = new TestBase();
	driver=tb.getURL(baseURL);
	}
	
@Test(dataProvider="DP1")  
public void LoginMessageTest(String usrname,String expMsg) 
{
	MeliLoginPage loginPage = PageFactory.initElements(driver, MeliLoginPage.class);
	loginPage.clikBtnArg();
	loginPage.clikIngresa();
	loginPage.SetUserTextBox(usrname);
	loginPage.clikBtnContinuar();
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	Assert.assertTrue(expMsg.contains(loginPage.getLoginMessageText()));
	
	
}
@DataProvider(name="DP1")
public Object[][] passData()
{ 
	ReadExcel excel=new ReadExcel(path+"\\excel\\testData.xlsx");
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
