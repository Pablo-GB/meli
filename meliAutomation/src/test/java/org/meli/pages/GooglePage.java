package org.meli.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage {
	
	WebDriver driver;
	
	 public GooglePage(WebDriver driver){ 
         this.driver=driver; 
 }
	@FindBy(how=How.NAME, using="q") WebElement textboxSearch;
	
	public void search(String textToSearch){
		textboxSearch.sendKeys(textToSearch);
		 }
	
	public void searchEnter(){
		textboxSearch.sendKeys(Keys.ENTER);
		 }

}
