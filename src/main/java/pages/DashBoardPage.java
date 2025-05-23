package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelpers;

public class DashBoardPage {
	WebDriver ldriver;

	public DashBoardPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//span[text()='Dashboard']")
	WebElement dbTab;
	
	
	public void clickDBTab()
	{
		SeleniumHelpers.clickElement(ldriver, dbTab);
	}
	
	
	
	
}
