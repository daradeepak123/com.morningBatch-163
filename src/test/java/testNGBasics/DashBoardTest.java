package testNGBasics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.DashBoardPage;
import utils.SeleniumHelpers;

public class DashBoardTest extends TestNGSelenium{
	DashBoardPage db;
	 @BeforeMethod
	  public void beforeMethod() {
		 db=new DashBoardPage(driver);
		 db.clickDBTab();
		  
//		  WebElement dbPage=driver.findElement(By.xpath("//span[text()='Dashboard']"));
//		  SeleniumHelpers.clickElement(driver, dbPage);
//		  
	  }
	  
	  @Test
	  public void dbPageTextValidation() {
		  WebElement dbText=driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		  String text=dbText.getText();
		  System.out.println(text);
		 
	  }
	  
	  @Test
	  public void assignLeaveButton() throws InterruptedException {
		  WebElement assignLeave=driver.findElement(By.xpath("//button[@title='Assign Leave']"));
		  SeleniumHelpers.clickElement(driver, assignLeave);
		  Thread.sleep(4000);
	  }
	  
	  @Test
	  public void retRiveButtonTexts() {
		  List<WebElement> texts=driver.findElements(By.xpath("//p[text()='Assign Leave']/../../..//p"));
		  for(WebElement ele:texts)
		  {
			  System.out.println(ele.getText());		  
		  }
	  }
	  
	  @Test
	  public void seleniumTest() {
	  }

	  @AfterMethod
	  public void afterMethod() {
		  
		  WebElement dbPage=driver.findElement(By.xpath("//span[text()='Dashboard']"));
		  SeleniumHelpers.clickElement(driver, dbPage);
	  }

}
