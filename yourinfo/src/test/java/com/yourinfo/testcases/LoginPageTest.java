package com.yourinfo.testcases;

import java.io.IOException;

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

	public LoginPageTest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization(); 
		loginPage = new LoginPage();
		
	}
	@Test
	public void loginTest() throws IOException {
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
