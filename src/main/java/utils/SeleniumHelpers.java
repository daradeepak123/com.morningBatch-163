package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumHelpers {
	
	
	
	public static void clickElement(WebDriver driver,WebElement ele)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		boolean flag=ele.isDisplayed();
		flag&=ele.isEnabled();
		if(flag)
		{
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
		}
		else
		{
			System.out.println("Webelement is not able to click due to visibility/enabled");
		}
			
	}
	
	
	public static void setDataTB(WebDriver driver,WebElement ele,String data)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		boolean flag=ele.isDisplayed();
		flag&=ele.isEnabled();
		if(flag)
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			ele.clear();
			ele.sendKeys(data);
		}
		else
		{
			System.out.println("Webelement is not able to click due to visibility/enabled");
		}
			
	}
	
	
	

}
