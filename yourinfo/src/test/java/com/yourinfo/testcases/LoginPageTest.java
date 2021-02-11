package com.yourinfo.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.youinfo.base.TestBase;
import com.yourinfo.ExtentReportListener.YIExtentReport;
import com.yourinfo.pages.HomePage;
import com.yourinfo.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	YIExtentReport Report;
	Logger log = Logger.getLogger(LoginPageTest.class);

	public LoginPageTest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setup() throws IOException
	{
		log.info("************* Starting Setup execution  *************");
		initialization(); 
		loginPage = new LoginPage();
		log.debug(loginPage);
	}
	@Test
	public void loginTest() throws IOException {
		log.info("************** Starting test cases execution  ***********");
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
		log.debug(loginPage);
		log.error("found error");
		log.getAdditivity();
		log.getLoggerRepository();
		log.debug("debug Start");
		log.getClass();
		
	}
	@AfterMethod
	public void teardown()
	{
		log.info("************* Ending test cases execution  **************");
		driver.quit();
	}
}
