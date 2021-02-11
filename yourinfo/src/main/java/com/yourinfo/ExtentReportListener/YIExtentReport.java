package com.yourinfo.ExtentReportListener;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.youinfo.base.TestBase;

@SuppressWarnings("deprecation")
public class YIExtentReport extends TestBase {
	
	public YIExtentReport() throws IOException {
		super();
		
	}

	ExtentReports extent;

	@SuppressWarnings({ "deprecation", "deprecation" })
	@BeforeTest
	public void config()
	{
		ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\Priyank"
				+ "\\eclipse-workspace"
				+ "\\yourinfo\\Report/YI_Report.html");
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Result");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Priyank Pathak");

	}

	@Test
	public void InitialDemo()
	{
		extent.createTest("InitialDemo");
		System.setProperty("webdriver.chrome.driver", "D:\\Naveen\\Software\\Driver"
				+ "\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://172.16.1.43/yourInfo/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on Role Drop-down
		driver.findElement(By.xpath("//select[@ng-model='loginCtrl.selectedRole']")).click();
		// Select Role
		driver.findElement(By.xpath("//option[@label='PL']")).click();
		// enter user name
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("dld1");
		// Enter Password
		driver.findElement(By.xpath("//input[@name='userPassword']")).sendKeys("123");
		// Click on Login Button
		driver.findElement(By.xpath("//"
				+ "button[@class='signIn btn btn-primary ng-binding']")).click();
		extent.flush();

	}
}
