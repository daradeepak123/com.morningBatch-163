package testNGBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.SeleniumHelpers;

public class AdminTest extends TestNGSelenium{
	
	
	
	@FindBy(xpath="//span[text()='Admin']")	WebElement adminTab;
	
	@FindBy(xpath="//h5[text()='System Users']") WebElement dbText;
	
	
	 @BeforeMethod
	  public void beforeMethod() {
		  
		  PageFactory.initElements(driver, this);
		  
		  SeleniumHelpers.clickElement(driver, adminTab);
		  
	  }
	 
	 
	 @Test
	 public void headingTest()
	 {
		
		  String text=dbText.getText();
		  Assert.assertEquals(text, "System Users");
		  
		  SoftAssert s=new SoftAssert();
		  
		  s.assertEquals("abc", "abc");
		  s.assertEquals(1, 1);
		  s.assertEquals(true, true);
		  
		  s.assertAll();
		  
		  
		 		 
	 }
	 
	 
	 @Test
	 public void tableData()
	 {
		 List<WebElement> tableData=driver.findElements(By.xpath("//div[text()='Username']/../..//div[text()]"));
		 for(WebElement e:tableData)
		 {
			 System.out.println(e.getText());
		 }
	 }
	 
	 
	 
	 @AfterMethod
	 public void afterMethod() {
		 SeleniumHelpers.clickElement(driver, adminTab);
		  
	  }

}
