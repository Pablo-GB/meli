package org.meli.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MeliLoginPage {

	 WebDriver driver;
	 
	 public MeliLoginPage(WebDriver d1) {
	 
		 this.driver=d1;
	 }

   @FindBy(how=How.ID, using="AR") WebElement btnArg;
   @FindBy(how=How.XPATH, using="//*[@id=\"nav-header-menu\"]/a[2]") WebElement btnIngresa;
   @FindBy(how=How.ID, using="user_id") WebElement userTbox;
   @FindBy(how=How.XPATH, using="//*[@id=\"login_user_form\"]/div[2]/input") WebElement btnContinuar;
   @FindBy(how=How.XPATH, using="//*[@id=\"login_user_form\"]/div[1]/div/div/label/span/span/div/div") WebElement msgError;

   public String getLoginMessageText() {
	   String currentTitle=msgError.getText();
	   return currentTitle;
   }
 
	  
   public void clikBtnArg() {
	   
	   btnArg.click();
   }
	
   public void clikIngresa() {
	   
	 btnIngresa.click();
   }
 
 
   public void SetUserTextBox(String text) {
	   
		userTbox.sendKeys(text);;
   }

   public void clikBtnContinuar() {
		   
		btnContinuar.click();
   }
	 
}
