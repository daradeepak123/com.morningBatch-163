package testNGBasics;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.LoginPage;
import utils.OpenBroswer;
import utils.SeleniumHelpers;

import org.testng.annotations.BeforeClass;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGSelenium {

	public static WebDriver driver;
	public static File file;
	public static FileInputStream fis;
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;

	



	@BeforeSuite
	public void beforeSuite() throws Exception {
		long l=Calendar.getInstance().getTimeInMillis();
		System.out.println(l);
		file=new File(System.getProperty("user.dir")+"/src/main/resources/employee.xlsx");
		fis=new FileInputStream(file);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet("Sheet2");
		
		
		

	}

	@BeforeTest
	public void beforeTest() {
		
	}


	@BeforeClass
	public void beforeClass() {
		driver=OpenBroswer.openBrowser(sheet.getRow(3).getCell(1).toString());

		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));



//		WebElement unameTB=driver.findElement(By.xpath("//input[@name='username']"));
//		WebElement pwdTB=driver.findElement(By.xpath("//input[@name='password']"));
//		WebElement lgnBtn=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
//
//
//
//
//		wait.until(ExpectedConditions.elementToBeClickable(lgnBtn));
//
//		SeleniumHelpers.setDataTB(driver, unameTB, sheet.getRow(0).getCell(0).toString());
//		SeleniumHelpers.setDataTB(driver, pwdTB, sheet.getRow(0).getCell(1).toString());
//		SeleniumHelpers.clickElement(driver, lgnBtn);
		
		
		LoginPage lp=new LoginPage(driver);
		lp.login(driver, sheet.getRow(0).getCell(0).toString(), sheet.getRow(0).getCell(1).toString());

	}



	@AfterClass
	public void afterClass() {

		System.out.println("logout");
		OpenBroswer.quitBrowser();
	}


	@AfterTest
	public void afterTest() {


	}




	@AfterSuite
	public void afterSuite() throws Exception {

	
		wb.close();

	}

}
