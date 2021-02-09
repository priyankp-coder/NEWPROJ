package com.yourinfo.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.youinfo.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "//div[@class='userInfo ng-binding']")
	WebElement LoggedUsername;

	@FindBy(xpath = "//span[@class='versionNo ng-binding']")
	WebElement AppVersion;

	@FindBy(xpath = "//span[contains(@class,'icon submenuIcon icon-generalSearch') ]")
	WebElement ClickOnGeneralSearch;

	@FindBy(xpath="//a[@ui-sref='tools']")
	WebElement ClickOnTool;

	@FindBy(xpath="//a[@ui-sref='specializedTools']")
	WebElement ClickOnSpecTool;

	@FindBy(xpath="//a[@ui-sref='valuationTools']")
	WebElement ClickOnValuationTool;

	@FindBy(xpath="//a[@ui-sref='rental']")
	WebElement ClickOnRental;

	@FindBy(xpath="//a[@ui-sref='reports']")
	WebElement ClickOnReport;

	@FindBy(xpath="//a[@ui-sref='administration' and @href='#/administration']")
	WebElement ClickOnAdministration;	

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	public String AppVersionNumber() {
		return AppVersion.getText();
		
	}
	public String LoggedUserName()
	{
		return LoggedUsername.getText();
	}
	public void ClickGeneralSearch() {
		ClickOnGeneralSearch.click();
	}
	public ToolsPage ClickTools() throws Exception {
		ClickOnTool.click();
		return new ToolsPage();
	}
	public SpecializedToolsPage ClickspecializedTools() throws IOException 
	{
		ClickOnSpecTool.click();
		return new SpecializedToolsPage();
		
	}
	public ValuationToolsPage ClickValuation() throws IOException {
		ClickOnValuationTool.click();
		return new ValuationToolsPage();
		
	}
	public RentalPage ClickRental() throws IOException {
		ClickOnRental.click();
		return new RentalPage();
	}
	public ReportPage ClickReport() throws IOException {
		ClickOnRental.click();
		return new ReportPage();
	}
	public AdminPage clickOnAdmin() throws IOException, InterruptedException
	{
		JavascriptExecutor abc =  (JavascriptExecutor)driver;
		abc.executeScript("document.querySelector('.menuList').scrollTop=625");
	
		ClickOnAdministration.click();
		return new AdminPage();
	}
}
