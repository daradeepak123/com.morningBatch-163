package utils;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBroswer {
	
	static WebDriver driver;
	
	public static WebDriver openBrowser(String url)
	{
		
		String browser="chrome";
		
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("ff"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	
	
	public static void quitBrowser()
	{
		driver.quit();
	}
	
	
	
	
	
	
	

}
