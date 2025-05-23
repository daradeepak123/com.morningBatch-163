package lisnters;


import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Calendar;

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
        test.get().fail(result.getThrowable());
    }

    
    public void onTestSkipped(ITestResult result) {
        test.get().skip("Test Skipped");
    }

    
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}

