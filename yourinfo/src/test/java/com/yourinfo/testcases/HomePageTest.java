package com.yourinfo.testcases;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.youinfo.base.TestBase;
import com.yourinfo.pages.HomePage;
import com.yourinfo.pages.LoginPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;

	public HomePageTest() throws IOException {
		super();

	}
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority =9)
	public void Versionnumber()
	{
		homePage.AppVersionNumber();
	}
	@Test(priority =2) 
	public void UserName()
	{
		homePage.LoggedUserName();
	}
	@Test(priority =3) 
	public void GeneralSearch()
	{
		homePage.ClickGeneralSearch();
	}
	@Test(priority =4) 
	public void ClickOnTools() throws Exception
	{
		Thread.sleep(2000);
		homePage.ClickTools();
	}
	@Test(priority =5)
	public void clickonSpec() throws IOException
	{
		homePage.ClickspecializedTools();
	}
	@Test(priority =6)
	public void clickonValuation() throws IOException
	{
		homePage.ClickValuation();
	}
	@Test(priority =7)
	public void clickonRental() throws IOException
	{
		homePage.ClickRental();
	}
	@Test(priority =8)
	public void clickReport() throws IOException
	{
		homePage.ClickReport();
	}

	
	  @Test(priority =1) 
	  public void clickonAdmin() throws InterruptedException,
	  IOException { Thread.sleep(4000); homePage.clickOnAdmin(); }
	 
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
