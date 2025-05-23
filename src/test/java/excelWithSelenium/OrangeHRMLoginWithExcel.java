package excelWithSelenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumHelpers;
import utils.ExcelUtils;
import utils.OpenBroswer;

public class OrangeHRMLoginWithExcel {
	
	
	
	static WebDriver driver;
	
	
	public static void main(String[] args) throws Exception {

		
		String url=ExcelUtils.retCellData(System.getProperty("user.dir")+"/src/main/resources/employee.xlsx","Sheet2", 3, 1);
			
		String uname=ExcelUtils.retCellData(System.getProperty("user.dir")+"/src/main/resources/employee.xlsx","Sheet2", 0, 0);
		
		String pass=ExcelUtils.retCellData(System.getProperty("user.dir")+"/src/main/resources/employee.xlsx","Sheet2", 0, 1);
		
		
		
		driver=OpenBroswer.openBrowser(url);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		
		
		WebElement unameTB=driver.findElement(By.xpath("//input[@name='username']"));
		WebElement pwdTB=driver.findElement(By.xpath("//input[@name='password']"));
		WebElement lgnBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(lgnBtn));
		
		SeleniumHelpers.setDataTB(driver, unameTB, uname);
		SeleniumHelpers.setDataTB(driver, pwdTB, pass);
		SeleniumHelpers.clickElement(driver, lgnBtn);
		
		Thread.sleep(3000);
		
		
		OpenBroswer.quitBrowser();

	}

}
