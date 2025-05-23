package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.SeleniumHelpers;

public class LoginPage {
	WebDriver ldriver;
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement uName;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement pwd;
	
	@FindBy(xpath = "//button")
	WebElement lgnBTN;
	
	
	@FindBy(xpath="")
	WebElement fPasswordLink;
	
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	public void login(WebDriver driver,String unameTxt,String pwdTxt)
	{
		SeleniumHelpers.setDataTB(driver, uName, unameTxt);
		SeleniumHelpers.setDataTB(driver, pwd, pwdTxt);
		SeleniumHelpers.clickElement(driver, lgnBTN);
	}
	
	
	
	
	
	

}
