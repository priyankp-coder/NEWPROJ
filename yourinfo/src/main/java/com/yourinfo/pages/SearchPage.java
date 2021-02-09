package com.yourinfo.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.youinfo.base.TestBase;

public class SearchPage extends TestBase {

	//Xpath click on General Search
	@FindBy(xpath = "//span[contains(@class,'icon submenuIcon icon-generalSearch')]")
	WebElement clickonGensearch;

	@FindBy(xpath ="//gensearch-component//button[@ng-click=\"genSrchCtrl.tab='buildings'\"]")
	WebElement clickonBuilding;

	@FindBy(xpath="/html/body/app-root/app-body/div/app-display-content/div/map-component"
			+ "/filters-component/div/ui-view/gensearch-component/div[1]/div[2]/div/form/div"
			+ "/div[3]/div/div[1]/input-component/input[1]")
	WebElement clickonPlot;

	//XPath of community Text-box to click on it
	@FindBy(xpath = "/html/body/app-root/app-body/div/app-display-content/div/map-component"
			+ "/filters-component/div/ui-view/gensearch-component/div[1]/div[2]/div/form/div"
			+ "/div[3]/div/div[1]/input-component/input[2]")
	WebElement ClickonCommunity;

	//xpath of Building Search button
	@FindBy(xpath="//button[@id='building_search_button']")
	WebElement ClickonBuildingSearch;

	//xpath click on Building Dropdown 
	@FindBy(xpath="//app-body/div[@id='bodyWrapper']/app-display-content[1]/div[1]"
			+ "/map-component[1]/filters-component[1]/div[1]/ui-view[1]/gensearch-component[1]"
			+ "/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/select[1]")
	WebElement clickonBuildingDropdownElement;

	//xpath buildig name 
	@FindBy(xpath = "//body[1]/app-root[1]/app-body[1]/div[1]/app-display-content[1]/div[1]/"
			+ "map-component[1]/filters-component[1]/div[1]/ui-view[1]/gensearch-component[1]"
			+ "/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[2]/table[1]/tbody[1]/tr[2]/td[1]/div[2]")
	WebElement buildingname;

	//Xpath of Plot Info Community Name
	@FindBy(xpath="//tbody/tr[8]/td[1]/div[2]")
	WebElement BuildingSearchCommunityName; 

	@FindBy(xpath="//span[contains(text(),'Advanced Search By Owner')]")
	WebElement ClickOnAdvSearchByOwner;

	@FindBy(xpath="//span[contains(text(),'Search By Developer')]")
	WebElement ClickonSearchByDeveloper;

	@FindBy(xpath="//span[contains(text(),'Search Projects')]")
	WebElement ClickonSearchByProject;

	@FindBy(xpath="//app-body/div[@id='bodyWrapper']/app-menubar[1]/div[2]/div[2]/a[5]/span[1]")
	WebElement ClickonSearchByMajorProject;

	@FindBy(xpath="//app-body/div[@id='bodyWrapper']/app-menubar[1]/div[2]/div[2]/a[6]/span[2]")
	WebElement ClickonSearchLandmark;


	public SearchPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	public void SearchByBuilding(String CommNamme) throws InterruptedException
	{

		clickonGensearch.click();
		clickonBuilding.click();
		clickonPlot.click();
		ClickonCommunity.sendKeys(CommNamme);
		Thread.sleep(2000);
		ClickonCommunity.sendKeys(Keys.DOWN);
		ClickonCommunity.sendKeys(Keys.DOWN);
		ClickonCommunity.sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		ClickonCommunity.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		ClickonBuildingSearch.click();
	}

	public String clickonBuildingDropdown(){

		Select abc = new Select(clickonBuildingDropdownElement);
		abc.selectByValue("object:407");
		String communityName = BuildingSearchCommunityName.getText();
		System.out.println(communityName);
		Assert.assertEquals(communityName, "Palm Jumeirah");
		return communityName;	
	}
	public String AssertBuildingNameinDetails(){
		String BuildName = buildingname.getText();
		System.out.println(BuildName);
		Assert.assertEquals(BuildName, "AEGEAN");
		return BuildName;
	}
	public void clickonOwnerSearch(){
		ClickOnAdvSearchByOwner.click();
	}
	public void clickonDeveloperSearch(){
		ClickonSearchByDeveloper.click();
	}
	public void clickonProjectSearch(){
		ClickonSearchByProject.click();
	}
	public void clickonMajorProjectSearch(){
		ClickonSearchByMajorProject.click();
	}
	public void clickonlandmarkSearch() throws InterruptedException{

		JavascriptExecutor SRC = (JavascriptExecutor)driver; SRC.executeScript("document.querySelector(\".subMenuList\").scrollTop=320");

		
		ClickonSearchLandmark.click();
	}
}
