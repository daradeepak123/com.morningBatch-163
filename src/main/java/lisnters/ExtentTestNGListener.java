package lisnters;


import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import utils.OpenBroswer;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentTestNGListener implements ITestListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();

    
    public void onStart(ITestContext context) {
    	long l=Calendar.getInstance().getTimeInMillis();
        ExtentSparkReporter spark = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReportNew"+l+".html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    
    public void onTestFailure(ITestResult result) {
    	File screenshot = ((TakesScreenshot) OpenBroswer.driver).getScreenshotAs(OutputType.FILE);

        File destination = new File("screenshot.png");

        // Copy screenshot to desired location using Java NIO
        try {
			Files.copy(screenshot, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        test.get().fail(result.getThrowable());
    }

    
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

