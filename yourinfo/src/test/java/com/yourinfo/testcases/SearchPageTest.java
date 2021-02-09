package com.yourinfo.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.yourinfo.util.TestUtil;
import com.youinfo.base.TestBase;
import com.yourinfo.pages.HomePage;
import com.yourinfo.pages.LoginPage;
import com.yourinfo.pages.SearchPage;

public class SearchPageTest extends TestBase 
    {
	LoginPage loginPage;
	HomePage homePage;
	SearchPage serPage;
	public SearchPageTest() throws IOException 
	{
		super();
	}
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		serPage = new SearchPage();
		loginPage = new LoginPage();
		homePage = loginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority =4)
	public void clickonGenSearch()
	{
		homePage.ClickGeneralSearch();
	}
	@Test(priority =3)
	public void GensearchByBuilding () throws InterruptedException
	{
		 serPage.SearchByBuilding("palm");
	}
	@Test(priority=2)
	public void BuildingDorpdown() throws InterruptedException
	{
		serPage.SearchByBuilding("Palm");
		serPage.clickonBuildingDropdown();
	}
	@DataProvider
	public Object[][] getYourInfoTestdata() throws InvalidFormatException, IOException
	{
		Object data[][]= TestUtil.getTestData("CommunityName");
		return data;
	}
	@Test(priority=9,dataProvider="getYourInfoTestdata")
	public void AssertBuildName(String CommName) throws InterruptedException
	{
		serPage.SearchByBuilding(CommName);
		//serPage.clickonBuildingDropdown();
		//serPage.AssertBuildingNameinDetails();
	}
	@Test(priority =5)
	public void clickonAdvSeachbyOwner()
	{
		serPage.clickonOwnerSearch();
	}
	@Test(priority =6)
	public void clickonSearchByDeveloper()
	{
		serPage.clickonDeveloperSearch();
	}
	@Test(priority =7)
	public void clickonProject()
	{
		serPage.clickonProjectSearch();
	}
	@Test(priority =8)
	public void clickonMajorProject()
	{
		serPage.clickonMajorProjectSearch();
	}
	@Test(priority =1)
	public void cickonLandMark() throws InterruptedException
	{
		serPage.clickonMajorProjectSearch();
		Thread.sleep(2000);
		serPage.clickonlandmarkSearch();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
