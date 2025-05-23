package stepDefinetion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DashBoardPage;
import pages.LoginPage;
import utils.OpenBroswer;

public class StrpDefinetion {
	WebDriver driver;
	
	@Given("User login into application")
	public void user_login_into_application() {
	    driver=OpenBroswer.openBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    LoginPage lp=new LoginPage(driver);
	    lp.login(driver, "Admin", "admin123");
	
	}

	@Given("User performs click on DB")
	public void user_performs_click_on_db() {
	    DashBoardPage db=new DashBoardPage(driver);
	    db.clickDBTab();
	}
	
	

	@Then("User navigates to Leave Page")
	public void navigateToLeavePage() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Leave']")).click();
	}
	
	
	@Then("User navigates to admin page")
	public void navigateToAdminPage() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
	}
	

	@And("User closes browser")
	public void user_closes_browser() {
	    OpenBroswer.quitBrowser();
	}
}
