package ExtentReport;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.youinfo.base.TestBase;

public class ExtentReportDemo extends TestBase {
	
	public ExtentReportDemo() throws IOException {
		super();
		
	}
	WebDriver driver;
	ExtentReports extent;
	@Test
	public void initialDemo()
	{
		extent = new ExtentReports();
		extent.createTest("InitialDemo");
		String path = System.getProperty("user.dir")+"\\Report\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		driver=initialization();
		driver.get("http://172.16.1.43/yourInfo/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//select[@ng-model='loginCtrl.selectedRole']")).click();
		driver.findElement(By.xpath("//option[@label='PL']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("dld1");
		driver.findElement(By.xpath("//input[@name='userPassword']")).sendKeys("123");
		driver.findElement(By.xpath("//button[@class='signIn btn btn-primary ng-binding']")).click();
		extent.flush();
	}

}
