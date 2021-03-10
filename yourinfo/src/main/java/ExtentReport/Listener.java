package ExtentReport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


public class Listener implements ITestListener {
	ExtentReports extent = ExtentReporterNG.ExtentReportGenerator();
	ExtentTest test;
	private static ThreadLocal<ExtentTest> TL = new ThreadLocal<ExtentTest>();
	//private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		TL.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		TL.get().log(Status.PASS, "Successful");
	}

	public void onTestFailure(ITestResult result) {
		
		TL.get().fail(result.getThrowable());
		//TL.get().addScreenCaptureFromPath(getScreenShotPath(), result.getMethod().getMethodName());
		
	}


	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

	public void onTestSkipped(ITestResult result) {
		
		test.log(Status.SKIP, "Test Skipped");
		
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		
		
	}

}
