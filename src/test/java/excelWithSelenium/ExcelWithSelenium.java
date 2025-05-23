package excelWithSelenium;

import org.openqa.selenium.WebDriver;

import utils.ExcelUtils;
import utils.OpenBroswer;

public class ExcelWithSelenium {
	
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		
		
		String data[][]=ExcelUtils.retSheetData(System.getProperty("user.dir")+"/src/main/resources/employee.xlsx","URLs");
		
		
		for(int i=0;i<data.length;i++)
		{
			for(int j=0;j<data[1].length;j++)
			{
				driver=OpenBroswer.openBrowser(data[i][j]);
				System.out.println(driver.getTitle());
				OpenBroswer.quitBrowser();
			}	
		}
		

		
		
		
		
		
		
		
		

	}

}
